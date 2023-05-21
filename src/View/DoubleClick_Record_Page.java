package View;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import Controller.Main_Controller;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.JOptionPane;

public class DoubleClick_Record_Page extends javax.swing.JFrame {
    
    private final Main_Controller pobject;
    private final int record_id;
    private final String[] Data;
    
    public DoubleClick_Record_Page(String url, String Data[], int record_id, Main_Controller pobject) {
        initComponents();
        this.pobject = pobject;
        this.record_id = record_id;
        this.Data = Data;
        Set_Default_Data(Data, url);
        
    }
    
    private void Set_Default_Data(String Data[], String paramiterValue){
        try{
            License_Text.setText(Data[1]);
            License_Province.setText(Data[2]);
            Date_Reported.setText(Data[0]);
            Location_Report.setText(Data[4]);
            Reporter.setText(Data[5]);
            Discription_text.setText(Data[3]);
        } catch(Exception e){
        }
        
        try{
                String UrlLink = paramiterValue.replace(" ","%20");
                URL url = new URL(UrlLink);
                Image image = ImageIO.read(url.openStream());
                Image ImageRe = image.getScaledInstance(290, 340, Image.SCALE_SMOOTH);
                Picture_Label.setIcon(new ImageIcon(ImageRe));
          } catch(Exception e){
                ImageIcon imageicon = new ImageIcon(getClass().getResource("/Image/No_Image.png"));
                Image ImageRe = imageicon.getImage().getScaledInstance(290, 340, Image.SCALE_SMOOTH);
                Picture_Label.setIcon(new ImageIcon(ImageRe));
          }
    }
    
    private void open_web() {
        Desktop d = Desktop.getDesktop();
        String latitude = Data[7];
        String longtitude = Data[8];
        try {
            d.browse(new URI("https://www.latlong.net/c/?lat="+latitude+"&long="+longtitude));
        }
        catch(Exception e) {
 
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Top_Label_Frame = new javax.swing.JPanel();
        Data_Record_Lebel = new javax.swing.JLabel();
        Discription_Lebel = new javax.swing.JLabel();
        DateTime = new javax.swing.JLabel();
        License_Text = new javax.swing.JLabel();
        License_Province = new javax.swing.JLabel();
        Reporter_Lebel1 = new javax.swing.JLabel();
        Date_Reported = new javax.swing.JLabel();
        Reporter_Lebel2 = new javax.swing.JLabel();
        Location_Report = new javax.swing.JLabel();
        Reporter_Lebel = new javax.swing.JLabel();
        Reporter = new javax.swing.JLabel();
        Picture_Label = new javax.swing.JLabel();
        Discription_Frame = new javax.swing.JScrollPane();
        Discription_text = new javax.swing.JTextArea();
        Picture_Frame = new javax.swing.JPanel();
        Rejected_Button = new javax.swing.JButton();
        Accepted_Button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data_Record");
        setMinimumSize(new java.awt.Dimension(690, 465));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Top_Label_Frame.setBackground(new java.awt.Color(0, 0, 0));
        Top_Label_Frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Data_Record_Lebel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Data_Record_Lebel.setForeground(new java.awt.Color(255, 153, 0));
        Data_Record_Lebel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Data_Record_Lebel.setText("View Data Record");
        Top_Label_Frame.add(Data_Record_Lebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, -1));

        jPanel1.add(Top_Label_Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 680, 40));

        Discription_Lebel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Discription_Lebel.setForeground(new java.awt.Color(255, 255, 255));
        Discription_Lebel.setText("Discription");
        jPanel1.add(Discription_Lebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 170, -1));

        DateTime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DateTime.setForeground(new java.awt.Color(255, 255, 255));
        DateTime.setText("License Details");
        jPanel1.add(DateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 170, -1));

        License_Text.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        License_Text.setForeground(new java.awt.Color(255, 255, 255));
        License_Text.setText("No License");
        jPanel1.add(License_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 300, -1));

        License_Province.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        License_Province.setForeground(new java.awt.Color(255, 255, 255));
        License_Province.setText("No Province");
        jPanel1.add(License_Province, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 300, -1));

        Reporter_Lebel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Reporter_Lebel1.setForeground(new java.awt.Color(255, 255, 255));
        Reporter_Lebel1.setText("Date And Time Repoerted");
        jPanel1.add(Reporter_Lebel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 170, -1));

        Date_Reported.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Date_Reported.setForeground(new java.awt.Color(255, 255, 255));
        Date_Reported.setText("No Date");
        jPanel1.add(Date_Reported, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 300, -1));

        Reporter_Lebel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Reporter_Lebel2.setForeground(new java.awt.Color(255, 255, 255));
        Reporter_Lebel2.setText("Location Repored");
        jPanel1.add(Reporter_Lebel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 170, -1));

        Location_Report.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Location_Report.setForeground(new java.awt.Color(255, 255, 255));
        Location_Report.setText("No Location");
        jPanel1.add(Location_Report, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 290, -1));

        Reporter_Lebel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Reporter_Lebel.setForeground(new java.awt.Color(255, 255, 255));
        Reporter_Lebel.setText("Reporter");
        jPanel1.add(Reporter_Lebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 170, -1));

        Reporter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Reporter.setForeground(new java.awt.Color(255, 255, 255));
        Reporter.setText("No Reporter");
        jPanel1.add(Reporter, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 300, -1));
        jPanel1.add(Picture_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 300, 340));

        Discription_text.setEditable(false);
        Discription_text.setColumns(20);
        Discription_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Discription_text.setRows(5);
        Discription_Frame.setViewportView(Discription_text);

        jPanel1.add(Discription_Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 330, 100));

        Picture_Frame.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(Picture_Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 310, 360));

        Rejected_Button.setBackground(new java.awt.Color(153, 153, 153));
        Rejected_Button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Rejected_Button.setText("Reject");
        Rejected_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rejected_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Rejected_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 80, -1));

        Accepted_Button.setBackground(new java.awt.Color(255, 153, 0));
        Accepted_Button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Accepted_Button.setText("Accept");
        Accepted_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accepted_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Accepted_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 80, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("OPEN MAP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 290, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Accepted_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accepted_ButtonActionPerformed
        if(pobject.Update_status(record_id, 4)){
            pobject.Main_Table();
            JOptionPane.showMessageDialog(null, "Update Successfully!", "Update Menu", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Cannot update data now", "Update problem", JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_Accepted_ButtonActionPerformed

    private void Rejected_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rejected_ButtonActionPerformed
       if(pobject.Update_status(record_id, 3)){
            pobject.Main_Table();
            JOptionPane.showMessageDialog(null, "Update Successfully!", "Update Menu", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Cannot update data now", "Update problem", JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_Rejected_ButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        open_web();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Accepted_Button;
    private javax.swing.JLabel Data_Record_Lebel;
    private javax.swing.JLabel DateTime;
    private javax.swing.JLabel Date_Reported;
    private javax.swing.JScrollPane Discription_Frame;
    private javax.swing.JLabel Discription_Lebel;
    private javax.swing.JTextArea Discription_text;
    private javax.swing.JLabel License_Province;
    private javax.swing.JLabel License_Text;
    private javax.swing.JLabel Location_Report;
    private javax.swing.JPanel Picture_Frame;
    private javax.swing.JLabel Picture_Label;
    private javax.swing.JButton Rejected_Button;
    private javax.swing.JLabel Reporter;
    private javax.swing.JLabel Reporter_Lebel;
    private javax.swing.JLabel Reporter_Lebel1;
    private javax.swing.JLabel Reporter_Lebel2;
    private javax.swing.JPanel Top_Label_Frame;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
