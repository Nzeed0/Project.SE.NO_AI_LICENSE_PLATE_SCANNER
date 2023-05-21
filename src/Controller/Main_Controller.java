package Controller;

import View.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class Main_Controller {

    private Main_Page view;
    private Login_Page login;
    private JTable Table;
    private Setting_Table_Layout st;

    private Connection connecttion;
    private PreparedStatement pst;
    private ResultSet rs;

    public Main_Controller() {
        StartConnect();
    }

    public void setViewObj(Main_Page view) {
        this.view = view;
    }

    public void setLoginObj(Login_Page login) {
        this.login = login;
    }

    public void SettingtableLayOut(Setting_Table_Layout settingTableLO) {
        st = settingTableLO;
    }

    public void setJTableObj(JTable Table) {
        this.Table = Table;
    }

    private void StartConnect() {
        String connect_url = "jdbc:mysql://home112.ddns.net:3306/wittaya";
        String user = "wittaya";
        String password = "@u7WuW9m9n1h9B3nK";

        try {
            connecttion = DriverManager.getConnection(connect_url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private ArrayList<User_table_format> Query_userRole() {
        String sql = "SELECT * FROM users";
        ArrayList<User_table_format> user_data = new ArrayList<>();
        User_table_format usr;

        try {
            pst = connecttion.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                usr = new User_table_format(rs.getString("username"), rs.getString("email"), rs.getString("passwords"), rs.getString("role"));
                user_data.add(usr);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user_data;
    }

    private ResultSet Pull_reporter_name_choosing(String retporterID) {
        String sql;
        ResultSet reporter_name;

        try {
            sql = "SELECT first_name, last_name FROM users WHERE usr_id = " + retporterID;
                pst = connecttion.prepareStatement(sql);
                reporter_name = pst.executeQuery();
                reporter_name.next();
            return reporter_name;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
                reporter_name = null;
            return reporter_name;
        }
    }
    
    private ResultSet Pull_car_type_name_choosing(String car_class_ID){
        String sql = "SELECT car_type FROM car_classes WHERE class_id = " + car_class_ID;
        ResultSet car_class_name;
        
        try{
                pst = connecttion.prepareStatement(sql);
                car_class_name = pst.executeQuery();
                car_class_name.next();
            return car_class_name;
        } catch(SQLException e){
            System.out.println(e.getMessage());
                car_class_name = null;
            return car_class_name;
        }
    }
    
    private ResultSet Pull_status_name_choosing(String status_ID){
        String sql = "SELECT name FROM status WHERE status_id = " + status_ID;
        ResultSet status_name;
        
        try{
            pst = connecttion.prepareStatement(sql);
            status_name = pst.executeQuery();
            status_name.next();
            return status_name;
        } catch(SQLException e){
            System.out.println(e.getMessage());
                status_name = null;
            return status_name;
        }
    }
    
    public int Qeury_Lastest_ID(){
        String sql = "SELECT MAX(case_id) FROM report";
        int Max_ID = 0;
        
        try{
            pst = connecttion.prepareStatement(sql);
            rs = pst.executeQuery();
            
            rs.next();
            Max_ID = rs.getInt(1);
            return Max_ID;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return Max_ID;
        }
    }
    
    public String[] Pull_all_car_type_name(){
        String sql = "SELECT car_type FROM car_classes";
        String RecordData[] = new String[4];
        int count = 0;
        
        try{
            pst = connecttion.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                RecordData[count] = rs.getString(1);
                count++;
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
            RecordData = null;
        }
        return RecordData;
    }
    
    public String[] Pull_all_status_name(){
        String sql = "SELECT name FROM status";
        String RecordData[] = new String[4];
        int count = 0;
        
        try{
            pst = connecttion.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                RecordData[count] = rs.getString(1);
                count++;
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
            RecordData = null;
        }
        return RecordData;
    }

    public boolean Main_Table() {
        String sql = "SELECT * FROM report";
        DefaultTableModel model = (DefaultTableModel)Table.getModel();

        ResultSet reporter_name;
        int Count = 0;

        try {
            pst = connecttion.prepareStatement(sql);
            rs = pst.executeQuery();

            model.setRowCount(0);

            st.settingColumnWide(Table);
            st.settingLayout(Table);
            while (rs.next()) {
                reporter_name = Pull_reporter_name_choosing(rs.getString("reporter"));

                Object Data_set[] = {rs.getInt("case_id"), rs.getString("case_datetime"), rs.getString("car_brand"), rs.getString("car_color"),
                    rs.getString("lic_plate"), rs.getString("lic_issuer"), rs.getString("location_name"),
                    reporter_name.getString(1) + " " +reporter_name.getString(2).substring(0, 1), Pull_status_name_choosing(rs.getString("status")).getString(1)
                };
                model.addRow(Data_set);
                Count++;
            }
            view.setToday_reportCount(String.valueOf(Count));
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public void Check_userRole(String Textbox1, String Textbox2) {
        ArrayList<User_table_format> user_data = Query_userRole();
        for (int i = 0; i < user_data.size(); i++) {
            if ((Textbox1.equals(user_data.get(i).getUsername()) || Textbox1.equals(user_data.get(i).getEmail()))
                    && Textbox2.equals(user_data.get(i).getPassword()) && (user_data.get(i).getRole().equals("admin")
                    || user_data.get(i).getRole().equals("staff"))) {
                view.SetUserNameLebel(user_data.get(i).getUsername());
                login.setVisible(false);
                view.setVisible(true);
                return;
            }
        }
        login.ErrorLoginPopup();
    }
    
    public String[] Pull_Record_Data_Double_Click_Page(int recordID) {
        String sql = "SELECT * FROM report WHERE case_id = " + recordID;
        String Record_data[] = new String[9];
        ResultSet reportername;

        try {
            pst = connecttion.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
                reportername = Pull_reporter_name_choosing(rs.getString("reporter"));
            Record_data[0] = rs.getString("case_datetime");
            Record_data[1] = rs.getString("lic_plate");
            Record_data[2] = rs.getString("lic_issuer");
            Record_data[3] = rs.getString("details");
            Record_data[4] = rs.getString("location_name");
            Record_data[5] = reportername.getString(1) + " " +reportername.getString(2);
            Record_data[6] = rs.getString("picture");
            Record_data[7] = rs.getString("location_lat");
            Record_data[8] = rs.getString("location_long");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Record_data;
    }

    public String[] Pull_Record_Data_DataBase_Editor_Menu(int recordID) {
        String sql = "SELECT * FROM report WHERE case_id = " + recordID;
        String RecordData[] = new String[16];
        ResultSet reporter_name, car_class_name, status_name;
        
        try {
            pst = connecttion.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            
            reporter_name = Pull_reporter_name_choosing(rs.getString("reporter"));
            car_class_name = Pull_car_type_name_choosing(rs.getString("car_class"));
            status_name = Pull_status_name_choosing(rs.getString("status"));
            
            RecordData[0] = rs.getString("report_datetime");
            RecordData[1] = rs.getString("case_datetime");
            RecordData[2] = car_class_name.getString(1);
            RecordData[3] = rs.getString("car_brand");
            RecordData[4] = rs.getString("car_color");
            RecordData[5] = rs.getString("lic_plate");
            RecordData[6] = rs.getString("lic_issuer");
            RecordData[7] = rs.getString("details");
            RecordData[8] = rs.getString("location_name");
            RecordData[9] = rs.getString("location_lat");
            RecordData[10] = rs.getString("location_long");
            RecordData[11] = reporter_name.getString(1) + " " +reporter_name.getString(2);
            RecordData[12] = status_name.getString(1);
            RecordData[13] = rs.getString("picture");
            RecordData[14] = rs.getString("comment");
            RecordData[15] = rs.getString("case_id");

            return RecordData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            RecordData = null;
            return RecordData;
        }
    }
    
    private String Change_Data_Before_Insert(String Original_data){
        String sql = "";
        String Changed_data = "";
        
        ResultSet user_id;
        
        try{
            Scanner scanner = new Scanner(Original_data);
            String first_name = scanner.next(), 
                    last_name = scanner.next();
            
            sql = "SELECT usr_id FROM users WHERE first_name  = '"+first_name+"'"
                    + " AND last_name = '"+last_name+"'";
            
            pst = connecttion.prepareStatement(sql);
            user_id = pst.executeQuery();
            
            user_id.next();
            
            Changed_data = user_id.getString(1);
            
            return Changed_data;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return Changed_data;
        }
        
    }
    
    public boolean Update_status(int ID, int ButtonType){
        String sql = "UPDATE report \nSET "
                     + " status = '"+ButtonType+"'"
                     + "\nWHERE case_id = '"+ID+"'";
        
        try{
            pst = connecttion.prepareStatement(sql);
            pst.execute();
            return true;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }          
    }
    
    public boolean Insert_Data_to_Database(String Record_Data[]){
        String Changed_data = Change_Data_Before_Insert(Record_Data[12]);
        Record_Data[0] = String.valueOf(Qeury_Lastest_ID()+1);
        String sql = "INSERT INTO report (case_id, report_datetime, case_datetime, car_class, car_brand, car_color, lic_plate, "
                     + "lic_issuer, details, location_name, location_lat, location_long, reporter, status, picture, comment)"
                     + "\nVALUES ("+"'"+Record_Data[0]+"'"+","+"'"+Record_Data[1]+"'"+","+"'"+Record_Data[2]+"'"+","+"'"+Record_Data[3]+"'"+","+"'"+Record_Data[4]+"'"+","
                     + "'"+Record_Data[5]+"'"+","+"'"+Record_Data[6]+"'"+","+"'"+Record_Data[7]+"'"+","+"'"+Record_Data[8]+"'"+","+"'"+Record_Data[9]+"'"+","+"'"+Record_Data[10]+"'"+","
                     + "'"+Record_Data[11]+"'"+","+"'"+Changed_data+"'"+","+"'"+Record_Data[13]+"'"+","+"'"+Record_Data[14]+"'"+","+"'"+Record_Data[15]+"')";
        
        try{
            pst = connecttion.prepareStatement(sql);
            pst.execute();
            return true;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean Update_Data_From_Database(String Record_Data[]){
        String Changed_data = Change_Data_Before_Insert(Record_Data[12]);
        String sql = "UPDATE report \nSET "
                     + " report_datetime = '"+Record_Data[1]+"'"+","+" case_datetime = '"+Record_Data[2]+"'"+","+" car_class = '"+Record_Data[3]+"'"+","+" car_brand = '"+Record_Data[4]+"'"+","
                     + " car_color = '"+Record_Data[5]+"'"+","+" lic_plate = '"+Record_Data[6]+"'"+","+" lic_issuer = '"+Record_Data[7]+"'"+","+" details = '"+Record_Data[8]+"'"+","+" location_name = '"+Record_Data[9]+"'"+","+" location_lat = '"+Record_Data[10]+"'"+","
                     + " location_long = '"+Record_Data[11]+"'"+","+" reporter = '"+Changed_data+"'"+","+" status = '"+Record_Data[13]+"'"+","+" picture = '"+Record_Data[14]+"'"+","+" comment = '"+Record_Data[15]+"'"
                     + "\nWHERE case_id = "+Record_Data[0];
        
        try{
            pst = connecttion.prepareStatement(sql);
            pst.execute();
            return true;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean Remove_Data_From_Database(int recordID) {
        String sql = "DELETE FROM report WHERE case_id = " + recordID;

        try {
            pst = connecttion.prepareStatement(sql);
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
