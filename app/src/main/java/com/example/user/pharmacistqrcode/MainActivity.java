package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends Activity {
    ImageButton scanQRCode, alert, history, add;
    Button qrCode, setting, menu, addItem;
    public static int io = 0;
    public static int io1 = 0;
    public static int io2 = 0;
    public static int io3 = 0;
    public static int io4 = 0;
    public static int io5 = 0;
    public static int io6 = 0;
    public static int io7 = 0;
    public static int io8 = 0;
    public static int io9 = 0;
    public static int io10 = 0;
    public static int io11 = 0;
    public static int io12 = 0;
    public static ArrayList<PendingIntent> intentarray = new ArrayList<PendingIntent>();
    public static ArrayList<Calendar>calTimes = new ArrayList<Calendar>();
    public static ArrayList<PendingIntent> intentarray1 = new ArrayList<PendingIntent>();
    public static ArrayList<Calendar>calTimes1 = new ArrayList<Calendar>();
    public static ArrayList<PendingIntent> intentarray2 = new ArrayList<PendingIntent>();
    public static ArrayList<Calendar>calTimes2 = new ArrayList<Calendar>();
    public static ArrayList<PendingIntent> intentarray3 = new ArrayList<PendingIntent>();
    public static ArrayList<Calendar>calTimes3 = new ArrayList<Calendar>();
    public static ArrayList<PendingIntent> intentarray4 = new ArrayList<PendingIntent>();
    public static ArrayList<Calendar>calTimes4 = new ArrayList<Calendar>();
    public static ArrayList<PendingIntent> intentarray5 = new ArrayList<PendingIntent>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //-----------------------------------------------------------------------------------------------------------------------------


    public void btnQRCode(View v) {
        scanQRCode  = (ImageButton) findViewById(R.id.imbScanQRCode);
        qrCode = (Button) findViewById(R.id.btqrcode);
        Intent intent = new Intent(getApplicationContext(), DecoderActivity.class);
        startActivity(intent);

        }


    //--------------------------------------------------------------------------------------------------------------------------------------------
    public void btnSetting(View v) {
        alert = (ImageButton) findViewById(R.id.imbSetting);
        setting = (Button) findViewById(R.id.btSitting);

        Intent intent = new Intent(getApplicationContext(), SettingSystemActivity.class);
        startActivity(intent);
    }

    public void btnHistory(View v) {
        history = (ImageButton) findViewById(R.id.imbHistory);
        menu = (Button) findViewById(R.id.btHistory);

        Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
        startActivity(intent);
    }

    public void btnAdd(View v) {
        add = (ImageButton) findViewById(R.id.imbAdd);
        addItem = (Button) findViewById(R.id.btAdd);

        Intent intent = new Intent(getApplicationContext(), AddActivity.class);
        startActivity(intent);
    }



}