package cs213.photoAlbum.control;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;

import cs213.photoAlbum.model.*;
import cs213.photoAlbum.util.*;

/**
 * This class handles the processing/manipulating of user data.
 * @author Jason Davis and Michael Newman
 */
public class Control implements PhotoAlbumControl {
	
	private Backend backend;
	private User currentUser;
	
	/**
	 * Creates an instance of the control to process/manipulate user data.
	 * @param backend
	 * @param userId
	 */
	public Control() {
		backend = new Backend();
	}

	@Override
	public void addUser(String userId, String userName) throws Exception {
		User user = new User(userId, userName);
		if (backend.getUser(userId) == null)
			backend.addUser(user);
		else {
			throw new Exception();
		}
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		User user = backend.getUser(userId);
		if (user == null) {
			throw new Exception();
		} else {
			backend.deleteUser(user);
		}
	}
	
	@Override
	public LinkedList<User> listUsers() {
		return backend.getUserList();
	}
	
	public String getCurrentUserId() {
		return currentUser.getUserId();
	}
	
	@Override
	public void createAlbum(String albumName) throws Exception {
		PhotoAlbum album = currentUser.getAlbum(albumName);
		if (album == null) {
			currentUser.addAlbum(new PhotoAlbum(albumName));
		} else {
			throw new Exception();
		}
	}

	@Override
	public void deleteAlbum(String albumName) throws Exception {
		PhotoAlbum album = currentUser.getAlbum(albumName);
		if (album == null) {
			throw new Exception();
		} else {
			currentUser.deleteAlbum(album);
		}
	}

	@Override
	public LinkedList<PhotoAlbum> listAlbums() {
		LinkedList<PhotoAlbum> albumList = currentUser.getAlbumList();
		if (albumList.size() == 0) {
			return null;
		}
		return albumList;
	}

	@Override
	public ArrayList<Photo> listPhotos(String albumName) {
		PhotoAlbum album = currentUser.getAlbum(albumName);
		if (album == null) {
			return null;
		}
		
		return currentUser.getAlbum(albumName).getPhotoList();
	}

	@Override
	public void addPhoto(String fileName, String caption, String albumName) throws Exception {
		// check if album exists, then check if photo already exists, then check if file exists
		
		PhotoAlbum album = currentUser.getAlbum(albumName);
		if (album == null) {
			throw new AlbumException();
		}
		
		Photo photo = currentUser.getPhoto(fileName);
		if (photo == null) {
			// check if file exists. if it does continue, else error
			File file = new File(fileName);
			if (!file.isFile()) {
				throw new Exception();
			}
			photo = new Photo(file.getCanonicalPath(), caption);
			currentUser.addPhoto(photo);
			album.addPhoto(photo);
			photo.addAlbum(album);
		} else {
			// photo already exists in album <albumname> error
			throw new PhotoException();
		}
	}

	@Override
	public void movePhoto(String fileName, String oldAlbumName, String newAlbumName) throws Exception {
		// check if album exists, then check if photo exists
		
		PhotoAlbum oldAlbum = currentUser.getAlbum(oldAlbumName);
		if (oldAlbum == null) {
			throw new AlbumException();
		}
		
		PhotoAlbum newAlbum = currentUser.getAlbum(newAlbumName);
		if (newAlbum == null) {
			throw new Exception();
		}
		
		Photo photo = oldAlbum.getPhoto(fileName);
		if (photo == null) {
			throw new PhotoException();
		}
		
		photo.deleteAlbum(oldAlbum);
		photo.addAlbum(newAlbum);
		newAlbum.addPhoto(photo);
		oldAlbum.deletePhoto(photo);
	}

	@Override
	public void removePhoto(String fileName, String albumName) throws Exception {
		// check if album exists, then check if photo exists in album
		
		PhotoAlbum album = currentUser.getAlbum(albumName);
		if (album == null) {
			throw new AlbumException();
		}
		
		Photo photo = currentUser.getPhoto(fileName);
		if (photo == null) {
			throw new PhotoException();
		}
		
		photo = album.getPhoto(fileName);
		if (photo == null) {
			throw new PhotoException();
		}
		
		album.deletePhoto(photo);
		photo.deleteAlbum(album);
		LinkedList<Tag> tagList = photo.getTagList();
		for (Tag tag : tagList) {
			tag.deletePhoto(photo);
			if (tag.getNumPhotosIn() == 0) {
				currentUser.deleteTag(tag);
			}
		}
		if (photo.getNumAlbumsIn() == 0) {
			currentUser.deletePhoto(photo);
		}
		
	}
	
	@Override
	public Photo getPhoto(String fileName) {
		return currentUser.getPhoto(fileName);
	}
	
	private String getFullFileName(String fileName) throws Exception {
		File file = new File(fileName);
		if (!file.isFile()) {
			throw new PhotoException();
		}
		return file.getCanonicalPath();
	}

	@Override
	public void addTag(String fileName, String tagType, String tagValue) throws Exception {
		// check if photo exists. if it does, check if tag exists. if it doesnt, then add
		
		Photo photo = currentUser.getPhoto(fileName);
		if (photo == null) {
			throw new PhotoException();
		} 
		
		Tag tag = currentUser.getTag(tagType, tagValue);
		if (tag == null) {
			tag = new Tag(tagType, tagValue);
			tag.addPhoto(photo);
			currentUser.addTag(tag);
			photo.addTag(tag);
		} else {
			// TODO try testing with == also
			if (tag.equals(photo.getTag(tagType, tagValue))) {
				throw new Exception();
			} else {
				tag.addPhoto(photo);
				photo.addTag(tag);
			}
		}
	}

	@Override
	public void deleteTag(String fileName, String tagType, String tagValue) throws Exception {
		// (check if photo exists. if it does,) check if tag exists. if it does, then delete
		
		Photo photo = currentUser.getPhoto(fileName);
		if (photo == null) {
			throw new PhotoException();
		}
		
		Tag tag = currentUser.getTag(tagType, tagValue);
		if (tag == null) {
			throw new Exception();
		} else {
			photo.deleteTag(tag);
			tag.deletePhoto(photo);
			if (tag.getNumPhotosIn() == 0) {
				currentUser.deleteTag(tag);
			}
		}
	}

	@Override
	public ArrayList<Photo> getPhotosByDate(String start, String end) {
		// TODO Auto-generated method stub
		
		Calendar calendarStart = Calendar.getInstance();
		Calendar calendarEnd = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MM/DD/YY-HH:MM:SS");
		try {
			Date startDate = df.parse(start);
			Date endDate = df.parse(end);
			calendarStart.setTime(startDate);
			calendarStart.set(Calendar.MILLISECOND, 0);
			calendarEnd.setTime(endDate);
			calendarEnd.set(Calendar.MILLISECOND, 0);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		// do sanity checks on dates. If either is bad, return null
		
		ArrayList<Photo> photoList = new ArrayList<Photo>();
		
		for (Photo photo : currentUser.getPhotoList()) {
			Calendar photoDate = photo.getDate();
			if (photoDate.compareTo(calendarStart) > 0 && photoDate.compareTo(calendarEnd) < 0) {
				if (!photoList.contains(photo)) {
					photoList.add(photo);
				}
			}
		}
		
		Collections.sort(photoList, new Comparator<Photo>() {
			
			@Override
			public int compare(Photo lhs, Photo rhs) {
				// TODO test to see if this works
				return lhs.getDate().compareTo(rhs.getDate());
			}
		});
		
		return photoList;
	}

	@Override
	public ArrayList<Photo> getPhotosByTag(String[][] tagDetailsArray) {
		ArrayList<Photo> photoList = new ArrayList<Photo>();
		for (int i = 0; i < tagDetailsArray.length; i++) {
			String tagType = tagDetailsArray[i][0];
			String tagValue = tagDetailsArray[i][1];
			if (tagValue == null) {
				LinkedList<Tag> tagList = currentUser.getTagListByType(tagType);
				if (tagList == null) return null;
				for (Tag tag : tagList) {
					for (Photo photo : tag.getPhotoList()) {
						if (!photoList.contains(photo)) {
							photoList.add(photo);
						}
					}
				}
			} else {
				Tag tag = currentUser.getTag(tagType, tagValue);
				if (tag == null) {
					continue;
				} else {
					for (Photo photo : tag.getPhotoList()) {
						if (!photoList.contains(photo)) {
							photoList.add(photo);
						}
					}
				}
			}
		}
		
		Collections.sort(photoList, new Comparator<Photo>() {
			
			@Override
			public int compare(Photo lhs, Photo rhs) {
				// TODO test to see if this works
				return lhs.getDate().compareTo(rhs.getDate());
			}
		});
		
		return photoList;
	}
	
	@Override
	public void login(String userId) throws Exception {
		currentUser = backend.getUser(userId);
		if (currentUser == null) {
			throw new Exception();
		}
	}

	@Override
	public void logout() {
		try {
			backend.writeData();
			System.exit(0);
		} catch (Exception e) {
			// problem
		}
	}
	
	

}
