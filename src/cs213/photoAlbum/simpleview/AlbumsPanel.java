package cs213.photoAlbum.simpleview;

import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cs213.photoAlbum.control.Control;
import cs213.photoAlbum.model.Photo;
import cs213.photoAlbum.model.PhotoAlbum;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
*
* @author Jason Davis
*/
public class AlbumsPanel extends javax.swing.JPanel {

	DefaultListModel<PhotoAlbum> albumListModel;
    JList<PhotoAlbum> albumList;
    private Control control;
    private boolean creatingAlbum = false;
    private boolean renamingAlbum = false;
    private ListSelectionListener listSelectionListener;
    
    private javax.swing.JLabel albumName;
    private javax.swing.JTextField albumNameEntry;
    private javax.swing.JLabel albumNameLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel confirmText;
    private javax.swing.JButton createButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel numPhotos;
    private javax.swing.JButton okButton;
    javax.swing.JButton openButton;
    private javax.swing.JButton renameButton;
    private javax.swing.JPanel thumbnail;
    private javax.swing.JLabel fromDate;
    private javax.swing.JLabel toDate;
	
    public AlbumsPanel(Control control) {
    	this.control = control;
        initComponents();
        postInit();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        albumList = new javax.swing.JList<PhotoAlbum>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        thumbnail = new javax.swing.JPanel();
        albumName = new javax.swing.JLabel();
        numPhotos = new javax.swing.JLabel();
        fromDate = new javax.swing.JLabel();
        toDate = new javax.swing.JLabel();
        openButton = new javax.swing.JButton();
        createButton = new javax.swing.JButton();
        renameButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        albumNameEntry = new javax.swing.JTextField();
        albumNameLabel = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        confirmText = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));

        albumListModel = new DefaultListModel<PhotoAlbum>();
        LinkedList<PhotoAlbum> albumsList = control.listAlbums();
        if (albumsList != null) {
        	for (PhotoAlbum album : control.listAlbums())
        		albumListModel.addElement(album);
        }
        albumList.setModel(albumListModel);
        albumList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        albumList.setLayoutOrientation(JList.VERTICAL);
        albumList.setSelectedIndex(0);

        jScrollPane1.setViewportView(albumList);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel1.setText("Albums");

        thumbnail.setBackground(new java.awt.Color(0, 51, 204));
        
        thumbnail.setMinimumSize(new Dimension(100, 100));
        thumbnail.setMaximumSize(new Dimension(100, 100));
        thumbnail.setPreferredSize(new Dimension(100, 100));

        albumName.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        albumName.setText("");

        numPhotos.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        numPhotos.setText("");

        fromDate.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        fromDate.setText("");

        toDate.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        toDate.setText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(albumName)
                    .addComponent(numPhotos)
                    .addComponent(fromDate)
                    .addComponent(toDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(thumbnail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(albumName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numPhotos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fromDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toDate))
                    .addComponent(thumbnail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        openButton.setBackground(new java.awt.Color(0, 51, 204));
        openButton.setForeground(new java.awt.Color(254, 254, 254));
        openButton.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        openButton.setText("Open");

        createButton.setBackground(new java.awt.Color(0, 51, 204));
        createButton.setForeground(new java.awt.Color(254, 254, 254));
        createButton.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        createButton.setText("Create");

        renameButton.setBackground(new java.awt.Color(0, 51, 204));
        renameButton.setForeground(new java.awt.Color(254, 254, 254));
        renameButton.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        renameButton.setText("Rename");

        deleteButton.setBackground(new java.awt.Color(0, 51, 204));
        deleteButton.setForeground(new java.awt.Color(254, 254, 254));
        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        deleteButton.setText("Delete");

        okButton.setBackground(new java.awt.Color(0, 51, 204));
        okButton.setForeground(new java.awt.Color(254, 254, 254));
        okButton.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        okButton.setText("OK");

        cancelButton.setBackground(new java.awt.Color(0, 51, 204));
        cancelButton.setForeground(new java.awt.Color(254, 254, 254));
        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cancelButton.setText("Cancel");

        albumNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        albumNameLabel.setText("Album Name:");

        errorLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("ERROR");
        errorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        confirmText.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        confirmText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmText.setText("Are you sure?");
        confirmText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(openButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(okButton))
                                        .addGap(14, 14, 14)
                                        .addComponent(cancelButton)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(186, 186, 186)
                                        .addComponent(renameButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(albumNameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(albumNameEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53))
                                    .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confirmText)
                                .addGap(124, 124, 124))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(openButton)
                            .addComponent(createButton)
                            .addComponent(renameButton)
                            .addComponent(deleteButton))
                        .addGap(18, 18, 18)
                        .addComponent(confirmText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(albumNameEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(albumNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(okButton)
                            .addComponent(cancelButton))))
                .addGap(27, 27, 27))
        );
        
        okButton.setVisible(false);
        cancelButton.setVisible(false);
        confirmText.setVisible(false);
        errorLabel.setVisible(false);
        albumNameLabel.setVisible(false);
        albumNameEntry.setVisible(false);
        
    }
    
    private void postInit() {
    	
    	listSelectionListener = new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				JList<PhotoAlbum> list = (JList<PhotoAlbum>)e.getSource();
				PhotoAlbum selectedAlbum = (PhotoAlbum)list.getSelectedValue();
				if (selectedAlbum != null) {
					albumName.setText(selectedAlbum.getAlbumName());
					numPhotos.setText(selectedAlbum.getNumPhotos() + " photo(s)");
					String from = selectedAlbum.getStartdate();
					String to = selectedAlbum.getEndDate();
					if (from == null) from = "";
					if (to == null) to = "";
					fromDate.setText("From:     <" + from + ">");
					toDate.setText("To:         <" + to + ">");
					setThumbnail(selectedAlbum);
				}
			}
    	};
    	
    	albumList.addListSelectionListener(listSelectionListener);
    	updateAlbumDisplay();
    	
    	createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	creatingAlbum = true;
            	renamingAlbum = false;
            	okButton.setVisible(true);
                cancelButton.setVisible(true);
                albumNameLabel.setVisible(true);
                albumNameEntry.setVisible(true);
                albumNameEntry.setText("");
                albumNameEntry.requestFocus();
                albumList.setEnabled(false);
                
                albumName.setText("");
				numPhotos.setText("");
				fromDate.setText("");
				toDate.setText("");
                
                openButton.setEnabled(false);
                createButton.setEnabled(false);
                renameButton.setEnabled(false);
                deleteButton.setEnabled(false);
            }
    	});
    	
    	renameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	renamingAlbum = true;
            	creatingAlbum = false;
            	okButton.setVisible(true);
                cancelButton.setVisible(true);
                albumNameLabel.setVisible(true);
                albumNameEntry.setVisible(true);
                albumNameEntry.setText(albumList.getSelectedValue().getAlbumName());
                albumNameEntry.requestFocus();
                albumList.setEnabled(false);
                
                openButton.setEnabled(false);
                createButton.setEnabled(false);
                renameButton.setEnabled(false);
                deleteButton.setEnabled(false);
            }
    	});
    	
    	deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	okButton.setVisible(true);
                cancelButton.setVisible(true);
                confirmText.setVisible(true);
                albumList.setEnabled(false);
                
                creatingAlbum = false;
                renamingAlbum = false;
                
                openButton.setEnabled(false);
                createButton.setEnabled(false);
                renameButton.setEnabled(false);
                deleteButton.setEnabled(false);
            }
    	});
    	
    	okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if (creatingAlbum) {
            		if (albumNameEntry.getText().isEmpty()) {
            			errorLabel.setText("Please enter an album name");
            			errorLabel.setVisible(true);
            		} else {
	            		try {
	            			control.createAlbum(albumNameEntry.getText());
	            			albumListModel.addElement(control.getAlbum(albumNameEntry.getText()));
	            			updateAlbumList();
	            			
	            			errorLabel.setVisible(false);
	            			okButton.setVisible(false);
	                        cancelButton.setVisible(false);
	                        albumNameLabel.setVisible(false);
	                        albumNameEntry.setVisible(false);
	                        
	            			openButton.setEnabled(true);
	                        createButton.setEnabled(true);
	                        renameButton.setEnabled(true);
	                        deleteButton.setEnabled(true);
	                        albumList.setEnabled(true);
	            		} catch (Exception e) {
	            			errorLabel.setText("Album with name " + albumName.getText() + " already exists");
	            			errorLabel.setVisible(true);
	            		}
            		}
            	} else if (renamingAlbum) {
            		if (albumNameEntry.getText().isEmpty()) {
            			errorLabel.setText("Please enter an album name");
            			errorLabel.setVisible(true);
            		} else if (control.getAlbum(albumNameEntry.getText()) != null) {
            			errorLabel.setText("Album with name " + albumNameEntry.getText() + " already exists");
            			errorLabel.setVisible(true);
            		} else {
            			PhotoAlbum album = albumList.getSelectedValue();
            			control.renameAlbum(album.getAlbumName(), albumNameEntry.getText());
            			updateAlbumList();
            			
            			errorLabel.setVisible(false);
            			errorLabel.setVisible(false);
            			okButton.setVisible(false);
                        cancelButton.setVisible(false);
                        albumNameLabel.setVisible(false);
                        albumNameEntry.setVisible(false);
                        
            			openButton.setEnabled(true);
                        createButton.setEnabled(true);
                        renameButton.setEnabled(true);
                        deleteButton.setEnabled(true);
                        albumList.setEnabled(true);
            		}
            	} else {
            		try {
            			control.deleteAlbum(albumList.getSelectedValue().getAlbumName());
            			albumListModel.remove(albumList.getSelectedIndex());
            			albumList.setSelectedIndex(0);
            			updateAlbumDisplay();
            			
            			errorLabel.setVisible(false);
            			okButton.setVisible(false);
                        cancelButton.setVisible(false);
                        confirmText.setVisible(false);
                        
            			openButton.setEnabled(true);
                        createButton.setEnabled(true);
                        renameButton.setEnabled(true);
                        deleteButton.setEnabled(true);
                        albumList.setEnabled(true);
            		} catch (Exception e) {}
            	}
            }
    	});
    	
    	cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	creatingAlbum = false;
            	renamingAlbum = false;
            	okButton.setVisible(false);
                cancelButton.setVisible(false);
                confirmText.setVisible(false);
                errorLabel.setVisible(false);
                albumNameLabel.setVisible(false);
                albumNameEntry.setVisible(false);
                albumNameEntry.setText("");
                
                updateAlbumDisplay();
                
                openButton.setEnabled(true);
                createButton.setEnabled(true);
                renameButton.setEnabled(true);
                deleteButton.setEnabled(true);
                albumList.setEnabled(true);
            }
    	});
    	
    }
    
    private void updateAlbumDisplay() {
    	PhotoAlbum selectedAlbum = albumList.getSelectedValue();
        if (selectedAlbum != null) {
        	albumName.setText(selectedAlbum.getAlbumName());
			numPhotos.setText(selectedAlbum.getNumPhotos() + " photo(s)");
			String from = selectedAlbum.getStartdate();
			String to = selectedAlbum.getEndDate();
			if (from == null) from = "";
			if (to == null) to = "";
			fromDate.setText("From:     <" + from + ">");
			toDate.setText("To:         <" + to + ">");
			setThumbnail(selectedAlbum);
        } else {
        	albumName.setText("");
			numPhotos.setText("");
			fromDate.setText("");
			toDate.setText("");
        }
    }
    
    private void setThumbnail(PhotoAlbum album) {
        thumbnail.removeAll();
        JLabel thumbnailLabel = new JLabel();
        thumbnailLabel.setSize(100, 100);
        thumbnailLabel.setMinimumSize(new Dimension(100, 100));
        thumbnailLabel.setPreferredSize(new Dimension(100, 100));
        thumbnail.setBackground(new java.awt.Color(0, 51, 204));
        thumbnail.add(thumbnailLabel);
        
        ArrayList<Photo> photoList = album.getPhotoList();
        if (photoList == null || photoList.size() ==0) {
            return;
        }
        String fileName = photoList.get(0).getFileName();

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fileName));
            ImageIcon icon = new ImageIcon(img.getScaledInstance(thumbnailLabel.getWidth(), thumbnailLabel.getWidth(), Image.SCALE_SMOOTH));
            thumbnailLabel.setIcon(icon);
            thumbnail.setBackground(null);
        } catch (Exception e) { }
        
    }
    
    private void updateAlbumList() {
    	albumListModel.clear();
    	LinkedList<PhotoAlbum> albumsList = control.listAlbums();
        if (albumsList != null) {
        	for (PhotoAlbum album : control.listAlbums())
        		albumListModel.addElement(album);
        }
        albumList.setSelectedIndex(0);
    }
                 
}
