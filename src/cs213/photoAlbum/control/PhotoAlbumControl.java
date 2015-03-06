package cs213.photoAlbum.control;

import java.util.ArrayList;
import java.util.LinkedList;

import cs213.photoAlbum.model.Photo;
import cs213.photoAlbum.model.PhotoAlbum;
import cs213.photoAlbum.model.User;

/**
 * Interface defining the necessary methods for the PhotoAlbum control.
 * @author Jason Davis and Michael Newman
 */
public interface PhotoAlbumControl {
	
	/**
	 * Adds a new User to the database.
	 * @param userId
	 * @param userName
	 */
	public void addUser(String userId, String userName) throws Exception;
	
	/**
	 * Deletes a current User from the database.
	 * @param userId
	 */
	public void deleteUser(String userId) throws Exception;
	
	/**
	 * @return Returns a list of current Users in the database.
	 */
	public LinkedList<User> listUsers();
	
	/**
	 * Creates an album with the given album name for the current user.
	 * @param albumName
	 */
	public void createAlbum(String albumName) throws Exception;
	
	/**
	 * Deletes the album with the given album name from the current user.
	 * @param albumName
	 */
	public void deleteAlbum(String albumName) throws Exception;
	
	/**
	 * Prints album information of all albums for the current user.
	 */
	public LinkedList<PhotoAlbum> listAlbums();
	
	/**
	 * Prints photo information of all photos in the given album.
	 * @param albumName
	 */
	public ArrayList<Photo> listPhotos(String albumName);
	
	/**
	 * Creates and adds a photo to the given album.
	 * @param fileName
	 * @param caption
	 * @param albumName
	 */
	public void addPhoto(String fileName, String caption, String albumName) throws Exception;
	
	/**
	 * Moves a photo from one existing album to another.
	 * @param fileName
	 * @param oldAlbum
	 * @param newAlbum
	 */
	public void movePhoto(String fileName, String oldAlbum, String newAlbum) throws Exception;
	
	/**
	 * Deletes the photo with the given file name from the given album.
	 * @param fileName
	 * @param albumName
	 */
	public void removePhoto(String fileName, String albumName) throws Exception;

	/**
	 * Adds a tag to the photo with the given file name.
	 * @param fileName
	 * @param tagDetails
	 */
	public void addTag(String fileName, String tagType, String tagValue) throws Exception;
	
	/**
	 * Deletes the tag with the given tag details from the photo with the given file name.
	 * @param fileName
	 * @param tagDetails
	 */
	public void deleteTag(String fileName, String tagType, String tagValue) throws Exception;
	
	/**
	 * @param fileName
	 * @return Returns a Photo object if it exists, otherwise returns null.
	 */
	public Photo getPhoto(String fileName);
	
	/**
	 * @param startDate
	 * @param endDate
	 * @return Returns a list of Photos taken within the given range of dates, in chronological order.
	 */
	public ArrayList<Photo> getPhotosByDate(String startDate, String endDate);
	
	/**
	 *
	 * @param tagDetailsArray
	 * @return Returns an ArrayList<Photo> of all Photos with the given tags, sorted by date.
	 */
	public ArrayList<Photo> getPhotosByTag(String[][] tagDetailsArray);
	
	/**
	 * Sets the current User of the control.
	 */
	public void login(String userId) throws Exception;
	
	/**
	 * Saves the current user information and exits the program.
	 */
	public void logout();
	
}
