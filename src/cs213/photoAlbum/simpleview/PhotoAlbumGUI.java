package cs213.photoAlbum.simpleview;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import cs213.photoAlbum.control.Control;
import cs213.photoAlbum.model.Backend;
import cs213.photoAlbum.model.Photo;
import cs213.photoAlbum.model.PhotoAlbum;
import cs213.photoAlbum.model.Tag;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Jason Davis and Michael Newman
 */
public class PhotoAlbumGUI extends javax.swing.JFrame {
	
    private static Control control = new Control();
    private static Backend backend = control.getBackend();
    private static int extraButtonState;
    private static boolean extraListenerSet = false;

    private static final int MY_ALBUMS = 0;
    private static final int SEARCH = 1;
    private static final int DISPLAY_PHOTO_EXIT = 2;

    JButton logoutButton;
    JButton extraButton;
    JPanel jPanel;
    CardLayout panelLayout;
    private static PhotoAlbumGUI app;
    
    private static LoginPanel loginPanel;
    private static AdminPanel adminPanel;
    private static AlbumsPanel albumsPanel;
    private static SearchPanel searchPanel;
    private static PhotosPanel photosPanel;
    private static PhotoViewPanel photoViewPanel;
    

    public PhotoAlbumGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        postInit();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        logoutButton = new javax.swing.JButton();
        extraButton = new javax.swing.JButton();
        jPanel = new javax.swing.JPanel(new java.awt.CardLayout());
        
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                control.logout();
                dispose();
                System.exit(0);
            }
        });

        logoutButton.setText("Logout");

        extraButton.setText("My Albums");

        jPanel.setBackground(new java.awt.Color(102, 102, 102));
        jPanel.setPreferredSize(new java.awt.Dimension(580, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(extraButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton)
                    .addComponent(extraButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    
    
    private void postInit() {
    	extraButton.setVisible(false);
    }                                      

 
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PhotoAlbumGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhotoAlbumGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhotoAlbumGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhotoAlbumGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                app = new PhotoAlbumGUI();
                app.panelLayout = (CardLayout) app.jPanel.getLayout();
                
                loginPanel = new LoginPanel();
                adminPanel = new AdminPanel(control);
                
                app.jPanel.add(loginPanel, "login");
                app.jPanel.add(adminPanel, "admin");
                
                app.setVisible(true);
                
                app.logoutButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                    	try {
                    		backend.writeData();
                    	} catch (Exception e) {}
                    	userLogin();
                    }
            	});
                
                userLogin();                
            }
        });
    }
    
    private static void userLogin() {

            app.logoutButton.setEnabled(false);
            app.extraButton.setVisible(false);

            app.panelLayout.show(app.jPanel, "login");

            loginPanel.userIdText.setText("");
            loginPanel.loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String userId = loginPanel.userIdText.getText();
            	if(userId.isEmpty()) {
            		loginPanel.errorLabel.setForeground(Color.RED);
            		loginPanel.errorLabel.setText("Please enter a User ID");
            	} else if (userId.equals("admin")) {
            		loginPanel.errorLabel.setText(" ");
            		adminScreen();
            	} else {
            		try {
            			control.login(userId);
            			loginPanel.errorLabel.setText(" ");
            			albumsScreen();
            		} catch (Exception e) {
            			loginPanel.errorLabel.setForeground(Color.RED);
            			loginPanel.errorLabel.setText("User " + userId + " does not exist");
            		}
            	}
            }
        });	
    }
    
    private static void adminScreen() {
    	
    	app.logoutButton.setEnabled(true);
    	app.panelLayout.show(app.jPanel, "admin");
    	
    }
    
    private static void albumsScreen() {
    	
    	app.logoutButton.setEnabled(true);
    	app.extraButton.setText("Search");
    	app.extraButton.setVisible(true);
    	extraButtonState = SEARCH;
    	
    	if (!extraListenerSet) {
    		app.extraButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                extraButtonAction();
	            }
	        });
            extraListenerSet = true;
    	}
        
        albumsPanel = new AlbumsPanel(control);
    	app.jPanel.add(albumsPanel, "albums");
    	app.panelLayout.show(app.jPanel, "albums");
        
        albumsPanel.openButton.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		photosScreen(albumsPanel.albumList.getSelectedValue());
	        }
	    });	
    	
    }
    
    private static void searchScreen() {
    	
        app.logoutButton.setEnabled(true);
        app.extraButton.setText("My Albums");
        app.extraButton.setVisible(true);
        extraButtonState = MY_ALBUMS;

        searchPanel = new SearchPanel();
        app.jPanel.add(searchPanel, "search");
        app.panelLayout.show(app.jPanel, "search");

        searchPanel.tagSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if (searchPanel.tagSearchModel.isEmpty()) {
            		searchPanel.tagErrorLabel.setText("Tag(s) required");
            		searchPanel.tagErrorLabel.setVisible(true);
            	} else {
            		searchPanel.tagErrorLabel.setVisible(false);
            		String[][] tagDetails = new String[searchPanel.tagSearchModel.size()+1][2];
            		for (int i = 1; i <= searchPanel.tagSearchModel.size(); i++) {
            			Tag tag = searchPanel.tagSearchModel.getElementAt(i-1);
            			tagDetails[i][0] = tag.getType();
            			tagDetails[i][1] = tag.getValue();
            		}
            		ArrayList<Photo> photoList = control.getPhotosByTag(tagDetails);
            		PhotoAlbum album;
            		if (searchPanel.saveTagSearch.isSelected()) {
            			int count = 0;
            			while(true) {
	            			try {
	            				control.createAlbum("TagSearch" + count);
	            				album = control.getAlbum("TagSearch" + count);
	            				break;
	            			} catch (Exception e) {
	            				count++;
	            			}
            			}
                    } else {
                    	album = new PhotoAlbum("TagSearch");
                    }
            		for (Photo photo : photoList) {
            			album.addPhoto(photo);
            		}
            		
                    photosScreen(album);
            	}
            }
        });
    	
        searchPanel.dateSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if (searchPanel.emptyDates()) {
            		searchPanel.dateErrorLabel.setText("All fields required");
            		searchPanel.dateErrorLabel.setVisible(true);
            	} else if (searchPanel.invalidDates()) {
            		searchPanel.dateErrorLabel.setText("Invalid fields");
            		searchPanel.dateErrorLabel.setVisible(true);
            	} else {
            		searchPanel.dateErrorLabel.setVisible(false);
            		String start = searchPanel.getFromDate();
            		String end = searchPanel.getToDate();
            		ArrayList<Photo> photoList = control.getPhotosByDate(start, end);
            		PhotoAlbum album;
            		if (searchPanel.saveDateSearch.isSelected()) {
            			int count = 0;
            			while(true) {
	            			try {
	            				control.createAlbum("DateSearch" + count);
	            				album = control.getAlbum("DateSearch" + count);
	            				break;
	            			} catch (Exception e) {
	            				count++;
	            			}
            			}
                                    } else {
                                            album = new PhotoAlbum("DateSearch");
                                    }
            		for (Photo photo : photoList) {
            			album.addPhoto(photo);
            		}
            		
                    photosScreen(album);
            	}
            }
        });	
    	
    }
    
    private static void photosScreen(PhotoAlbum album) {
    	
        app.logoutButton.setEnabled(true);
        app.extraButton.setText("My Albums");
        app.extraButton.setVisible(true);
        extraButtonState = MY_ALBUMS;

        photosPanel = new PhotosPanel(control, album);
        app.jPanel.add(photosPanel, "photos");
        app.panelLayout.show(app.jPanel, "photos");
        
        /* action listeners */
        
        // Open
        photosPanel.btnOpenPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String selected = photosPanel.selectedPhotoPath;
                if (selected == null)  return;
                photoViewScreen(control.getPhoto(selected), photosPanel.album);
            }
        });	
        
    }
    
    private static void photoViewScreen(Photo photo, PhotoAlbum album) {
        
        app.logoutButton.setEnabled(false);
        app.extraButton.setText("X");
        app.extraButton.setVisible(true);
        extraButtonState = DISPLAY_PHOTO_EXIT;
        
        photoViewPanel = new PhotoViewPanel(control, photo, album);
        app.jPanel.add(photoViewPanel, "displayPhoto");
        app.panelLayout.show(app.jPanel, "displayPhoto");
        
    }
    	
    private static void extraButtonAction() {
        if (extraButtonState == MY_ALBUMS) {
            albumsScreen();
        } else if (extraButtonState == SEARCH) {
            searchScreen();
        } else if (extraButtonState == DISPLAY_PHOTO_EXIT) {
            photosScreen(photoViewPanel.getAlbum());
        }
    }
     

}