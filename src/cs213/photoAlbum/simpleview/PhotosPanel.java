/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs213.photoAlbum.simpleview;

import cs213.photoAlbum.control.Control;
import cs213.photoAlbum.model.Photo;
import cs213.photoAlbum.model.PhotoAlbum;
import cs213.photoAlbum.util.AlbumException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author Mike Newman
 */
public class PhotosPanel extends javax.swing.JPanel {

    private Control control;
    public PhotoAlbum album;
    public PhotosPanel(Control control, PhotoAlbum album) {
            this.control = control;
            this.album = album;
            initComponents();
            setDialogLocations();
            displayPhotosFromAlbum();
            photosLabel.setText("Photos - " + album.getAlbumName());
    }
    
    private void displayPhotosFromAlbum() {
        PhotoScrollPanel.removeAll();
        ArrayList<Photo> albumList = album.getPhotoList();
        for(Photo photo : albumList) {
            
            JLabel photoLabel = new JLabel();
            photoLabel.setSize(100, 100);
            
            String fileName = photo.getFileName();
            BufferedImage img = null;
            
            try {
                img = ImageIO.read(new File(fileName));
                ImageIcon icon = new ImageIcon(img.getScaledInstance(photoLabel.getWidth(), photoLabel.getWidth(), Image.SCALE_SMOOTH));
                photoLabel.setIcon(icon);
                photoLabel.setName(fileName);
            } catch (Exception e) {
                continue;
            }
            
            
            photoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (prevSelected != null) {
                        prevSelected.setBorder(null);
                    }
                    JLabel src = (JLabel) evt.getSource();
                    selectedPhotoPath = src.getName();
                    src.setBorder(BorderFactory.createLineBorder(Color.blue));
                    prevSelected = src;
                }
            });
            
            PhotoScrollPanel.add(photoLabel);
        }
        
        for (int i = albumList.size(); i < 9; i++) {
             JLabel placeHolder = new JLabel();
             placeHolder.setSize(100, 100);
             PhotoScrollPanel.add(placeHolder);
        }
        
        PhotoScrollPanel.revalidate();
        PhotoScrollPanel.repaint();
    }
    
    private void displayNewPhoto(String fileName) {
        JLabel photoLabel = new JLabel();
            photoLabel.setSize(100, 100);
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ImageIcon icon = new ImageIcon(img.getScaledInstance(photoLabel.getWidth(), photoLabel.getWidth(), Image.SCALE_SMOOTH));
            
            photoLabel.setIcon(icon);
            photoLabel.setName(fileName);
            
            photoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    JLabel src = (JLabel) evt.getSource();
                    selectedPhotoPath = src.getName();
                    src.setBorder(BorderFactory.createLineBorder(Color.blue));
                    if (prevSelected != null) {
                        prevSelected.setBorder(null);
                    }
                    prevSelected = src;
                }
            });
            
            PhotoScrollPanel.add(photoLabel, 0);
            PhotoScrollPanel.revalidate();
            PhotoScrollPanel.repaint();
    }
    
    private void setDialogLocations() {
        AddPhotoDialog.setLocationRelativeTo(null);
        RemovePhotoDialog.setLocationRelativeTo(null);
        RecaptionDialog.setLocationRelativeTo(null);
        MovePhotoDialog.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        AddPhotoDialog = new javax.swing.JDialog();
        btnAddPhotoOk = new javax.swing.JButton();
        btnAddPhotoCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PhotoPathField = new javax.swing.JTextField();
        PhotoCaptionField = new javax.swing.JTextField();
        AddErrorLabel = new javax.swing.JLabel();
        RemovePhotoDialog = new javax.swing.JDialog();
        btnRemoveOk = new javax.swing.JButton();
        btnRemoveCancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        RemoveErrorLabel = new javax.swing.JLabel();
        RecaptionDialog = new javax.swing.JDialog();
        btnRecaptionPhotoOk = new javax.swing.JButton();
        btnRecaptionPhotoCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        PhotoRecaptionField = new javax.swing.JTextField();
        MovePhotoDialog = new javax.swing.JDialog();
        btnMovePhotoOk = new javax.swing.JButton();
        btnMovePhotoCancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ddlMovePhotoAlbum = new javax.swing.JComboBox();
        MoveErrorLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PhotoScrollPanel = new javax.swing.JPanel();
        btnOpenPhoto = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnRecaption = new javax.swing.JButton();
        btnMovePhoto = new javax.swing.JButton();
        photosLabel = new javax.swing.JLabel();

        AddPhotoDialog.setTitle("Add Photo");
        AddPhotoDialog.setMaximumSize(new java.awt.Dimension(342, 190));
        AddPhotoDialog.setMinimumSize(new java.awt.Dimension(342, 190));
        AddPhotoDialog.setPreferredSize(new java.awt.Dimension(342, 190));
        AddPhotoDialog.setResizable(false);

        btnAddPhotoOk.setBackground(new java.awt.Color(0, 51, 204));
        btnAddPhotoOk.setForeground(new java.awt.Color(254, 254, 254));
        btnAddPhotoOk.setText("Ok");
        btnAddPhotoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPhotoOkActionPerformed(evt);
            }
        });

        btnAddPhotoCancel.setBackground(new java.awt.Color(0, 51, 204));
        btnAddPhotoCancel.setForeground(new java.awt.Color(254, 254, 254));
        btnAddPhotoCancel.setText("Cancel");
        btnAddPhotoCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPhotoCancelActionPerformed(evt);
            }
        });

        jLabel1.setText("Path:");

        jLabel2.setText("Caption:");

        AddErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        AddErrorLabel.setText(" ");

        javax.swing.GroupLayout AddPhotoDialogLayout = new javax.swing.GroupLayout(AddPhotoDialog.getContentPane());
        AddPhotoDialog.getContentPane().setLayout(AddPhotoDialogLayout);
        AddPhotoDialogLayout.setHorizontalGroup(
            AddPhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddPhotoDialogLayout.createSequentialGroup()
                .addGroup(AddPhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddPhotoDialogLayout.createSequentialGroup()
                        .addGroup(AddPhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(AddPhotoDialogLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PhotoCaptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddPhotoDialogLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(btnAddPhotoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddPhotoCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(AddPhotoDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AddPhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(AddPhotoDialogLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PhotoPathField))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddPhotoDialogLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(266, 266, 266)))))
                .addContainerGap())
        );
        AddPhotoDialogLayout.setVerticalGroup(
            AddPhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddPhotoDialogLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(AddErrorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddPhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhotoPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(19, 19, 19)
                .addGroup(AddPhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhotoCaptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(AddPhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddPhotoCancel)
                    .addComponent(btnAddPhotoOk))
                .addContainerGap())
        );

        RemovePhotoDialog.setTitle("Remove Photo");
        RemovePhotoDialog.setMaximumSize(new java.awt.Dimension(300, 135));
        RemovePhotoDialog.setMinimumSize(new java.awt.Dimension(300, 135));
        RemovePhotoDialog.setPreferredSize(new java.awt.Dimension(300, 135));
        RemovePhotoDialog.setResizable(false);

        btnRemoveOk.setBackground(new java.awt.Color(0, 51, 204));
        btnRemoveOk.setForeground(new java.awt.Color(254, 254, 254));
        btnRemoveOk.setText("Ok");
        btnRemoveOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveOkActionPerformed(evt);
            }
        });

        btnRemoveCancel.setBackground(new java.awt.Color(0, 51, 204));
        btnRemoveCancel.setForeground(new java.awt.Color(254, 254, 254));
        btnRemoveCancel.setText("Cancel");
        btnRemoveCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveCancelActionPerformed(evt);
            }
        });

        jLabel4.setText("Are you sure?");

        RemoveErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        RemoveErrorLabel.setText(" ");

        javax.swing.GroupLayout RemovePhotoDialogLayout = new javax.swing.GroupLayout(RemovePhotoDialog.getContentPane());
        RemovePhotoDialog.getContentPane().setLayout(RemovePhotoDialogLayout);
        RemovePhotoDialogLayout.setHorizontalGroup(
            RemovePhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RemovePhotoDialogLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnRemoveOk, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnRemoveCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(RemovePhotoDialogLayout.createSequentialGroup()
                .addGroup(RemovePhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RemovePhotoDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RemoveErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RemovePhotoDialogLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RemovePhotoDialogLayout.setVerticalGroup(
            RemovePhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RemovePhotoDialogLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(RemoveErrorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(RemovePhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveCancel)
                    .addComponent(btnRemoveOk))
                .addContainerGap())
        );

        RecaptionDialog.setTitle("Recaption Photo");
        RecaptionDialog.setMaximumSize(new java.awt.Dimension(342, 135));
        RecaptionDialog.setMinimumSize(new java.awt.Dimension(342, 135));
        RecaptionDialog.setPreferredSize(new java.awt.Dimension(342, 135));
        RecaptionDialog.setResizable(false);

        btnRecaptionPhotoOk.setBackground(new java.awt.Color(0, 51, 204));
        btnRecaptionPhotoOk.setForeground(new java.awt.Color(254, 254, 254));
        btnRecaptionPhotoOk.setText("Ok");
        btnRecaptionPhotoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecaptionPhotoOkActionPerformed(evt);
            }
        });

        btnRecaptionPhotoCancel.setBackground(new java.awt.Color(0, 51, 204));
        btnRecaptionPhotoCancel.setForeground(new java.awt.Color(254, 254, 254));
        btnRecaptionPhotoCancel.setText("Cancel");
        btnRecaptionPhotoCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecaptionPhotoCancelActionPerformed(evt);
            }
        });

        jLabel5.setText("Caption:");

        javax.swing.GroupLayout RecaptionDialogLayout = new javax.swing.GroupLayout(RecaptionDialog.getContentPane());
        RecaptionDialog.getContentPane().setLayout(RecaptionDialogLayout);
        RecaptionDialogLayout.setHorizontalGroup(
            RecaptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RecaptionDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(278, 278, 278))
            .addGroup(RecaptionDialogLayout.createSequentialGroup()
                .addGroup(RecaptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RecaptionDialogLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PhotoRecaptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, RecaptionDialogLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnRecaptionPhotoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRecaptionPhotoCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RecaptionDialogLayout.setVerticalGroup(
            RecaptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RecaptionDialogLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(RecaptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhotoRecaptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 42, Short.MAX_VALUE)
                .addGroup(RecaptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRecaptionPhotoCancel)
                    .addComponent(btnRecaptionPhotoOk))
                .addContainerGap())
        );

        MovePhotoDialog.setTitle("Move Photo");
        MovePhotoDialog.setMinimumSize(new java.awt.Dimension(342, 140));
        MovePhotoDialog.setResizable(false);

        btnMovePhotoOk.setBackground(new java.awt.Color(0, 51, 204));
        btnMovePhotoOk.setForeground(new java.awt.Color(254, 254, 254));
        btnMovePhotoOk.setText("Ok");
        btnMovePhotoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovePhotoOkActionPerformed(evt);
            }
        });

        btnMovePhotoCancel.setBackground(new java.awt.Color(0, 51, 204));
        btnMovePhotoCancel.setForeground(new java.awt.Color(254, 254, 254));
        btnMovePhotoCancel.setText("Cancel");
        btnMovePhotoCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovePhotoCancelActionPerformed(evt);
            }
        });

        jLabel6.setText("Album:");

        MoveErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        MoveErrorLabel.setText(" ");

        javax.swing.GroupLayout MovePhotoDialogLayout = new javax.swing.GroupLayout(MovePhotoDialog.getContentPane());
        MovePhotoDialog.getContentPane().setLayout(MovePhotoDialogLayout);
        MovePhotoDialogLayout.setHorizontalGroup(
            MovePhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovePhotoDialogLayout.createSequentialGroup()
                .addGroup(MovePhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MovePhotoDialogLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnMovePhotoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMovePhotoCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MovePhotoDialogLayout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addGroup(MovePhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MoveErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MovePhotoDialogLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ddlMovePhotoAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        MovePhotoDialogLayout.setVerticalGroup(
            MovePhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MovePhotoDialogLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(MoveErrorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MovePhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ddlMovePhotoAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(MovePhotoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMovePhotoCancel)
                    .addComponent(btnMovePhotoOk))
                .addContainerGap())
        );

        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(580, 330));

        jPanel1.setBorder(null);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        PhotoScrollPanel.setBackground(new java.awt.Color(254, 254, 254));
        PhotoScrollPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(203, 203, 203)));
        PhotoScrollPanel.setMaximumSize(new java.awt.Dimension(438, 282));
        PhotoScrollPanel.setMinimumSize(new java.awt.Dimension(438, 282));
        PhotoScrollPanel.setLayout(new java.awt.GridLayout(0, 4, 1, 1));
        jScrollPane1.setViewportView(PhotoScrollPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );

        btnOpenPhoto.setBackground(new java.awt.Color(0, 51, 204));
        btnOpenPhoto.setForeground(new java.awt.Color(254, 254, 254));
        btnOpenPhoto.setText("Open Photo");

        btnAdd.setBackground(new java.awt.Color(0, 51, 204));
        btnAdd.setForeground(new java.awt.Color(254, 254, 254));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(0, 51, 204));
        btnRemove.setForeground(new java.awt.Color(254, 254, 254));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnRecaption.setBackground(new java.awt.Color(0, 51, 204));
        btnRecaption.setForeground(new java.awt.Color(254, 254, 254));
        btnRecaption.setText("Recaption");
        btnRecaption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecaptionActionPerformed(evt);
            }
        });

        btnMovePhoto.setBackground(new java.awt.Color(0, 51, 204));
        btnMovePhoto.setForeground(new java.awt.Color(254, 254, 254));
        btnMovePhoto.setText("Move Photo");
        btnMovePhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovePhotoActionPerformed(evt);
            }
        });

        photosLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        photosLabel.setForeground(new java.awt.Color(1, 1, 1));
        photosLabel.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(photosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpenPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(btnRecaption, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(btnMovePhoto, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnOpenPhoto)
                .addGap(30, 30, 30)
                .addComponent(btnAdd)
                .addGap(35, 35, 35)
                .addComponent(btnRemove)
                .addGap(32, 32, 32)
                .addComponent(btnRecaption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMovePhoto)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photosLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        AddPhotoDialog.setVisible(true);
    }

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedPhotoPath != null) {
            RemovePhotoDialog.setVisible(true);
        }
    }

    private void btnMovePhotoActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedPhotoPath != null) {
            LinkedList<PhotoAlbum> albumList = control.listAlbums();
            for(PhotoAlbum album : albumList) {
                if (album != this.album) {
                    ddlMovePhotoAlbum.addItem(album);
                }
            }
            MovePhotoDialog.setVisible(true);
        }
    }

    private void btnRecaptionActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedPhotoPath != null) {
            RecaptionDialog.setVisible(true);
        }
    }

   private void btnAddPhotoOkActionPerformed(java.awt.event.ActionEvent evt) {
        String photoPath = PhotoPathField.getText();
        if (album.getPhoto(photoPath) != null) {
            AddErrorLabel.setText("Error: Photo already exists for album");
            return;
        }
        try {
            control.addPhoto(photoPath, PhotoCaptionField.getText(), album.getAlbumName());
        } catch (Exception e) {
            if (e instanceof AlbumException) {
                AddErrorLabel.setText("Error: Album does not exist");
            } else {
                AddErrorLabel.setText("Error: Invalid path");
            }
            return;
        }
        if(album.getPhoto(photoPath) != null) {
            displayNewPhoto(photoPath);
        }
        AddPhotoDialog.setVisible(false);
        PhotoPathField.setText("");
        PhotoCaptionField.setText("");
        AddErrorLabel.setText(" ");
    }


    private void btnAddPhotoCancelActionPerformed(java.awt.event.ActionEvent evt) {
        AddPhotoDialog.setVisible(false);
        PhotoPathField.setText("");
        PhotoCaptionField.setText("");
        AddErrorLabel.setText(" ");
    }

    private void btnRemoveCancelActionPerformed(java.awt.event.ActionEvent evt) {
        RemovePhotoDialog.setVisible(false);
        RemoveErrorLabel.setText(" ");
    }

    private void btnRemoveOkActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            control.removePhoto(selectedPhotoPath, album.getAlbumName());
        } catch (Exception e) {
            RemoveErrorLabel.setText("Error: Photo remove failed");
            return;
        }
        RemovePhotoDialog.setVisible(false);
        RemoveErrorLabel.setText(" ");
        selectedPhotoPath = null;
        displayPhotosFromAlbum();
    }

    private void btnRecaptionPhotoOkActionPerformed(java.awt.event.ActionEvent evt) {
        Photo photo = album.getPhoto(selectedPhotoPath);
        photo.setCaption(PhotoRecaptionField.getText());
        RecaptionDialog.setVisible(false);
        PhotoRecaptionField.setText("");
    }

    private void btnRecaptionPhotoCancelActionPerformed(java.awt.event.ActionEvent evt) {
        RecaptionDialog.setVisible(false);
        PhotoRecaptionField.setText("");
    }

    private void btnMovePhotoOkActionPerformed(java.awt.event.ActionEvent evt) {
        PhotoAlbum newAlbum = (PhotoAlbum)ddlMovePhotoAlbum.getSelectedItem();
        if (newAlbum.getPhoto(selectedPhotoPath) != null) {
            MoveErrorLabel.setText("Error: Photo already exists in album");
            return;
        }
        try {
            control.movePhoto(selectedPhotoPath, album.getAlbumName(), newAlbum.getAlbumName());
        } catch (Exception e) { }
        
        MovePhotoDialog.setVisible(false);
        displayPhotosFromAlbum();
        ddlMovePhotoAlbum.removeAllItems();
        MoveErrorLabel.setText(" ");
    }

    private void btnMovePhotoCancelActionPerformed(java.awt.event.ActionEvent evt) {
        MovePhotoDialog.setVisible(false);
        ddlMovePhotoAlbum.removeAllItems();
        MoveErrorLabel.setText(" ");
    }

public String selectedPhotoPath = null;
private JLabel prevSelected = null;
    
    
    private javax.swing.JLabel AddErrorLabel;
    private javax.swing.JDialog AddPhotoDialog;
    private javax.swing.JLabel MoveErrorLabel;
    private javax.swing.JDialog MovePhotoDialog;
    private javax.swing.JTextField PhotoCaptionField;
    private javax.swing.JTextField PhotoPathField;
    private javax.swing.JTextField PhotoRecaptionField;
    private javax.swing.JPanel PhotoScrollPanel;
    private javax.swing.JDialog RecaptionDialog;
    private javax.swing.JLabel RemoveErrorLabel;
    private javax.swing.JDialog RemovePhotoDialog;
    public javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddPhotoCancel;
    private javax.swing.JButton btnAddPhotoOk;
    public javax.swing.JButton btnMovePhoto;
    private javax.swing.JButton btnMovePhotoCancel;
    private javax.swing.JButton btnMovePhotoOk;
    public javax.swing.JButton btnOpenPhoto;
    public javax.swing.JButton btnRecaption;
    private javax.swing.JButton btnRecaptionPhotoCancel;
    private javax.swing.JButton btnRecaptionPhotoOk;
    public javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRemoveCancel;
    private javax.swing.JButton btnRemoveOk;
    private javax.swing.JComboBox ddlMovePhotoAlbum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel photosLabel;
    
}
