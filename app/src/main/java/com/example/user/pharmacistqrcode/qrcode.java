package com.example.user.pharmacistqrcode;

/**
 * Created by User on 24/3/2559.
 */
public class qrcode {
    int icon;
    String menuName;
    String time ;


    public qrcode(int icon, String menuName, String time){
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
