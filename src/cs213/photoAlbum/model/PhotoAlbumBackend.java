package cs213.photoAlbum.model;

import java.util.LinkedList;

/**
 * Interface defining the necessary methods for the PhotoAlbum model.
 * @author Jason Davis and Michael Newman
 */
public interface PhotoAlbumBackend {
	
	/**
	 * @return Returns a list of all current Users.
	 */
	public LinkedList<User> getUserList();
	
	/**
	 * @param userId
	 * @return User with the given userId.
	 */
	public User getUser(String userId);
	
	/**
	 * Adds a User to the database.
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * Deletes a User from the database
	 * @param user
	 */
	public void deleteUser(User user);
	
}
