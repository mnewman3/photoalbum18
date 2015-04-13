package cs213.photoAlbum.simpleview;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import cs213.photoAlbum.model.Tag;


/**
*
* @author Jason Davis
*/
public class SearchPanel extends javax.swing.JPanel {
	
	javax.swing.JButton tagSearchButton;
	javax.swing.JButton dateSearchButton;
	DefaultListModel<Tag> tagSearchModel;
	JList<Tag> tagSearchList;

	private javax.swing.JButton addTagButton;
    javax.swing.JLabel dateErrorLabel;
    private javax.swing.JTextField fromDayEntry;
    private javax.swing.JTextField fromMonthEntry;
    private javax.swing.JTextField fromYearEntry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    javax.swing.JCheckBox saveDateSearch;
    javax.swing.JCheckBox saveTagSearch;
    javax.swing.JLabel tagErrorLabel;
    private javax.swing.JTextField toDayEntry;
    private javax.swing.JTextField toMonthEntry;
    private javax.swing.JTextField toYearEntry;
    private javax.swing.JTextField typeEntry;
    private javax.swing.JTextField valueEntry;
    private javax.swing.JTextField toTimeEntry;
    private javax.swing.JTextField fromTimeEntry;
	
	
    public SearchPanel() {
        initComponents();
        postInit();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {       
        
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tagSearchList = new javax.swing.JList<Tag>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        typeEntry = new javax.swing.JTextField();
        valueEntry = new javax.swing.JTextField();
        tagSearchButton = new javax.swing.JButton();
        addTagButton = new javax.swing.JButton();
        tagErrorLabel = new javax.swing.JLabel();
        saveTagSearch = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fromMonthEntry = new javax.swing.JTextField();
        fromDayEntry = new javax.swing.JTextField();
        fromYearEntry = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        fromTimeEntry = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        toMonthEntry = new javax.swing.JTextField();
        toDayEntry = new javax.swing.JTextField();
        toYearEntry = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        toTimeEntry = new javax.swing.JTextField();
        dateSearchButton = new javax.swing.JButton();
        saveDateSearch = new javax.swing.JCheckBox();
        dateErrorLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(580, 330));

        tagSearchModel = new DefaultListModel<Tag>();
        tagSearchList.setModel(tagSearchModel);
        tagSearchList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tagSearchList.setLayoutOrientation(JList.VERTICAL);
        tagSearchList.setEnabled(false);
        
        jScrollPane1.setViewportView(tagSearchList);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel3.setText("Tags to search");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); 
        jLabel4.setText("Type:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); 
        jLabel5.setText("Value:");

        tagSearchButton.setBackground(new java.awt.Color(0, 51, 204));
        tagSearchButton.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        tagSearchButton.setText("Search");

        addTagButton.setBackground(new java.awt.Color(0, 51, 204));
        addTagButton.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        addTagButton.setText("Add Tag");

        tagErrorLabel.setFont(new java.awt.Font("Tahoma", 1, 10)); 
        tagErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        tagErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tagErrorLabel.setText("ERROR");
        tagErrorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        saveTagSearch.setFont(new java.awt.Font("Tahoma", 1, 10)); 
        saveTagSearch.setText("Save result as new album");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tagErrorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addTagButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(valueEntry, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                            .addComponent(typeEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tagSearchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(saveTagSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(typeEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(valueEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(addTagButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tagErrorLabel)
                        .addGap(7, 7, 7)
                        .addComponent(saveTagSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tagSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        jPanel3.setPreferredSize(new java.awt.Dimension(128, 132));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); 
        jLabel7.setText("Month:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); 
        jLabel8.setText("Day:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 10)); 
        jLabel9.setText("Year:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 10)); 
        jLabel14.setText("Time:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fromDayEntry, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(fromMonthEntry)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromYearEntry)
                            .addComponent(fromTimeEntry))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(fromMonthEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(fromDayEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fromYearEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(fromTimeEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        jPanel4.setPreferredSize(new java.awt.Dimension(128, 132));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 10)); 
        jLabel10.setText("Month:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 10)); 
        jLabel11.setText("Day:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 10)); 
        jLabel12.setText("Year:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 10)); 
        jLabel15.setText("Time:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(toDayEntry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(toMonthEntry, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toYearEntry)
                            .addComponent(toTimeEntry))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(toMonthEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(toDayEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(toYearEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(toTimeEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dateSearchButton.setBackground(new java.awt.Color(0, 51, 204));
        dateSearchButton.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        dateSearchButton.setText("Search");

        saveDateSearch.setFont(new java.awt.Font("Tahoma", 1, 10)); 
        saveDateSearch.setText("Save result as new album");

        dateErrorLabel.setFont(new java.awt.Font("Tahoma", 1, 10)); 
        dateErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        dateErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateErrorLabel.setText("ERROR");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel16.setText("From");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel6.setText("To");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveDateSearch)
                    .addComponent(dateSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel6))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateErrorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveDateSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Search By Tag:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Search By Date:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(135, 135, 135))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }                       


    private void postInit() {
    	
    	tagErrorLabel.setVisible(false);
    	dateErrorLabel.setVisible(false);
    	
    	addTagButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if (valueEntry.getText().isEmpty()) {
            		tagErrorLabel.setText("Value required");
            		tagErrorLabel.setVisible(true);
            	} else {
            		tagErrorLabel.setVisible(false);
            		Tag tag = new Tag(typeEntry.getText().trim(), valueEntry.getText().trim());
            		tagSearchModel.addElement(tag);
            		valueEntry.setText("");
            		typeEntry.setText("");
            	}
            }
    	});
    		
    }
    
    boolean emptyDates() {
    	if (fromMonthEntry.getText().isEmpty() || fromDayEntry.getText().isEmpty() || fromYearEntry.getText().isEmpty()
    			|| toMonthEntry.getText().isEmpty() || toDayEntry.getText().isEmpty() || toYearEntry.getText().isEmpty()
    			|| fromTimeEntry.getText().isEmpty() || toTimeEntry.getText().isEmpty())
    		return true;
    	return false;
    }
    
    boolean invalidDates() {
    	int fromMonth, fromDay, fromYear, fromHour, fromMinute, fromSecond;
    	int toMonth, toDay, toYear, toHour, toMinute, toSecond;
    	
    	try {
	    	fromMonth = Integer.parseInt(fromMonthEntry.getText());
	    	fromDay = Integer.parseInt(fromDayEntry.getText());
	    	fromYear = Integer.parseInt(fromYearEntry.getText());
	    	String fromTime = fromTimeEntry.getText();
	    	if (fromTime.length() != 8) return true;
	    	fromHour = Integer.parseInt(fromTime.substring(0, 2));
	    	fromMinute = Integer.parseInt(fromTime.substring(3, 5));
	    	fromSecond = Integer.parseInt(fromTime.substring(6));
	    	toMonth = Integer.parseInt(toMonthEntry.getText());
	    	toDay = Integer.parseInt(toDayEntry.getText());
	    	toYear = Integer.parseInt(toYearEntry.getText());
	    	String toTime = toTimeEntry.getText();
	    	if (toTime.length() != 8) return true;
	    	toHour = Integer.parseInt(toTime.substring(0, 2));
	    	toMinute = Integer.parseInt(toTime.substring(3, 5));
	    	toSecond = Integer.parseInt(toTime.substring(6));
    	} catch (Exception e) {
    		return true;
    	}
    	if ( fromMonth < 1 || fromMonth > 12 || toMonth < 1 || toMonth > 12 
    			|| fromDay < 1 || fromDay > 31 || toDay < 1 || toDay > 31 || 
    			fromYear < 1000 || fromYear > 9999 || toYear < 1000 || toYear > 9999
    			|| fromHour < 0 || fromHour > 23 || toHour < 0 || toHour > 23
    			|| fromMinute < 0 || fromMinute > 59 || toMinute < 0 || toMinute > 59
    			|| fromSecond < 0 || fromSecond > 59 || toSecond < 0 || toSecond > 59)
    		return true;
    	return false;
    }
    
    String getFromDate() {
    	String fromTime = fromTimeEntry.getText();
    	StringBuilder sb = new StringBuilder();
    	if (fromMonthEntry.getText().length() == 1)
    		sb.append('0');
    	sb.append(fromMonthEntry.getText());
    	sb.append('/');
    	if (fromDayEntry.getText().length() == 1)
    		sb.append('0');
    	sb.append(fromDayEntry.getText());
    	sb.append('/');
    	sb.append(fromYearEntry.getText());
    	sb.append('-');
    	sb.append(fromTime);
    	return sb.toString();
    }
    
    String getToDate() {
    	String toTime = toTimeEntry.getText();
    	StringBuilder sb = new StringBuilder();
    	if (toMonthEntry.getText().length() == 1)
    		sb.append('0');
    	sb.append(toMonthEntry.getText());
    	sb.append('/');
    	if (toDayEntry.getText().length() == 1)
    		sb.append('0');
    	sb.append(toDayEntry.getText());
    	sb.append('/');
    	sb.append(toYearEntry.getText());
    	sb.append('-');
    	sb.append(toTime);
    	return sb.toString();
    }
    
}
