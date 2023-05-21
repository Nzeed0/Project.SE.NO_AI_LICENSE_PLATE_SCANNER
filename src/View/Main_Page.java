package View;

import Controller.*;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Main_Page extends javax.swing.JFrame {

    private Main_Controller pobject;
    private Setting_Table_Layout SettingLO;

    public Main_Page() {
        initComponents();
    }
    
    public void setPulldataOBJ(Main_Controller pobject) {
        this.pobject = pobject;
    }

    public void setTableLayOutObj(Setting_Table_Layout SettingLO) {
        this.SettingLO = SettingLO;
    }

    public void SetUserNameLebel(String name) {
        User_Lebel.setText(name);
    }
    
    public int GetLastID(){
        return (int)Table_Display.getModel().getValueAt(Table_Display.getRowCount()-1, 0);
    }
    
    private int GetSelectedID() {
        return (int)Table_Display.getModel().getValueAt(Table_Display.getSelectedRow(), 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopUp_Menu = new javax.swing.JPopupMenu();
        Remove_Record_Menu = new javax.swing.JMenuItem();
        Edit_Record_Menu = new javax.swing.JMenuItem();
        Close_Menu = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Display = new javax.swing.JTable();
        Today_report_frame = new javax.swing.JPanel();
        Today_report_Lebel = new javax.swing.JLabel();
        Today_reportCount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Search_text_field = new javax.swing.JTextField();
        update_button = new javax.swing.JButton();
        print_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Welcome_Lebel = new javax.swing.JLabel();
        User_Lebel = new javax.swing.JLabel();

        Remove_Record_Menu.setForeground(new java.awt.Color(153, 153, 153));
        Remove_Record_Menu.setText("Remove row");
        Remove_Record_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Remove_Record_MenuActionPerformed(evt);
            }
        });
        PopUp_Menu.add(Remove_Record_Menu);

        Edit_Record_Menu.setText("Edit row");
        Edit_Record_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_Record_MenuActionPerformed(evt);
            }
        });
        PopUp_Menu.add(Edit_Record_Menu);

        Close_Menu.setText("Close");
        PopUp_Menu.add(Close_Menu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main_GUI");
        setMinimumSize(new java.awt.Dimension(1050, 780));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(1040, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table_Display.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Table_Display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Case ID", "Case Datetime", "Car Brand", "Car Color", "Licent Plate", "Licent Issure", "Location", "Reporter", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Display.setColumnSelectionAllowed(true);
        Table_Display.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Table_Display.setRowHeight(25);
        Table_Display.getTableHeader().setReorderingAllowed(false);
        Table_Display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_DisplayMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Table_DisplayMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Display);
        Table_Display.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (Table_Display.getColumnModel().getColumnCount() > 0) {
            Table_Display.getColumnModel().getColumn(0).setResizable(false);
            Table_Display.getColumnModel().getColumn(1).setResizable(false);
            Table_Display.getColumnModel().getColumn(2).setResizable(false);
            Table_Display.getColumnModel().getColumn(3).setResizable(false);
            Table_Display.getColumnModel().getColumn(4).setResizable(false);
            Table_Display.getColumnModel().getColumn(5).setResizable(false);
            Table_Display.getColumnModel().getColumn(6).setResizable(false);
            Table_Display.getColumnModel().getColumn(7).setResizable(false);
            Table_Display.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 175, 978, 550));

        Today_report_frame.setBackground(new java.awt.Color(54, 54, 54));
        Today_report_frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Today_report_Lebel.setBackground(new java.awt.Color(0, 0, 0));
        Today_report_Lebel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Today_report_Lebel.setForeground(new java.awt.Color(255, 255, 255));
        Today_report_Lebel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Today_report_Lebel.setText("จำนวนรายงาน");
        Today_report_Lebel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Today_report_frame.add(Today_report_Lebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 20));

        Today_reportCount.setEditable(false);
        Today_reportCount.setBackground(new java.awt.Color(255, 153, 0));
        Today_reportCount.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Today_reportCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Today_reportCount.setText("0");
        Today_reportCount.setAutoscrolls(false);
        Today_reportCount.setBorder(null);
        Today_report_frame.add(Today_reportCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 190, 50));

        jPanel1.add(Today_report_frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 190, 110));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ค้นหา :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, 30));

        Search_text_field.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Search_text_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Search_text_fieldKeyPressed(evt);
            }
        });
        jPanel1.add(Search_text_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 360, 30));

        update_button.setBackground(new java.awt.Color(204, 204, 204));
        update_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update_button.setText("Update");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(update_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 130, 90, 30));

        print_button.setBackground(new java.awt.Color(204, 204, 204));
        print_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        print_button.setText("Print");
        print_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(print_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, 90, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("ประวัติรายงาน");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        Welcome_Lebel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Welcome_Lebel.setForeground(new java.awt.Color(255, 255, 255));
        Welcome_Lebel.setText("ยินดีต้อนรับ");
        jPanel1.add(Welcome_Lebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, -1, -1));

        User_Lebel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        User_Lebel.setForeground(new java.awt.Color(255, 255, 255));
        User_Lebel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        User_Lebel.setText("username");
        jPanel1.add(User_Lebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 160, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        if(pobject.Main_Table()){
            JOptionPane.showMessageDialog(null, "Update Successfully!", "Update Menu", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Cannot update data now", "Update problem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_update_buttonActionPerformed

    private void Search_text_fieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Search_text_fieldKeyPressed
        SettingLO.RealTimeUpdateSearchBox(Table_Display, Search_text_field);
    }//GEN-LAST:event_Search_text_fieldKeyPressed

    private void Table_DisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_DisplayMouseClicked
        if (evt.getClickCount() == 2 && evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            int Selected_ID = GetSelectedID();
            String Text_record[] = pobject.Pull_Record_Data_Double_Click_Page(Selected_ID);
            try {
                String url = Text_record[6];
                DoubleClick_Record_Page ViewRecord = new DoubleClick_Record_Page(url, Text_record, Selected_ID, pobject);
                ViewRecord.setVisible(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_Table_DisplayMouseClicked

    private void print_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_buttonActionPerformed
        MessageFormat header = new MessageFormat("Report report");
        MessageFormat footer = new MessageFormat("Page {0, number, integer}");
        try {
            Table_Display.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("No Pinter found", e.getMessage());
        }
    }//GEN-LAST:event_print_buttonActionPerformed

    private void Table_DisplayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_DisplayMouseReleased
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            if (evt.isPopupTrigger() && Table_Display.getSelectedRowCount() != 0) {
                PopUp_Menu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_Table_DisplayMouseReleased

    private void Remove_Record_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Remove_Record_MenuActionPerformed
        int Confirm = JOptionPane.showConfirmDialog(null, "Remove this record?", "Select and Option...",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (Confirm == 0) {
            boolean removecheck = pobject.Remove_Data_From_Database(GetSelectedID());

            if (removecheck) {
                pobject.Main_Table();
                JOptionPane.showMessageDialog(null, "Delete Successful!", "Deleted", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_Remove_Record_MenuActionPerformed

    private void Edit_Record_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_Record_MenuActionPerformed
        String RecordData[] = pobject.Pull_Record_Data_DataBase_Editor_Menu(GetSelectedID());

        if (RecordData != null) {
            DataBase_Editor_Menu dataBase_Editor_Menu = new DataBase_Editor_Menu(RecordData, pobject);
            dataBase_Editor_Menu.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(null, "there's no this record anymore!");
        }
    }//GEN-LAST:event_Edit_Record_MenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Close_Menu;
    private javax.swing.JMenuItem Edit_Record_Menu;
    private javax.swing.JPopupMenu PopUp_Menu;
    private javax.swing.JMenuItem Remove_Record_Menu;
    private javax.swing.JTextField Search_text_field;
    private javax.swing.JTable Table_Display;
    private javax.swing.JTextField Today_reportCount;
    private javax.swing.JLabel Today_report_Lebel;
    private javax.swing.JPanel Today_report_frame;
    private javax.swing.JLabel User_Lebel;
    private javax.swing.JLabel Welcome_Lebel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton print_button;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTable getTable() {
        return Table_Display;
    }

    public void setToday_reportCount(String input) {
        Today_reportCount.setText(input);
    }
}
