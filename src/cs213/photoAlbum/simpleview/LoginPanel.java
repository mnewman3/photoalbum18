package cs213.photoAlbum.simpleview;


/**
 *
 * @author Jason Davis
 */
public class LoginPanel extends javax.swing.JPanel {
	
	  private javax.swing.JLabel jLabel1;
	  private javax.swing.JLabel jLabel3;
	  javax.swing.JLabel errorLabel;
	  javax.swing.JButton loginButton;
	  javax.swing.JTextField userIdText;

 
    public LoginPanel() {
        initComponents();
    }


    @SuppressWarnings("unchecked")                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        userIdText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(580, 330));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 48)); 
        jLabel1.setText("Photo Box");

        errorLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        errorLabel.setForeground(new java.awt.Color(102, 102, 102));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("Please enter a valid User ID");
        errorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel3.setText("User ID:");

        loginButton.setBackground(new java.awt.Color(0, 51, 204));
        loginButton.setForeground(new java.awt.Color(254, 254, 254));
        loginButton.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        loginButton.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 156, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(userIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(errorLabel)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }  

                  
}
