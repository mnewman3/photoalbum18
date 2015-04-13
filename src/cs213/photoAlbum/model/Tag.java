package cs213.photoAlbum.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Creates Tag objects given a type and details
 * @author Jason Davis and Michael Newman
 */
public class Tag implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	private String type;
	private String value;
	private HashMap<String, Photo> photoMap;
	
	/**
	 * Creates a Tag with the given tag details.
	 * @param type
	 * @param value
	 */
	public Tag(String type, String value) {
		this.type = type;
		this.value = value;
		photoMap = new HashMap<String, Photo>();
	}
	
	
	
	
	
	/**
	 * @return Returns the type of the tag.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type of the tag.
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return Returns the value of the tag.
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the value of the tag.
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
	
	/**
	 * Adds a Photo to the map of Photos the Tag exists in.
	 * @param photo
	 */
	public void addPhoto(Photo photo) {
		photoMap.put(photo.getFileName(), photo);
	}
	
	/**
	 * Removes a Photo from the map of Photos the Tag exists in.
	 * @param photo
	 */
	public void deletePhoto(Photo photo) {
		photoMap.remove(photo.getFileName());
	}
	
	/**
	 * @return Returns a list of Photos the Tag exists in.
	 */
	public LinkedList<Photo> getPhotoList() {
		LinkedList<Photo> photoList = new LinkedList<Photo>();
		for (Photo photo : photoMap.values()) {
			photoList.add(photo);
		}
		return photoList;
	}
	
	/**
	 * @return Returns the number of Photos a Tag exists in.
	 */
	public int getNumPhotosIn() {
		return photoMap.size();
	}
	
	/**
	 * Checks if two Tags are equal.
	 */
	public boolean equals(Object tag) {
		if (tag instanceof Tag) {
			tag = (Tag)tag;
			return (this.type.equals(((Tag) tag).type) && this.value.equals(((Tag) tag).value));
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "[" + type + ", " + value + "]";
	}

}
