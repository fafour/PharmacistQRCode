package com.example.user.pharmacistqrcode;

import java.util.ArrayList;

/**
 * Created by User on 12/2/2559.
 */
public class item {
    int icon;
    String menuName;
    String time ;


    public item(int icon, String menuName, String time){
        this.icon = icon;
        this.menuName = menuName;
        this.time = time ;
    }
    public int getIcon() {
        return icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getTime() {
        return time;
    }
}
