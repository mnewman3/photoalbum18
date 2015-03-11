package cs213.photoAlbum.model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Creates Photo objects that store photo data, including Tags.
 * @author Jason Davis and Michael Newman
 */
public class Photo implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	private String fileName;
	private String caption;
	private Calendar calendar;
	
	private HashMap<String, HashMap<String, Tag>> tagMap;
	private HashMap<String, PhotoAlbum> albumMap;
	
	/**
	 * Creates a Photo with the given details.
	 * @param fileName
	 * @param caption
	 */
	public Photo(String fileName, String caption) {
		this.fileName = fileName;
		this.caption = caption;
		tagMap = new HashMap<String, HashMap<String, Tag>>();
		albumMap = new HashMap<String, PhotoAlbum>();
		
		File file = new File(fileName);
		calendar = Calendar.getInstance();
		calendar.setTimeInMillis(file.lastModified());
		calendar.set(Calendar.MILLISECOND, 0);
	}
	
	
	
	
	
	/**
	 * @return Returns the file name of the Photo.
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name of the Photo.
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return Returns the caption of the Photo.
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * Sets the caption of the Photo.
	 * @param caption
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * @return Returns the date the Photo was taken as a Calendar instance.
	 */
	public Calendar getDate() {
		return calendar;
	}
	
	/**
	 * @return Returns the date the Photo was taken as a formatted String.
	 */
	public String getFormattedDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss");
		String date = df.format(calendar.getTime());
		return date;
	}
	
	
	
	/**
	 * Adds the given Tag to the Photo.
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
	 * Deletes the given Tag from the Photo.
	 * @param tag
	 */
	public void deleteTag(Tag tag) {
		tagMap.get(tag.getType()).remove(tag.getValue());
	}
	
	/**
	 * @param tagType
	 * @param tagValue
	 * @return Returns a Tag from the Photo if it exists, otherwise returns null.
	 */
	public Tag getTag(String tagType, String tagValue) {
		HashMap<String, Tag> tagValueMap = tagMap.get(tagType);
		if (tagValueMap == null) {
			return null;
		} else {
			return tagValueMap.get(tagValue);
		}
		
	}
	
	/**
	 * @return Returns a list of Tags for the Photo.
	 */
	public LinkedList<Tag> getTagList() {
		LinkedList<Tag> tagList = new LinkedList<Tag>();
		for (HashMap<String, Tag> tagValueMap : tagMap.values()) {
			for (Tag tag : tagValueMap.values()) {
				tagList.add(tag);
			}
		}
		
		return tagList;
	}
	
	/**
	 * Adds a PhotoAlbum to the map of PhotoAlbums the Photo exists in.
	 * @param album
	 */
	public void addAlbum(PhotoAlbum album) {
		albumMap.put(album.getAlbumName(), album);
	}
	
	/**
	 * Removes a PhotoAlbum from the map of PhotoAlbums the Photo exists in.
	 * @param album
	 */
	public void deleteAlbum(PhotoAlbum album) {
		albumMap.remove(album.getAlbumName());
	}
	
	/**
	 * @return Returns a list of PhotoAlbums the Photo exists in.
	 */
	public LinkedList<PhotoAlbum> getPhotoAlbumList() {
		LinkedList<PhotoAlbum> albumList = new LinkedList<PhotoAlbum>();
		for (PhotoAlbum album : albumMap.values()) {
			albumList.add(album);
		}
		return albumList;
	}
	
	/**
	 * @return Returns the number of PhotoAlbums a particular Photo is in.
	 */
	public int getNumAlbumsIn() {
		return albumMap.size();
	}
	


}
