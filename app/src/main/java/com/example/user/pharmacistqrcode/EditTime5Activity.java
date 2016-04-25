package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class EditTime5Activity extends Activity  {
    ArrayList<PendingIntent> intentarray = new ArrayList<PendingIntent>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_time5);
        String txt = getIntent().getStringExtra("txt");
        TextView txt0 = (TextView) findViewById(R.id.txtData1);
        TextView txt1 = (TextView) findViewById(R.id.txtData2);
        String a []= txt.split(";");
        txt0.setText("    ชื่อยา: " + a[0] + "  ชั่วโมงที่รับประทาน : " + a[1]);
        txt1.setText("    รับประทาน : " + a[2] + "  จำนวน : " + a[3]);

    }



    public void saves(View view){
        String txt = getIntent().getStringExtra("txt");
        String a []= txt.split(";");
        int icon = R.drawable.aaxc;
        String menuItem = "  ชื่อยา: "+ a[0]+"  ชั่วโมงที่รับประทาน : "+ a[1];
        String allTime = "    รับประทาน : "+a[2]+"   จำนวน : "+ a[3];

        Uri u =Uri.parse("content://qrcodeHour");
        ContentValues cv = new ContentValues();
        cv.put("icon", icon);
        cv.put("productname", menuItem.toString());
        cv.put("timeDate", allTime);
        Uri nari = getContentResolver().insert(u, cv);

        setAlarm(a[1]);
        Intent intent = new Intent(getApplicationContext(),QRCodeMenuActivity.class);
        startActivity(intent);
        finish();

    }

    public void setAlarm(String x){

        AlarmManager alarmManager;
        if(x =="ทุกๆ 1 ชั่วโมง") {
            Intent intent = new Intent(this,
                    AlarmReceiver1.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60 , 1000*60*60
                    , pi);

            intentarray.add(pi);
            MainActivity.io++;
        }else if(x =="ทุกๆ 2 ชั่วโมง") {
            Intent intent = new Intent(this,
                    AlarmReceiver1.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*2 , 1000*60*60*2
                    , pi);

            intentarray.add(pi);
            MainActivity.io++;
        }else if(x =="ทุกๆ 3 ชั่วโมง") {
            Intent intent = new Intent(this,
                    AlarmReceiver1.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*3 , 1000*60*60*3
                    , pi);

            intentarray.add(pi);
            MainActivity.io++;
        }else if(x =="ทุกๆ 4 ชั่วโมง") {
            Intent intent = new Intent(this,
                    AlarmReceiver1.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*4 , 1000*60*60*4
                    , pi);

            intentarray.add(pi);
            MainActivity.io++;
        }else if(x =="ทุกๆ 5 ชั่วโมง") {
            Intent intent = new Intent(this,
                    AlarmReceiver1.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*5 , 1000*60*60*5
                    , pi);

            intentarray.add(pi);
            MainActivity.io++;
        }else if(x =="ทุกๆ 6 ชั่วโมง") {
            Intent intent = new Intent(this,
                    AlarmReceiver1.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*6 , 1000*60*60*6
                    , pi);

            intentarray.add(pi);
            MainActivity.io++;
        }else if(x =="ทุกๆ 7 ชั่วโมง") {
            Intent intent = new Intent(this,
                    AlarmReceiver1.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*7 , 1000*60*60*7
                    , pi);

            intentarray.add(pi);
            MainActivity.io++;
        }else if(x =="ทุกๆ 8 ชั่วโมง") {
            Intent intent = new Intent(this,
                    AlarmReceiver1.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*8 , 1000*60*60*8
                    , pi);

            intentarray.add(pi);
            MainActivity.io++;
        }else if(x =="ทุกๆ 9 ชั่วโมง") {
            Intent intent = new Intent(this,
                    AlarmReceiver1.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*9 , 1000*60*60*9
                    , pi);

            intentarray.add(pi);
            MainActivity.io++;
        }else if(x =="ทุกๆ 10 ชั่วโมง") {
            Intent intent = new Intent(this,
                    AlarmReceiver1.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*10 , 1000*60*60*10
                    , pi);

            intentarray.add(pi);
            MainActivity.io++;
        }else if(x =="ทุกๆ 11 ชั่วโมง") {
            Intent intent = new Intent(this,
                    AlarmReceiver1.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*11 , 1000*60*60*11
                    , pi);

            intentarray.add(pi);
            MainActivity.io++;
        }else if(x =="ทุกๆ 12 ชั่วโมง") {
            Intent intent = new Intent(this,
                    AlarmReceiver1.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*12 , 1000*60*60*12
                    , pi);

            intentarray.add(pi);
            MainActivity.io++;
        }

    }


}
