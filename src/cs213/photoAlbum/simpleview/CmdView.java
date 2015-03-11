package cs213.photoAlbum.simpleview;

import java.util.LinkedList;

import cs213.photoAlbum.control.Control;
import cs213.photoAlbum.model.User;

/**
 * This class handles all input from the user. It parses the input for syntactical correctness and calls the appropriate method from the Backend or Control.
 * @author Jason Davis and Michael Newman
 * 
 */
public class CmdView {
		
	public static void main(String[] args) {
		// Check for valid input. If valid, initializeBackend and call appropriate method
		String userId = "", userName = "";
		
		// check valid input length
		if(args.length < 1 || args.length > 3) {
			// error
			System.out.println("**Invalid input, please enter a valid command**");
			return;
		}
		
		Control control = new Control();
		
		if(args.length > 1) {
			userId = args[1];
		}
		
		if(args.length > 2) {
				userName = args[2];
		}
		
		String command = args[0].toLowerCase().trim();
		
		switch(command) {
			case "listusers": 
				LinkedList<User> userList = control.listUsers();
				if (userList.size() == 0) {
					System.out.println("no users exist");
				} 
				else {
					for (User user: userList) {
						System.out.println(user.getUserId());
					}
				}
				break;
			
			case "adduser":
				if (userId.isEmpty() || userName.isEmpty()) {
					System.out.println("**Invalid input, please specify both the desired user's id and the user's name**");
				}
				else {
					try {
						control.addUser(userId, userName);
						System.out.println("created user " + userId + " with name " + userName);
						control.logout();
					} catch (Exception e) {
						System.out.println("user " + userId + " already exists with name " + userName);
					}
				}
				break;
				
			case "deleteuser":
				if (userId.isEmpty()) {
					System.out.println("**Invalid input, please specify a user to delete**");
				}
				else {
					try {
						control.deleteUser(userId);
						System.out.println("deleted user " + userId);
						control.logout();
					} catch (Exception e) {
						System.out.println("user " + userId + " does not exist");
					}
				}
				break;
			
			case "login":
				if (userId.isEmpty()) {
					System.out.println("**Invalid input, please specify a user to login**");
				} 
				else {
					try {
						control.login(userId);
						try {
							InteractiveView.interactiveMode(control);
						} catch (Exception e) {
							
						}
					} catch (Exception e) {
						System.out.println("user " + userId + " does not exist");
					}
				}
				break;
			
			default:
				System.out.println("**Invalid input, please enter a valid command**");
		}
		
		return;
	}

}
