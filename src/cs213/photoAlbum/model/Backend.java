package cs213.photoAlbum.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * This class handles the reading/writing of User data and stores all the necessary information.
 * @author Jason Davis and Michael Newman
 */
public class Backend implements PhotoAlbumBackend {
	
	private HashMap<String, User> userMap;
	
	/**
	 * Creates a Backend instance which reads/writes/stores all user data.
	 */
	public Backend() {
		userMap = new HashMap<String, User>();
		try {
			readData();
		} catch (Exception e) {
			
		}
	}
	
	/** 
	 * Read in serialized User data from file.
	 * @throws Exception
	 */
	public void readData() throws Exception {
		String dir = System.getProperty("user.dir") + File.separator + "data" + File.separator + "userData";
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dir));
		userMap = (HashMap<String, User>) ois.readObject();
		ois.close();
	}
	
	/**
	 * Write serialized User data to file.
	 * @throws Exception
	 */
	public void writeData() throws Exception {
		String dir = System.getProperty("user.dir") + File.separator + "data" + File.separator + "userData";
		File file = new File(dir);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(userMap);
		oos.close();
	}
	
	@Override
	public User getUser(String userId) {
		return userMap.get(userId);
	}
	
	@Override
	public void addUser(User user) {
		userMap.put(user.getUserId(), user);
	}
	
	@Override
	public void deleteUser(User user) {
		userMap.remove(user.getUserId());
	}

	@Override
	public LinkedList<User> getUserList() {
		LinkedList<User> userList = new LinkedList<User>();
		for (User user : userMap.values())
			userList.add(user);
		return userList;
	}
	
	
	
	

}
