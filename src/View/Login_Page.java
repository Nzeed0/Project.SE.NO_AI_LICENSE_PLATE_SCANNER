package View;

import Controller.Main_Controller;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login_Page extends javax.swing.JFrame {

    private Main_Controller pulldb;
    
    public Login_Page() {
        initComponents();
//        setIconApp();
    }
    
    public void setPulldataOBJ(Main_Controller pulldb){
        this.pulldb = pulldb;
    }

    public void ErrorLoginPopup(){
        JOptionPane.showMessageDialog(this, "Username or Password or Role Incorrect\nplease input again!");
        ClearTextBox();
    }
    
    private void EmthyTextErrorPopup(){
        JOptionPane.showMessageDialog(this, "please input again!");
    }
    
    private void ClearTextBox(){
        Username.setText("");
        Password.setText("");
    }
    
//    private void setIconApp(){
//        ImageIcon imageicon = new ImageIcon(getClass().getResource("/Image/Icon_App.png"));
//        Image ImageRe = imageicon.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
//        Icon_app_Label.setIcon(new ImageIcon(ImageRe));
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Username_Lebel = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        Password_Lebel = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        Login_Button = new javax.swing.JButton();
        Forgot_Password = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setMinimumSize(new java.awt.Dimension(530, 400));
        setName("Login_Page"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Username_Lebel.setBackground(new java.awt.Color(255, 255, 255));
        Username_Lebel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Username_Lebel.setForeground(new java.awt.Color(255, 255, 255));
        Username_Lebel.setText("Username/Email");
        getContentPane().add(Username_Lebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        Username.setBackground(new java.awt.Color(43, 42, 41));
        Username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Username.setForeground(new java.awt.Color(255, 255, 255));
        Username.setToolTipText("Username/Email");
        Username.setCaretColor(new java.awt.Color(255, 255, 255));
        Username.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 350, 30));

        Password_Lebel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Password_Lebel.setForeground(new java.awt.Color(255, 255, 255));
        Password_Lebel.setText("Password");
        getContentPane().add(Password_Lebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        Password.setBackground(new java.awt.Color(43, 42, 41));
        Password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.setCaretColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 350, 30));

        Login_Button.setBackground(new java.awt.Color(255, 153, 0));
        Login_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Login_Button.setText("Login");
        Login_Button.setIconTextGap(0);
        Login_Button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Login_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Login_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 80, 30));

        Forgot_Password.setForeground(new java.awt.Color(255, 153, 0));
        Forgot_Password.setText("Forgot Password");
        Forgot_Password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Forgot_PasswordMouseClicked(evt);
            }
        });
        getContentPane().add(Forgot_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 110, 110));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Forgot_PasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Forgot_PasswordMouseClicked
        JOptionPane.showMessageDialog(this, "Claim Down Boi!", "Forgot Password", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_Forgot_PasswordMouseClicked

    private void Login_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_ButtonActionPerformed
        String CurrentPassword = new String(this.Password.getPassword());
        if(Username.getText().equals("") || CurrentPassword.equals("")){
            EmthyTextErrorPopup();
            ClearTextBox();
        }
        else if(pulldb.Main_Table()){
            pulldb.Check_userRole(Username.getText(), CurrentPassword);
        } else {
            JOptionPane.showMessageDialog(null, "Cannot load data from Database1", "Database Problem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Login_ButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Forgot_Password;
    private javax.swing.JButton Login_Button;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel Password_Lebel;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel Username_Lebel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
