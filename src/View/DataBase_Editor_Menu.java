package View;

import javax.swing.JOptionPane;
import Controller.Main_Controller;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Desktop;
import java.net.URI;

public class DataBase_Editor_Menu extends javax.swing.JFrame {

    private final Main_Controller pobject;

    public DataBase_Editor_Menu(String RecordData[] , Main_Controller pobject) {
        initComponents();
        this.pobject = pobject;
        SetDefaultText(RecordData);
    }

    private void SetDefaultText(String RecordData[]) {
        Report_Datetime_text.setText(RecordData[0]);
        Case_Datetime_text.setText(RecordData[1]);
        Car_Brand_text.setText(RecordData[3]);
        Car_Color_text.setText(RecordData[4]);
        Lic_Plate_text.setText(RecordData[5]);
        Lic_Issuer_text.setText(RecordData[6]);
        Details_text.setText(RecordData[7]);
        Location_Name_text.setText(RecordData[8]);
        Location_lat_text.setText(RecordData[9]);
        Location_long_text.setText(RecordData[10]);
        Reporter_text.setText(RecordData[11]);
        Picture_URL_text.setText(RecordData[13]);
        Comment_text.setText(RecordData[14]);
        Case_ID_text.setText(RecordData[15]);
        SetImage(RecordData[13]);
        SetCombobox_Data(RecordData[2], RecordData[12]);
    }
    
    private void SetCombobox_Data(String Car_type_name_selected, String Status_name_selected){
        String All_car_type_name[] = pobject.Pull_all_car_type_name();
        String All_status_name[] = pobject.Pull_all_status_name();
        int count = 0;
        
        while(count < All_car_type_name.length){
            Car_class_combobox.addItem(All_car_type_name[count]);
            count++;
        }
        Car_class_combobox.setSelectedItem(Car_type_name_selected);
  
        count = 0;
        
        while(count < All_status_name.length){
            status_combobox.addItem(All_status_name[count]);
            count++;
        }
        status_combobox.setSelectedItem(Status_name_selected);
    }
    
    private void SetImage(String paramiterValue){
        try {
                String UrlLink = paramiterValue.replace(" ","%20");
                URL url = new URL(UrlLink);
                Image image = ImageIO.read(url.openStream());
                Image ImageRe = image.getScaledInstance(150, 180, Image.SCALE_SMOOTH);
                Show_Picture_Label.setIcon(new ImageIcon(ImageRe));
          } catch(Exception e){
                ImageIcon imageicon = new ImageIcon(getClass().getResource("/Image/No_Image.png"));
                Image ImageRe = imageicon.getImage().getScaledInstance(150, 180, Image.SCALE_SMOOTH);
                Show_Picture_Label.setIcon(new ImageIcon(ImageRe));
          }
    } 
    
    private String[] Get_Current_data(){
        String Current_data[] = new String[16];
        String Converted_data[] = Connvert_Data_to_ID(Car_class_combobox.getSelectedItem().toString(), status_combobox.getSelectedItem().toString());
        
            Current_data[0] = Case_ID_text.getText();
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
    
    private void open_web() {
        Desktop d = Desktop.getDesktop();
        String latitude = Location_lat_text.getText();
        String longtitude = Location_long_text.getText();
        try {
            d.browse(new URI("https://www.latlong.net/c/?lat="+latitude+"&long="+longtitude));
        }
        catch(Exception e) {
 
        }
        
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
        jButton1 = new javax.swing.JButton();
        Case_ID_text = new javax.swing.JLabel();
        Cast_ID_Label = new javax.swing.JLabel();
        Top_Label_Frame = new javax.swing.JPanel();
        Data_Record_Lebel = new javax.swing.JLabel();
        Button_Frame = new javax.swing.JPanel();
        UPDATE_button = new javax.swing.JButton();
        DELETE_button = new javax.swing.JButton();
        CLEAR_button = new javax.swing.JButton();
        BACK_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Data From Record");
        setMinimumSize(new java.awt.Dimension(713, 635));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Show_Picture_Label.setForeground(new java.awt.Color(255, 255, 255));
        Show_Picture_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Show_Picture_Label.setText("Set Image");
        jPanel3.add(Show_Picture_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 150, 180));

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
        jPanel2.add(Location_lat_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 80, -1));

        Location_lat_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(Location_lat_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 100, 30));

        Location_long_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Location_long_Label.setForeground(new java.awt.Color(255, 255, 255));
        Location_long_Label.setText("location_long");
        jPanel2.add(Location_long_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 100, -1));

        Location_long_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(Location_long_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 110, 30));

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

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("OPEN MAP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 240, 30));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 520, 580));

        Case_ID_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Case_ID_text.setForeground(new java.awt.Color(255, 255, 255));
        Case_ID_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Case_ID_text.setText("No Case ID");
        jPanel3.add(Case_ID_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 90, -1));

        Cast_ID_Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Cast_ID_Label.setForeground(new java.awt.Color(255, 255, 255));
        Cast_ID_Label.setText("Case ID");
        jPanel3.add(Cast_ID_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, -1, -1));

        Top_Label_Frame.setBackground(new java.awt.Color(0, 0, 0));
        Top_Label_Frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Data_Record_Lebel.setBackground(new java.awt.Color(255, 255, 255));
        Data_Record_Lebel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Data_Record_Lebel.setForeground(new java.awt.Color(255, 153, 0));
        Data_Record_Lebel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Data_Record_Lebel.setText("Edit Data From Record");
        Top_Label_Frame.add(Data_Record_Lebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 440, -1));

        jPanel3.add(Top_Label_Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 80));

        Button_Frame.setBackground(new java.awt.Color(0, 0, 0));
        Button_Frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UPDATE_button.setBackground(new java.awt.Color(255, 255, 0));
        UPDATE_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        UPDATE_button.setText("UPDATE");
        UPDATE_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE_buttonActionPerformed(evt);
            }
        });
        Button_Frame.add(UPDATE_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 40));

        DELETE_button.setBackground(new java.awt.Color(255, 0, 0));
        DELETE_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DELETE_button.setText("DELETE");
        DELETE_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETE_buttonActionPerformed(evt);
            }
        });
        Button_Frame.add(DELETE_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 140, 40));

        CLEAR_button.setBackground(new java.awt.Color(255, 0, 0));
        CLEAR_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CLEAR_button.setText("CLEAR ALL");
        CLEAR_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEAR_buttonActionPerformed(evt);
            }
        });
        Button_Frame.add(CLEAR_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 140, 40));

        BACK_button.setBackground(new java.awt.Color(153, 153, 153));
        BACK_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BACK_button.setText("Back");
        BACK_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACK_buttonActionPerformed(evt);
            }
        });
        Button_Frame.add(BACK_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 140, 40));

        jPanel3.add(Button_Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 160, 210));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BACK_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACK_buttonActionPerformed
        dispose();
    }//GEN-LAST:event_BACK_buttonActionPerformed

    private void UPDATE_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE_buttonActionPerformed
        if(pobject.Update_Data_From_Database(Get_Current_data())){
            pobject.Main_Table();
            JOptionPane.showMessageDialog(null, "Update Successfully!", "Insert Menu", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Cannot Update to Database!\nPlase recheck and input again!", "Insert Problem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_UPDATE_buttonActionPerformed

    private void DELETE_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETE_buttonActionPerformed
        int Confirm = JOptionPane.showConfirmDialog(null, "Delete this record?", "Select and Option...",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (Confirm == 0) {
            boolean removecheck = pobject.Remove_Data_From_Database(Integer.parseInt(Case_ID_text.getText()));

            if (removecheck) {
                pobject.Main_Table();
                JOptionPane.showMessageDialog(null, "Delete Successful!", "Deleted", JOptionPane.INFORMATION_MESSAGE);
            }
            dispose();
        }
    }//GEN-LAST:event_DELETE_buttonActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        open_web();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton DELETE_button;
    private javax.swing.JLabel Data_Record_Lebel;
    private javax.swing.JLabel Datail_Label;
    private javax.swing.JScrollPane Details_Frame;
    private javax.swing.JTextArea Details_text;
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
    private javax.swing.JButton UPDATE_button;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> status_combobox;
    // End of variables declaration//GEN-END:variables
}
