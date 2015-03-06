package cs213.photoAlbum.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Creates User objects that store all user data, including PhotoAlbums and Photos.
 * @author Jason Davis and Michael Newman
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	private String userId;
	private String userName;
	
	private HashMap<String, PhotoAlbum> photoAlbumMap;
	private HashMap<String, Photo> photoMap;
	private HashMap<String, HashMap<String, Tag>> tagMap;
	
	/**
	 * Creates a User with the given userId and name.
	 * @param userId
	 * @param userName
	 */
	public User(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
		photoAlbumMap = new HashMap<String, PhotoAlbum>();
		photoMap = new HashMap<String, Photo>();
		tagMap = new HashMap<String, HashMap<String, Tag>>();
	}
	
	
	
	
	
	/**
	 * @return Returns the userId of the User.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the userId of the User.
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return Returns the name of the User.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the name of the User.
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
	
	/**
	 * Adds a PhotoAlbum to be stored in the User.
	 * @param album
	 */
	public void addAlbum(PhotoAlbum album) {
		photoAlbumMap.put(album.getAlbumName(), album);
	}
	
	/**
	 * Deletes a PhotoAlbum from the User.
	 * @param album
	 */
	public void deleteAlbum(PhotoAlbum album) {
		photoAlbumMap.remove(album.getAlbumName());
	}
	
	/**
	 * @param albumName
	 * @return Returns a PhotoAlbum of the current User if it exists, otherwise returns null.
	 */
	public PhotoAlbum getAlbum(String albumName) {
		PhotoAlbum album = photoAlbumMap.get(albumName);
		return album;
	}
	
	/**
	 * Renames a PhotoAlbum of the current User and updates all references to that PhotoAlbum for all Photos in it.
	 * @param album
	 * @param newAlbumName
	 */
	public void renameAlbum(PhotoAlbum album, String newAlbumName) {
		String oldAlbumName = album.getAlbumName(); 
		for (Photo photo : album.getPhotoList()) {
			album.setAlbumName(oldAlbumName);
			photo.deleteAlbum(album);
			album.setAlbumName(newAlbumName);
			photo.addAlbum(album);
		}
		photoAlbumMap.remove(oldAlbumName);
		photoAlbumMap.put(newAlbumName, album);
	}
	
	/**
	 * @return Returns a list of PhotoAlbums belonging to the current User.
	 */
	public LinkedList<PhotoAlbum> getAlbumList() {
		LinkedList<PhotoAlbum> photoAlbumList = new LinkedList<PhotoAlbum>();
		for (PhotoAlbum photoAlbum : photoAlbumMap.values())
			photoAlbumList.add(photoAlbum);
		return photoAlbumList;
	}
	
	/**
	 * Adds a Photo to the master map of Photos of the current User.
	 * @param photo
	 */
	public void addPhoto(Photo photo) {
		photoMap.put(photo.getFileName(), photo);
	}
	
	/**
	 * Deletes a Photo from the master map of Photos of the current User.
	 * @param photo
	 */
	public void deletePhoto(Photo photo) {
		photoMap.remove(photo.getFileName());
	}
	
	/**
	 * @param fileName
	 * @return Returns a Photo with the given fileName from the master map of Photos if it exists, otherwise returns null.
	 */
	public Photo getPhoto(String fileName) {
		return photoMap.get(fileName);
	}
	
	/**
	 * @return Returns a list of all Photos of the current User.
	 */
	public ArrayList<Photo> getPhotoList() {
		ArrayList<Photo> photoList = new ArrayList<Photo>();
		for (Photo photo : photoMap.values()) {
			photoList.add(photo);
		}
		return photoList;
	}
	
	/**
	 * Adds a Tag to the master map of Tags of the current User.
	 * @param tag
	 */
	public void addTag(Tag tag) {
		String tagType = tag.getType();
		String tagValue = tag.getValue();
		HashMap<String, Tag> tagValueMap = tagMap.get(tagType);
		if (tagValueMap == null) {
			tagValueMap = new HashMap<String, Tag>();
			tagMap.put(tagType, tagValueMap);
			tagValueMap.put(tagValue, tag);
		} else {
			tagValueMap.put(tagValue, tag);
		}
			
	}
	
	/**
	 * Deletes the given Tag from the master map of Tags of the current User.
	 * @param tag
	 */
	public void deleteTag(Tag tag) {
		tagMap.get(tag.getType()).remove(tag.getValue());
	}
	
	/**
	 * @param tagType
	 * @param tagValue
	 * @return Returns a Tag with the given type and value from the master map of Tags if it exists, otherwise returns null.
	 */
	public Tag getTag(String tagType, String tagValue) {
		HashMap<String, Tag> tagValueMap = tagMap.get(tagType);
		if (tagValueMap == null) {
			return null;
		} else {
			return tagValueMap.get(tagValue);
		}
	}
	
	public LinkedList<Tag> getTagListByValue(String tagValue) {
		LinkedList<Tag> tagList = new LinkedList<Tag>();
		for (HashMap<String, Tag> tagValueMap : tagMap.values()) {
			// TODO null check on tagValueMap or no?
			for (Tag tag : tagValueMap.values()) {
				if (tag.getValue().equals(tagValue)) {
					if (!tagList.contains(tag)) {
						tagList.add(tag);
					}
				}
			}
		}
		
		return tagList;
	}
	
}
