package View;

import javax.swing.JOptionPane;
import Controller.Main_Controller;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class DataBase_Insert_Menu extends javax.swing.JFrame {

    private final Main_Controller pobject;
    private final DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd ");
    private final LocalDateTime now = LocalDateTime.now();
    
    public DataBase_Insert_Menu(Main_Controller pobject) {
        initComponents();
        this.pobject = pobject;
        SetDefaultText();
    }

    private void SetDefaultText() {
        Report_Datetime_text.setText(dtf1.format(now));
        Case_Datetime_text.setText(dtf2.format(now));
        Case_ID_text.setText(String.valueOf(pobject.Qeury_Lastest_ID()+1));
        SetImage();
        SetCombobox_Data();
    }
    
    private void SetCombobox_Data(){
        String All_car_type_name[] = pobject.Pull_all_car_type_name();
        String All_status_name[] = pobject.Pull_all_status_name();
        int count = 0;
        
        while(count < All_car_type_name.length){
            Car_class_combobox.addItem(All_car_type_name[count]);
            count++;
        }
        Car_class_combobox.setSelectedIndex(-1);
        
        count = 0;
        
        while(count < All_status_name.length){
            status_combobox.addItem(All_status_name[count]);
            count++;
        }
        status_combobox.setSelectedIndex(-1);
    }
    
    private void SetImage(){
            ImageIcon imageicon = new ImageIcon(getClass().getResource("/Image/No_Image.png"));
            Image ImageRe = imageicon.getImage().getScaledInstance(150, 180, Image.SCALE_SMOOTH);
            Show_Picture_Label.setIcon(new ImageIcon(ImageRe));
    } 
    
    private String[] Get_Current_data(){
        String Current_data[] = new String[16];
        String Converted_data[] = Connvert_Data_to_ID(Car_class_combobox.getSelectedItem().toString(), status_combobox.getSelectedItem().toString());
        
            Current_data[1] = Report_Datetime_text.getText();
            Current_data[2] = Case_Datetime_text.getText();
            Current_data[3] = Converted_data[0];
            Current_data[4] = Car_Brand_text.getText();
            Current_data[5] = Car_Color_text.getText();
            Current_data[6] = Lic_Plate_text.getText();
            Current_data[7] = Lic_Issuer_text.getText();
            Current_data[8] = Details_text.getText();
            Current_data[9] = Location_Name_text.getText();
            Current_data[10] = Location_lat_text.getText();
            Current_data[11] = Location_long_text.getText();
            Current_data[12] = Reporter_text.getText();
            Current_data[13] = Converted_data[1];
            Current_data[14] = Picture_URL_text.getText();
            Current_data[15] = Comment_text.getText();
        
        return Current_data;
    }
    
    private String[] Connvert_Data_to_ID(String car_class, String status){
        String Change_Data[] = new String[2];
        
        for(int i = 0; i < Car_class_combobox.getItemCount(); i++){
            if(car_class.equals(Car_class_combobox.getItemAt(i))){
                Change_Data[0] = String.valueOf(++i);
                break;
            }
        }
        
        for(int i = 0; i < status_combobox.getItemCount(); i++){
            if(status.equals(status_combobox.getItemAt(i))){
                Change_Data[1] = String.valueOf(++i);
                break;
            }
        }
        
        return Change_Data;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        Show_Picture_Label = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Report_Datetime_Label = new javax.swing.JLabel();
        Report_Datetime_text = new javax.swing.JTextField();
        Location_Name_Label = new javax.swing.JLabel();
        Location_Frame = new javax.swing.JScrollPane();
        Location_Name_text = new javax.swing.JTextArea();
        Case_Datetime_Label = new javax.swing.JLabel();
        Case_Datetime_text = new javax.swing.JTextField();
        Car_Class_Label = new javax.swing.JLabel();
        Car_class_combobox = new javax.swing.JComboBox<>();
        Car_Brand_Label = new javax.swing.JLabel();
        Car_Brand_text = new javax.swing.JTextField();
        Car_Color_Label = new javax.swing.JLabel();
        Car_Color_text = new javax.swing.JTextField();
        Lic_Plate_Label = new javax.swing.JLabel();
        Lic_Plate_text = new javax.swing.JTextField();
        Lic_Issuer_Label = new javax.swing.JLabel();
        Lic_Issuer_text = new javax.swing.JTextField();
        Datail_Label = new javax.swing.JLabel();
        Details_Frame = new javax.swing.JScrollPane();
        Details_text = new javax.swing.JTextArea();
        Location_lat_Label = new javax.swing.JLabel();
        Location_lat_text = new javax.swing.JTextField();
        Location_long_Label = new javax.swing.JLabel();
        Location_long_text = new javax.swing.JTextField();
        Reporter_Label = new javax.swing.JLabel();
        Reporter_text = new javax.swing.JTextField();
        Status_Label = new javax.swing.JLabel();
        status_combobox = new javax.swing.JComboBox<>();
        Picture_url_Label = new javax.swing.JLabel();
        Picture_URl_Frame = new javax.swing.JScrollPane();
        Picture_URL_text = new javax.swing.JTextArea();
        Comment_Label = new javax.swing.JLabel();
        Comment_Frame = new javax.swing.JScrollPane();
        Comment_text = new javax.swing.JTextArea();
        Case_ID_text = new javax.swing.JLabel();
        Cast_ID_Label = new javax.swing.JLabel();
        Top_Label_Frame = new javax.swing.JPanel();
        Data_Record_Lebel = new javax.swing.JLabel();
        Button_Frame = new javax.swing.JPanel();
        INSERT_button = new javax.swing.JButton();
        CLEAR_button = new javax.swing.JButton();
        BACK_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insert Data From Record");
        setMinimumSize(new java.awt.Dimension(713, 635));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Show_Picture_Label.setForeground(new java.awt.Color(255, 255, 255));
        Show_Picture_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Show_Picture_Label.setText("Set Image");
        jPanel3.add(Show_Picture_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 150, 180));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Report_Datetime_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Report_Datetime_Label.setForeground(new java.awt.Color(255, 255, 255));
        Report_Datetime_Label.setText("report_datetime");
        jPanel2.add(Report_Datetime_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, -1));

        Report_Datetime_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(Report_Datetime_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 210, 30));

        Location_Name_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Location_Name_Label.setForeground(new java.awt.Color(255, 255, 255));
        Location_Name_Label.setText("location_name");
        jPanel2.add(Location_Name_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 170, -1));

        Location_Name_text.setColumns(20);
        Location_Name_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Location_Name_text.setRows(5);
        Location_Frame.setViewportView(Location_Name_text);

        jPanel2.add(Location_Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 240, 60));

        Case_Datetime_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Case_Datetime_Label.setForeground(new java.awt.Color(255, 255, 255));
        Case_Datetime_Label.setText("case_datetime");
        jPanel2.add(Case_Datetime_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 170, -1));

        Case_Datetime_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(Case_Datetime_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 210, 30));

        Car_Class_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Car_Class_Label.setForeground(new java.awt.Color(255, 255, 255));
        Car_Class_Label.setText("car_class");
        jPanel2.add(Car_Class_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 170, -1));

        Car_class_combobox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(Car_class_combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 210, 30));

        Car_Brand_Label.setBackground(new java.awt.Color(255, 255, 255));
        Car_Brand_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Car_Brand_Label.setForeground(new java.awt.Color(255, 255, 255));
        Car_Brand_Label.setText("car_brand");
        jPanel2.add(Car_Brand_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 170, -1));

        Car_Brand_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(Car_Brand_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 210, 30));

        Car_Color_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Car_Color_Label.setForeground(new java.awt.Color(255, 255, 255));
        Car_Color_Label.setText("car_color");
        jPanel2.add(Car_Color_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 170, -1));

        Car_Color_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(Car_Color_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 210, 30));

        Lic_Plate_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Lic_Plate_Label.setForeground(new java.awt.Color(255, 255, 255));
        Lic_Plate_Label.setText("lic_plate");
        jPanel2.add(Lic_Plate_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 170, -1));

        Lic_Plate_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(Lic_Plate_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 210, 30));

        Lic_Issuer_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Lic_Issuer_Label.setForeground(new java.awt.Color(255, 255, 255));
        Lic_Issuer_Label.setText("lic_issuer");
        jPanel2.add(Lic_Issuer_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 170, -1));

        Lic_Issuer_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(Lic_Issuer_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 210, 30));

        Datail_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Datail_Label.setForeground(new java.awt.Color(255, 255, 255));
        Datail_Label.setText("details");
        jPanel2.add(Datail_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 170, -1));

        Details_text.setColumns(20);
        Details_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Details_text.setRows(5);
        Details_Frame.setViewportView(Details_text);

        jPanel2.add(Details_Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 210, 80));

        Location_lat_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Location_lat_Label.setForeground(new java.awt.Color(255, 255, 255));
        Location_lat_Label.setText("location_lat");
        jPanel2.add(Location_lat_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 170, -1));

        Location_lat_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(Location_lat_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 240, 30));

        Location_long_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Location_long_Label.setForeground(new java.awt.Color(255, 255, 255));
        Location_long_Label.setText("location_long");
        jPanel2.add(Location_long_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 170, -1));

        Location_long_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(Location_long_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 240, 30));

        Reporter_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Reporter_Label.setForeground(new java.awt.Color(255, 255, 255));
        Reporter_Label.setText("reporter");
        jPanel2.add(Reporter_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 170, -1));

        Reporter_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(Reporter_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 240, 30));

        Status_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Status_Label.setForeground(new java.awt.Color(255, 255, 255));
        Status_Label.setText("status");
        jPanel2.add(Status_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 170, -1));

        status_combobox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(status_combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 240, 30));

        Picture_url_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Picture_url_Label.setForeground(new java.awt.Color(255, 255, 255));
        Picture_url_Label.setText("picture_url");
        jPanel2.add(Picture_url_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 170, -1));

        Picture_URL_text.setColumns(20);
        Picture_URL_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Picture_URL_text.setRows(5);
        Picture_URl_Frame.setViewportView(Picture_URL_text);

        jPanel2.add(Picture_URl_Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 240, 60));

        Comment_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Comment_Label.setForeground(new java.awt.Color(255, 255, 255));
        Comment_Label.setText("comment");
        jPanel2.add(Comment_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 170, -1));

        Comment_text.setColumns(20);
        Comment_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Comment_text.setRows(5);
        Comment_Frame.setViewportView(Comment_text);

        jPanel2.add(Comment_Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 240, 80));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 520, 580));

        Case_ID_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Case_ID_text.setForeground(new java.awt.Color(255, 255, 255));
        Case_ID_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Case_ID_text.setText("No Case ID");
        jPanel3.add(Case_ID_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 90, -1));

        Cast_ID_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Cast_ID_Label.setForeground(new java.awt.Color(255, 255, 255));
        Cast_ID_Label.setText("Case ID");
        jPanel3.add(Cast_ID_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, -1, -1));

        Top_Label_Frame.setBackground(new java.awt.Color(0, 0, 0));
        Top_Label_Frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Data_Record_Lebel.setBackground(new java.awt.Color(255, 255, 255));
        Data_Record_Lebel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Data_Record_Lebel.setForeground(new java.awt.Color(255, 153, 0));
        Data_Record_Lebel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Data_Record_Lebel.setText("Insert Data From Record");
        Top_Label_Frame.add(Data_Record_Lebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 700, -1));

        jPanel3.add(Top_Label_Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 80));

        Button_Frame.setBackground(new java.awt.Color(0, 0, 0));
        Button_Frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        INSERT_button.setBackground(new java.awt.Color(51, 255, 0));
        INSERT_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        INSERT_button.setText("INSERT");
        INSERT_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSERT_buttonActionPerformed(evt);
            }
        });
        Button_Frame.add(INSERT_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 40));

        CLEAR_button.setBackground(new java.awt.Color(255, 0, 0));
        CLEAR_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CLEAR_button.setText("CLEAR ALL");
        CLEAR_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEAR_buttonActionPerformed(evt);
            }
        });
        Button_Frame.add(CLEAR_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 140, 40));

        BACK_button.setBackground(new java.awt.Color(153, 153, 153));
        BACK_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BACK_button.setText("Back");
        BACK_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACK_buttonActionPerformed(evt);
            }
        });
        Button_Frame.add(BACK_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 140, 40));

        jPanel3.add(Button_Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 160, 160));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BACK_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACK_buttonActionPerformed
        dispose();
    }//GEN-LAST:event_BACK_buttonActionPerformed

    private void INSERT_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSERT_buttonActionPerformed
        if(pobject.Insert_Data_to_Database(Get_Current_data())){
            pobject.Main_Table();
            JOptionPane.showMessageDialog(null, "Insert Successfully!", "Insert Menu", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Cannot Insert to Database!\nPlase recheck and input again!", "Insert Problem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_INSERT_buttonActionPerformed

    private void CLEAR_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEAR_buttonActionPerformed
        int Confirm = JOptionPane.showConfirmDialog(null, "Clear all text?", "Select and Option...",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (Confirm == 0) {
            Report_Datetime_text.setText("");
            Case_Datetime_text.setText("");
            Car_Brand_text.setText("");
            Car_Color_text.setText("");
            Lic_Plate_text.setText("");
            Lic_Issuer_text.setText("");
            Details_text.setText("");
            Location_Name_text.setText("");
            Location_lat_text.setText("");
            Location_long_text.setText("");
            Reporter_text.setText("");
            Picture_URL_text.setText("");
            Comment_text.setText("");
            Case_ID_text.setText("No Case ID");
            Car_class_combobox.setSelectedIndex(-1);
            status_combobox.setSelectedIndex(-1);
                ImageIcon imageicon = new ImageIcon(getClass().getResource("/Image/No_Image.png"));
                Image ImageRe = imageicon.getImage().getScaledInstance(150, 180, Image.SCALE_SMOOTH);
                Show_Picture_Label.setIcon(new ImageIcon(ImageRe));
        }
    }//GEN-LAST:event_CLEAR_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACK_button;
    private javax.swing.JPanel Button_Frame;
    private javax.swing.JButton CLEAR_button;
    private javax.swing.JLabel Car_Brand_Label;
    private javax.swing.JTextField Car_Brand_text;
    private javax.swing.JLabel Car_Class_Label;
    private javax.swing.JLabel Car_Color_Label;
    private javax.swing.JTextField Car_Color_text;
    private javax.swing.JComboBox<String> Car_class_combobox;
    private javax.swing.JLabel Case_Datetime_Label;
    private javax.swing.JTextField Case_Datetime_text;
    private javax.swing.JLabel Case_ID_text;
    private javax.swing.JLabel Cast_ID_Label;
    private javax.swing.JScrollPane Comment_Frame;
    private javax.swing.JLabel Comment_Label;
    private javax.swing.JTextArea Comment_text;
    private javax.swing.JLabel Data_Record_Lebel;
    private javax.swing.JLabel Datail_Label;
    private javax.swing.JScrollPane Details_Frame;
    private javax.swing.JTextArea Details_text;
    private javax.swing.JButton INSERT_button;
    private javax.swing.JLabel Lic_Issuer_Label;
    private javax.swing.JTextField Lic_Issuer_text;
    private javax.swing.JLabel Lic_Plate_Label;
    private javax.swing.JTextField Lic_Plate_text;
    private javax.swing.JScrollPane Location_Frame;
    private javax.swing.JLabel Location_Name_Label;
    private javax.swing.JTextArea Location_Name_text;
    private javax.swing.JLabel Location_lat_Label;
    private javax.swing.JTextField Location_lat_text;
    private javax.swing.JLabel Location_long_Label;
    private javax.swing.JTextField Location_long_text;
    private javax.swing.JTextArea Picture_URL_text;
    private javax.swing.JScrollPane Picture_URl_Frame;
    private javax.swing.JLabel Picture_url_Label;
    private javax.swing.JLabel Report_Datetime_Label;
    private javax.swing.JTextField Report_Datetime_text;
    private javax.swing.JLabel Reporter_Label;
    private javax.swing.JTextField Reporter_text;
    private javax.swing.JLabel Show_Picture_Label;
    private javax.swing.JLabel Status_Label;
    private javax.swing.JPanel Top_Label_Frame;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> status_combobox;
    // End of variables declaration//GEN-END:variables
}
