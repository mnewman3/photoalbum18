package cs213.photoAlbum.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Creates PhotoAlbum objects that store album data and Photos.
 * @author Jason Davis and Michael Newman
 */
public class PhotoAlbum implements Serializable {
	
	private static final long serialVersionUID = 1;

	private String albumName;
	private HashMap<String, Photo> photoMap;
	
	/**
	 * Creates a PhotoAlbum with the given album name.
	 * @param albumName
	 */
	public PhotoAlbum(String albumName) {
		this.albumName = albumName;
		photoMap = new HashMap<String, Photo>();
	}
	
	/**
	 * @return Returns the name of the PhotoAlbum.
	 */
	public String getAlbumName() {
		return albumName;
	}
	
	/**
	 * Sets the name of the PhotoAlbum.
	 * @param albumName
	 */
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	
	/**
	 * Adds the given Photo to the PhotoAlbum.
	 * @param photo
	 */
	public void addPhoto(Photo photo) {
		photoMap.put(photo.getFileName(), photo);
	}
	
	/**
	 * Deletes a photo with the given file name from the PhotoAlbum.
	 * @param fileName
	 */
	public void deletePhoto(Photo photo) {
		photoMap.remove(photo.getFileName());
	}
	
	/**
	 * @param photo
	 * @return Returns a Photo from the PhotoAlbum if it exists, otherwise returns null.
	 */
	public Photo getPhoto(String fileName) {
		return photoMap.get(fileName);
	}
	
	/**
	 * @return Returns a list of Photos.
	 */
	public ArrayList<Photo> getPhotoList() {
		ArrayList<Photo> photoList = new ArrayList<Photo>();
		for (Photo photo : photoMap.values())
			photoList.add(photo);
		return photoList;
	}
	
	/**
	 * @return Returns the number of Photos in the PhotoAlbum.
	 */
	public int getNumPhotos() {
		return photoMap.size();
	}
	
	/**
	 * @return Returns a Date/Calendar for the date of the least recently taken Photo in the PhotoAlbum.
	 */
	public String getStartdate() {		
		ArrayList<Photo> photoList = getPhotoList();
		if (photoList.size() == 0) return null;
		Collections.sort(photoList, new Comparator<Photo>() {
			
			@Override
			public int compare(Photo lhs, Photo rhs) {
				// TODO test to see if this works
				return lhs.getDate().compareTo(rhs.getDate());
			}
		});
		
		DateFormat df = new SimpleDateFormat("MM/DD/YY-HH:MM:SS");
		String startDate = df.format(photoList.get(0).getDate().getTime());
		
		return startDate;
	}
	
	/**
	 * @return Returns a Date/Calendar for the date of the most recently taken Photo in the PhotoAlbum.
	 */
	public String getEndDate() {
		ArrayList<Photo> photoList = getPhotoList();
		if (photoList.size() == 0) return null;
		Collections.sort(photoList, new Comparator<Photo>() {
			
			@Override
			public int compare(Photo lhs, Photo rhs) {
				// TODO test to see if this works
				return lhs.getDate().compareTo(rhs.getDate());
			}
		});
		
		DateFormat df = new SimpleDateFormat("MM/DD/YY-HH:MM:SS");
		String endDate = df.format(photoList.get(photoList.size()-1).getDate().getTime());
		
		return endDate;
	}
	
}
