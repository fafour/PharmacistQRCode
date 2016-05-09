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

public class EditTime5Activity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_time5);
        String txt = getIntent().getStringExtra("txt");
        TextView txt0 = (TextView) findViewById(R.id.txtData1);
        TextView txt1 = (TextView) findViewById(R.id.txtData2);
        String a []= txt.split(";");
        txt0.setText("   ชื่อยา: " + a[0] + " ช่วงเวลา :" + a[1]);
        txt1.setText("   รับประทาน : " + a[2] + "  จำนวน : " + a[3]);

    }
    public void saves(View view){
        String txt = getIntent().getStringExtra("txt");
        String a []= txt.split(";");
        int icon = R.drawable.aaxc;
        String menuItem = "  ชื่อยา: "+ a[0]+"  ช่วงเวลา : "+ a[1];
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
        if(x =="   ทุกๆ1 ชม") {
            Intent intent = new Intent(this,
                    AlarmReceiver6.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60 , 1000*60*60
                    , pi);

            MainActivity.intentarray5.add(pi);
            MainActivity.io1++;
        }else if(x =="   ทุกๆ2 ชม") {
            Intent intent = new Intent(this,
                    AlarmReceiver6.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io2, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*2 , 1000*60*60*2
                    , pi);

            MainActivity.intentarray5.add(pi);
            MainActivity.io2++;
        }else if(x =="   ทุกๆ3 ชม") {
            Intent intent = new Intent(this,
                    AlarmReceiver6.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io3, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*3 , 1000*60*60*3
                    , pi);

            MainActivity.intentarray5.add(pi);
            MainActivity.io3++;
        }else if(x =="   ทุกๆ4 ชม") {
            Intent intent = new Intent(this,
                    AlarmReceiver6.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io4, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*4 , 1000*60*60*4
                    , pi);

            MainActivity.intentarray5.add(pi);
            MainActivity.io4++;
        }else if(x =="   ทุกๆ5 ชม") {
            Intent intent = new Intent(this,
                    AlarmReceiver6.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io5, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*5 , 1000*60*60*5
                    , pi);

            MainActivity.intentarray5.add(pi);
            MainActivity.io5++;
        }else if(x =="   ทุกๆ6 ชม") {
            Intent intent = new Intent(this,
                    AlarmReceiver6.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io6, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*6 , 1000*60*60*6
                    , pi);

            MainActivity.intentarray5.add(pi);
            MainActivity.io6++;
        }else if(x =="   ทุกๆ7 ชม") {
            Intent intent = new Intent(this,
                    AlarmReceiver6.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io7, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*7 , 1000*60*60*7
                    , pi);

            MainActivity.intentarray5.add(pi);
            MainActivity.io7++;
        }else if(x =="   ทุกๆ8 ชม") {
            Intent intent = new Intent(this,
                    AlarmReceiver6.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io8, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*8 , 1000*60*60*8
                    , pi);

            MainActivity.intentarray5.add(pi);
            MainActivity.io8++;
        }else if(x =="   ทุกๆ9 ชม") {
            Intent intent = new Intent(this,
                    AlarmReceiver6.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io9, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*9 , 1000*60*60*9
                    , pi);

            MainActivity.intentarray5.add(pi);
            MainActivity.io9++;
        }else if(x =="   ทุกๆ10 ชม") {
            Intent intent = new Intent(this,
                    AlarmReceiver6.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io10, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*10 , 1000*60*60*10
                    , pi);

            MainActivity.intentarray5.add(pi);
            MainActivity.io10++;
        }else if(x =="   ทุกๆ11 ชม") {
            Intent intent = new Intent(this,
                    AlarmReceiver6.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io11, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*11 , 1000*60*60*11
                    , pi);

            MainActivity.intentarray5.add(pi);
            MainActivity.io11++;
        }else if(x =="   ทุกๆ12 ชม") {
            Intent intent = new Intent(this,
                    AlarmReceiver6.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this, MainActivity.io12, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*12 , 1000*60*60*12
                    , pi);

            MainActivity.intentarray5.add(pi);
            MainActivity.io12++;
        }else {

        }

    }


}
