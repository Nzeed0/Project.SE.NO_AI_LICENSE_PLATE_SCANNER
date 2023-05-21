package Controller;

import javax.swing.*;
import javax.swing.table.*;

public class Setting_Table_Layout {
    
    public void settingLayout(javax.swing.JTable Table){
        DefaultTableCellRenderer setRight = new DefaultTableCellRenderer();
        DefaultTableCellRenderer setLeft = new DefaultTableCellRenderer();
        DefaultTableCellRenderer setCenter = new DefaultTableCellRenderer();
        
        setRight.setHorizontalAlignment(JLabel.RIGHT);
        setLeft.setHorizontalAlignment(JLabel.LEFT);
        setCenter.setHorizontalAlignment(JLabel.CENTER);
        
        for(int i = 2; i <= 5; i++){
            Table.getColumnModel().getColumn(i).setCellRenderer(setLeft);
        }
        
        Table.getColumnModel().getColumn(1).setCellRenderer(setCenter);
        Table.getColumnModel().getColumn(7).setCellRenderer(setLeft);
        Table.getColumnModel().getColumn(8).setCellRenderer(setCenter);
    }
    
    public void settingColumnWide(javax.swing.JTable Table){
        Table.getColumnModel().getColumn(0).setPreferredWidth(25);
        Table.getColumnModel().getColumn(1).setPreferredWidth(110);
        Table.getColumnModel().getColumn(2).setPreferredWidth(25);
        Table.getColumnModel().getColumn(3).setPreferredWidth(25);
        Table.getColumnModel().getColumn(4).setPreferredWidth(30);
        Table.getColumnModel().getColumn(5).setPreferredWidth(55);
        Table.getColumnModel().getColumn(6).setPreferredWidth(170);
        Table.getColumnModel().getColumn(7).setPreferredWidth(20);
        Table.getColumnModel().getColumn(8).setPreferredWidth(30);
    }
    
    public void RealTimeUpdateSearchBox(javax.swing.JTable Table, javax.swing.JTextField SearchText){
        DefaultTableModel model = (DefaultTableModel)Table.getModel();
        TableRowSorter<DefaultTableModel> tablesort = new TableRowSorter<>(model);
        Table.setRowSorter(tablesort);
        tablesort.setRowFilter(RowFilter.regexFilter(SearchText.getText().trim()));
    }
}
