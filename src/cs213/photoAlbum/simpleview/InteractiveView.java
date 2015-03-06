package cs213.photoAlbum.simpleview;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cs213.photoAlbum.control.Control;
import cs213.photoAlbum.model.*;
import cs213.photoAlbum.util.*;

public class InteractiveView {
	
	/**
	 * Parses interactive mode input for syntactical correctness and calls the appropriate method from the Control.
	 * @throws Exception
	 */
	public static void interactiveMode(Control control) throws Exception {
		
		// set up variable that will be used on each iteration
		Scanner scan = new Scanner(System.in);
		String line;
		List<String> commandList;
		
		// loop indefinitely, until the user issues a logout command
		while(true) {
			line = scan.nextLine();
			
			commandList = new ArrayList<String>();
			Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"");
			Matcher regexMatcher = regex.matcher(line);
			String command;
			
			// first command should be unquoted otherwise bad
			if(regexMatcher.find() && regexMatcher.group() != null) {
				command = regexMatcher.group();
				commandList.add(command);
			} else {
				System.out.println("Error: Invalid Command");
				continue;
			}
			
			if (command.equals("getPhotosByTag")) {
				for(String arg : line.substring(command.length()).split(",")) {
					arg = arg.trim();
					commandList.add(arg);
				}
			} else if (command.equals("getPhotosByDate")) {
				for(String arg : line.substring(command.length()).split("\\s+")) {
					if(!arg.equals("")) {
						commandList.add(arg);						
					}
				}
			} else {
				// gets command and arguments using the regex above
				while (regexMatcher.find()) {
				    if (regexMatcher.group(1) != null) {
				        // add double-quoted string without the quotes
				        commandList.add(regexMatcher.group(1));
				    } else {
				        // add unquoted word
				    	String [] commands = regexMatcher.group().split(":");
				    	if (commands.length == 2) {
				    		commandList.add(commands[0]);
				    		commandList.add(commands[1]);
				    	} else if (commands.length < 2) {
				    		commandList.add(commands[0]);
				    	} else {
				    		commandList = null;
				    		break;
				    	}
				    }
				}
			}
				
			if(commandList == null || commandList.size() == 0) {
				System.out.println("Error: invalid input");
				continue;
			}
						
			switch(commandList.get(0)) {
				case "createAlbum":
					createAlbum(control, commandList);
					break;
				case "deleteAlbum":
					deleteAlbum(control, commandList);
					break;
				case "listAlbums":
					listAlbums(control, commandList);
					break;
				case "listPhotos":
					listPhotos(control, commandList);
					break;
				case "addPhoto":
					addPhoto(control, commandList);
					break;
				case "movePhoto":
					movePhoto(control, commandList);
					break;
				case "removePhoto":
					removePhoto(control, commandList);
					break;
				case "addTag":
					addTag(control, commandList);
					break;
				case "deleteTag":
					deleteTag(control, commandList);
					break;
				case "listPhotoInfo":
					listPhotoInfo(control, commandList);
					break;
				case "getPhotosByDate":
					getPhotosByDate(control, commandList);
					break;
				case "getPhotosByTag":
					getPhotosByTag(control, commandList, line);
					break;
				case "logout":
					scan.close();
					control.logout();
					break;
			 	default:
			 		System.out.println("Error: Invalid Command");
			}
			 
		}
	}
	
	static void createAlbum(Control control, List<String> commandList){
		if (commandList.size() == 2) {
			try {
				control.createAlbum(commandList.get(1));
				System.out.println("created album for user " + control.getCurrentUserId() + ":\n" + commandList.get(1));
			} catch (Exception e) {
				System.out.println("album exists for user " + control.getCurrentUserId() + ":\n" + commandList.get(1));
			}
		} else {
			System.out.println("Error: invalid input (createAlbum takes in one argument)");
		}
	}
	
	static void deleteAlbum(Control control, List<String> commandList) {
		if (commandList.size() == 2) {
			try {
				control.deleteAlbum(commandList.get(1));
				System.out.println("deleted album from user " + control.getCurrentUserId() + ":\n" + commandList.get(1));
			} catch (Exception e) {
				System.out.println("album does not exist for user " + control.getCurrentUserId() + ":\n" + commandList.get(1));
			}
		} else {
			System.out.println("Error: invalid input (deleteAlbum takes in one argument)");
		}
	}
	
	static void listAlbums(Control control, List<String> commandList) {
		if (commandList.size() == 1) {
			LinkedList<PhotoAlbum> albumList = control.listAlbums();
			String userId = control.getCurrentUserId();
			
			if (albumList == null) {
				System.out.println("No albums exist for user " + userId);
				return;
			}
			
			System.out.println("Albums for user " + userId + ":");
			for (PhotoAlbum album : albumList) {
				System.out.print(album.getAlbumName() + " number of photos: " + album.getNumPhotos());
				String startDate = album.getStartdate();
				String endDate = album.getEndDate();
				if (startDate == null || endDate == null) {
					System.out.println();
					continue;
				}
				System.out.println(", " + album.getStartdate() + " - " + album.getEndDate());
			}
		} else {
			System.out.println("Error: invalid input (listAlbums takes in one argument)");
		}
	}

	static void listPhotos(Control control, List<String> commandList) {
		if (commandList.size() == 2) {
			String albumName = commandList.get(1);
			ArrayList<Photo> photoList = control.listPhotos(albumName);
			
			if(photoList == null) {
				System.out.println("album does not exist for user" + control.getCurrentUserId());
				return;
			}
			
			System.out.println("Photos for album " + albumName + ":");
			for(Photo photo : photoList) {
				System.out.println(photo.getFileName() + " - " + photo.getFormattedDate());
			}
		} else {
			System.out.println("Error: invalid input (listPhotos takes in one argument)");
		}
	}
	
	static void addPhoto(Control control, List<String> commandList) {
		if(commandList.size() == 4) {
			String fileName = commandList.get(1);
			String caption = commandList.get(2);
			String albumName = commandList.get(3);
			
			try {
				fileName = getFullFileName(fileName);
			} catch (Exception e){
				System.out.println("File " + fileName + " does not exist");
				return;
			}
			
			try {
				control.addPhoto(fileName, caption, albumName);
			} catch (Exception e) {
				if (e instanceof AlbumException) {
					System.out.println("album does not exist for user " + control.getCurrentUserId() + ":\n" + albumName);
				} else if (e instanceof PhotoException) {
					System.out.println("Photo " + fileName + " already exists in album " + albumName);
				} else {
					System.out.println("File " + fileName + " does not exist");
				}
				return;
			}
			
			System.out.println("Added photo " + fileName + ":");
			System.out.println(control.getPhoto(fileName).getCaption() + " - Album: " + albumName);
			
		} else {
			System.out.println("Error: invalid input (addPhoto takes in three arguments, \"<fileName>\" \"<caption>\" \"<albumName>\")");
		}
	}
	
	static void movePhoto(Control control, List<String> commandList) {
		if (commandList.size() == 4) {
			String fileName = commandList.get(1);
			String oldAlbumName = commandList.get(2);
			String newAlbumName = commandList.get(3);
			
			try {
				fileName = getFullFileName(fileName);
			} catch (Exception e) {
				System.out.println("Photo " + fileName + " does not exist");
				return;
			}
			
			try {
				control.movePhoto(fileName, oldAlbumName, newAlbumName);				
			} catch (Exception e) {
				if (e instanceof AlbumException) {
					System.out.println("album " + oldAlbumName + " does not exist for user " + control.getCurrentUserId());
				} else if (e instanceof PhotoException) {
					System.out.println("Photo " + fileName + " does not exist in " + oldAlbumName);
				} else {
					System.out.println("album " + newAlbumName + " does not exist for user " + control.getCurrentUserId());
				}
				return;
			}
			
			System.out.println("Moved photo " + fileName + ":");
			System.out.println(fileName + " - From album " + oldAlbumName + " to album " + newAlbumName);
			
		} else {
			System.out.println("Error: invalid input (movePhoto takes in three arguments, \"<fileName>\" \"<oldAlbumName>\" \"<newAlbumName>\")");
		}
	}
	
	static void removePhoto(Control control, List<String> commandList) {
		if (commandList.size() == 3) {
			String fileName = commandList.get(1);
			String albumName = commandList.get(2);
			
			try {
				fileName = getFullFileName(fileName);
			} catch (Exception e) {
				System.out.println("Photo " + fileName + " does not exist");
				return;
			}
			
			try {
				control.removePhoto(fileName, albumName);
			} catch (Exception e) {
				if (e instanceof AlbumException) {
					System.out.println("album " + albumName + " does not exist for user " + control.getCurrentUserId());
				} else {
					System.out.println("Photo " + fileName + " is not in the album " + albumName);
				}
				return;
			}
			System.out.println("Removed photo:\n" + fileName + " - From album " + albumName);
			
		} else {
			System.out.println("Error: invalid input (removePhoto takes in two arguments, \"<fileName>\" \"<albumName>\")");
		}
	}
	
	static void addTag(Control control, List<String> commandList) {
		if (commandList.size() == 4) {
			String fileName = commandList.get(1);
			String tagType = commandList.get(2);
			String tagValue = commandList.get(3);
			
			try {
				fileName = getFullFileName(fileName);
			} catch (Exception e) {
				System.out.println("Photo " + fileName + " does not exist");
				return;
			}
			
			try {
				control.addTag(fileName, tagType, tagValue);
			} catch (Exception e) {
				System.out.println("Tag already exists for " + fileName + " " + tagType + ":" + tagValue);
				return;
			}
			
			System.out.println("Added tag:\n" + fileName + " " + tagType + ":" + tagValue);
			
		} else {
			System.out.println("Error: invalid input (addTag takes in three arguments, \"<fileName>\" <tagType>:\"<tagValue>\")");
		}
	}
	
	static void deleteTag(Control control, List<String> commandList) {
		if (commandList.size() == 4) {
			String fileName = commandList.get(1);
			String tagType = commandList.get(2);
			String tagValue = commandList.get(3);
			
			try {
				fileName = getFullFileName(fileName);
			} catch (Exception e) {
				System.out.println("Photo " + fileName + " does not exist");
				return;
			}
			
			try {
				control.deleteTag(fileName, tagType, tagValue);
			} catch (Exception e) {
				System.out.println("Tag does not exist for " + fileName + " " + tagType + ":" + tagValue);
				return;
			}
			
			System.out.println("Deleted tag:\n" + fileName + " " + tagType + ":" + tagValue);
			
		} else {
			System.out.println("Error: invalid input (deleteTag takes in three arguments, \"<fileName>\" <tagType>:\"<tagValue>\")");
		}
	}
	
	static void listPhotoInfo(Control control, List<String> commandList) {
		if (commandList.size() == 2) {
			String fileName = commandList.get(1);
			Photo photo;
			
			try {
				fileName = getFullFileName(fileName);
			} catch (Exception e) {
				System.out.println("Photo " + fileName + " does not exist");
				return;
			}
			
			try {
				photo = control.getPhoto(fileName);
			} catch (Exception e) {
				System.out.println("Photo " + fileName + " does not exist");
				return;
			}
			
			if(photo == null) {
				System.out.println("Photo " + fileName + " does not exist");
				return;
			}
			
			System.out.println("Photo file name: " + fileName);
			System.out.print("Album: ");
			List<PhotoAlbum> albumList = photo.getPhotoAlbumList();
			System.out.print(albumList.get(0).getAlbumName());
			for(int i = 1; i < albumList.size(); i++) {
				System.out.print("," + albumList.get(i).getAlbumName());
			}
			System.out.println("Date: " + photo.getFormattedDate());
			System.out.println("Caption: " + photo.getCaption());
			System.out.println("Tags:");
			for(Tag tag : photo.getTagList()) {
				System.out.println(tag.getType() + ":" + tag.getValue());
			}
			
		} else {
			System.out.println("Error: invalid input (listPhotoInfo takes in one argument)");
		}
	}
	
	static void getPhotosByDate(Control control, List<String> commandList) {
		if (commandList.size() == 3 && !commandList.get(1).equals("") && !commandList.get(2).equals("")) {
			String startDate = commandList.get(1);
			String endDate = commandList.get(2);
			
			System.out.println("Photos for user " + control.getCurrentUserId() + " in range " + startDate + " to " + endDate + ":");
			
			List<Photo> photoList = control.getPhotosByDate(startDate, endDate);
			
			if(photoList == null || photoList.size() == 0) {
				return;
			}
			
			for(Photo photo : photoList) {
				System.out.print(photo.getCaption() + " - Album: ");
				
				List<PhotoAlbum> albumList = photo.getPhotoAlbumList();
				System.out.print(albumList.get(0).getAlbumName());
				for(int i = 1; i < albumList.size(); i++) {
					System.out.print("," + albumList.get(i).getAlbumName());
				}
				
				System.out.print(" - Date: " + photo.getDate());
				System.out.println();
			}
			
		} else {
			System.out.println("Error: invalid input (getPhotosByDate takes in two argument <startDate> <endDate>)");	
		}
	}
	
	static void getPhotosByTag(Control control, List<String> commandList, String line) {
		int numTags = commandList.size();
		if (numTags != 0) {
			List<Photo> photoList;
			String [][] tagDetailsArray = new String[numTags][2];
			for(int i = 1; i < numTags; i++) {
				String command = commandList.get(i);
				if(command.indexOf(':') < 0) {
					tagDetailsArray[i][0] = null;	// tag type
					tagDetailsArray[i][1] = command.replaceAll("\"", "");	// tag detail
				} else {
					String[] typeAndDetail = command.split(":");
					tagDetailsArray[i][0] = typeAndDetail[0];	// tag type
					tagDetailsArray[i][1] = typeAndDetail[1].replaceAll("\"", "");	// tag detail
				}
			}
			
			photoList = control.getPhotosByTag(tagDetailsArray);
			String searchString = line.substring(commandList.get(0).length() + 1);
			System.out.println("Photos for user " + control.getCurrentUserId() + " with tags " + searchString + ":");
			
			if(photoList == null || photoList.size() == 0) {
				return;
			}
			
			for(Photo photo : photoList) {
				System.out.println("gotHere");
				System.out.print(photo.getCaption() + " - Album: ");
				
				List<PhotoAlbum> albumList = photo.getPhotoAlbumList();
				System.out.print(albumList.get(0).getAlbumName());
				for(int i = 1; i < albumList.size(); i++) {
					System.out.print("," + albumList.get(i).getAlbumName());
				}
				
				System.out.print(" - Date: " + photo.getDate());
				System.out.println();
			}
			
		} else {
			System.out.println("Error: invalid input (getPhotosByTag must be given some tag value to filter by)");
		}
	}
	
	static String getFullFileName(String fileName) throws Exception {
		File file = new File(fileName);
		if (!file.isFile()) {
			throw new PhotoException();
		}
		return file.getCanonicalPath();
	}
	
}
