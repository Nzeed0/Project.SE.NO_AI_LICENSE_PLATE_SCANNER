package Main;

import Controller.*;
import View.*;

public class Process {

    public Process() {
         Main_Controller PulldataObj = new Main_Controller();
         Main_Page view = new Main_Page();
         Login_Page login = new Login_Page();
         Setting_Table_Layout setting = new Setting_Table_Layout();
         Link_Object(login, view, PulldataObj, setting);
         Start_Process(login);
         
         /*PulldataObj.Main_Table();
         view.setVisible(true);*/
    }
    
    private void Link_Object(Login_Page login, Main_Page view, Main_Controller pobject, Setting_Table_Layout Setting){
         pobject.setJTableObj(view.getTable());
         pobject.setViewObj(view);
         pobject.setLoginObj(login);
         pobject.SettingtableLayOut(Setting);
         view.setPulldataOBJ(pobject);
         view.setTableLayOutObj(Setting);
         login.setPulldataOBJ(pobject);
    }
    
    private void Start_Process(Login_Page login){
        login.setVisible(true);
    }

}
