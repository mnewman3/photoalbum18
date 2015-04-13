package cs213.photoAlbum.simpleview;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import cs213.photoAlbum.control.Control;
import cs213.photoAlbum.model.Backend;
import cs213.photoAlbum.model.User;


/**
*
* @author Jason Davis
*/
public class AdminPanel extends javax.swing.JPanel {
	
    JList<User> userList;
    DefaultListModel<User> userListModel;
    javax.swing.JLabel confirmText;
    javax.swing.JButton createUserButton;
    javax.swing.JButton deleteUserButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    javax.swing.JButton okButton;
    javax.swing.JButton cancelButton;
    javax.swing.JLabel errorLabel;
    javax.swing.JLabel userIdLabel;
    javax.swing.JLabel usernameLabel;
    javax.swing.JTextField userIdEntry;
    javax.swing.JTextField usernameEntry;
    
    private Backend backend;
    boolean creatingUser;

    public AdminPanel(Control control) {
    	backend = control.getBackend();
        initComponents();
        postInit();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

    	jScrollPane1 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<User>();
        jLabel1 = new javax.swing.JLabel();
        createUserButton = new javax.swing.JButton();
        deleteUserButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        confirmText = new javax.swing.JLabel();
        usernameEntry = new javax.swing.JTextField();
        userIdEntry = new javax.swing.JTextField();
        userIdLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));

        userListModel = new DefaultListModel<User>();
        for (User user : backend.getUserList())
        	userListModel.addElement(user);
        userList.setModel(userListModel);
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userList.setLayoutOrientation(JList.VERTICAL);
        
        jScrollPane1.setViewportView(userList);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel1.setText("Users");

        createUserButton.setBackground(new java.awt.Color(0, 51, 204));
        createUserButton.setText("Create User");

        deleteUserButton.setBackground(new java.awt.Color(0, 51, 204));
        deleteUserButton.setText("Delete User");

        okButton.setBackground(new java.awt.Color(0, 51, 204));
        okButton.setText("OK");

        cancelButton.setBackground(new java.awt.Color(0, 51, 204));
        cancelButton.setText("Cancel");

        confirmText.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        confirmText.setText("Are you sure?");

        userIdLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        userIdLabel.setText("User ID:");

        usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        usernameLabel.setText("Username:");

        errorLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("");
        errorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(userIdLabel)
                                            .addComponent(usernameLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(usernameEntry, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(userIdEntry)
                                            .addComponent(confirmText)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(okButton)
                                        .addGap(37, 37, 37)
                                        .addComponent(cancelButton)
                                        .addGap(9, 9, 9)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(deleteUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(createUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(100, 100, 100))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errorLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userIdEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userIdLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmText)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );    
        
        okButton.setVisible(false);
        cancelButton.setVisible(false);
        confirmText.setVisible(false);
        errorLabel.setVisible(false);
        userIdEntry.setVisible(false);
        usernameEntry.setVisible(false);
        userIdLabel.setVisible(false);
        usernameLabel.setVisible(false);
    }
    
    private void postInit() {
    	
    	okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if (creatingUser) {
                	String userId, username;
                	userId = userIdEntry.getText();
                	username = usernameEntry.getText();
                	if(userId.isEmpty() || username.isEmpty()) {
                		errorLabel.setText("Please enter a UserId and a Username");
                		errorLabel.setVisible(true);
                	} else {
                		if (backend.getUser(userId) != null) {
                			errorLabel.setText("User " + userIdEntry.getText() + " already exists with name " + usernameEntry.getText());
                			errorLabel.setVisible(true);
                		} else {
                			User user = new User(userId, username);
                			backend.addUser(user);
                			userListModel.addElement(user);
                			userIdEntry.setText("");
                			usernameEntry.setText("");
                    		okButton.setVisible(false);
                        	cancelButton.setVisible(false);
                        	userIdLabel.setVisible(false);
                        	usernameLabel.setVisible(false);
                        	userIdEntry.setVisible(false);
                        	usernameEntry.setVisible(false);
                        	errorLabel.setVisible(false);
                		}
                	}
            	} else {
            		backend.deleteUser(userList.getSelectedValue());
            		userListModel.remove(userList.getSelectedIndex());
            		okButton.setVisible(false);
                    cancelButton.setVisible(false);
                    confirmText.setVisible(false);
                    errorLabel.setVisible(false);
            	}
            }
    	});
    	
    	cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	okButton.setVisible(false);
            	cancelButton.setVisible(false);
            	userIdLabel.setVisible(false);
            	usernameLabel.setVisible(false);
            	userIdEntry.setText("");
            	userIdEntry.setVisible(false);
            	usernameEntry.setText("");
            	usernameEntry.setVisible(false);
            	errorLabel.setVisible(false);
            	confirmText.setVisible(false);
            	
            }
    	});
    	
    	createUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	creatingUser = true;
            	okButton.setVisible(true);
            	cancelButton.setVisible(true);
            	userIdLabel.setVisible(true);
            	usernameLabel.setVisible(true);
            	userIdEntry.setVisible(true);
            	usernameEntry.setVisible(true);
            	userIdEntry.requestFocus();	            	
            }
    	});
    	
    	deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	creatingUser = false;
            	okButton.setVisible(true);
            	cancelButton.setVisible(true);
            	confirmText.setVisible(true);          	
            }
    	});
    	
    }
    
    
}
                      
