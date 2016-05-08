package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeActivity extends Activity  {
    TextView txt,timeEdit1,timeEdit2,timeEdit3,timeEdit4;
    private int pHour1;
    private int pMinute1;
    private int pHour2;
    private int pMinute2;
    private int pHour3;
    private int pMinute3;
    private int pHour4;
    private int pMinute4;
    static final int TIME_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID1 = 1;
    static final int TIME_DIALOG_ID2 = 2;
    static final int TIME_DIALOG_ID3 = 3;

    String timeAll = "";
    String atTime = "ก่อนอาหารทันที";

    String data = "ทุกๆ 1 ชั่วโมง";
    String menu = null;
    String sing = "ไม่มีเสียง";

    ArrayList<PendingIntent>intentarray = new ArrayList<PendingIntent>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        txt = (TextView) findViewById(R.id.txtData);

        String name = getIntent().getStringExtra("name");
        String type = getIntent().getStringExtra("type");
        String item = getIntent().getStringExtra("item");
        String all = getIntent().getStringExtra("all");

        txt.setText("ชื่อ : " + name + "  ประเภท : " + type + "  ชนิด : " + item +"  "+all);
        timeEdit1 = (TextView) findViewById(R.id.timeEdit1);
        timeEdit2 = (TextView) findViewById(R.id.timeEdit2);
        timeEdit3 = (TextView) findViewById(R.id.timeEdit3);
        timeEdit4 = (TextView) findViewById(R.id.timeEdit4);

        if (SettingSystemActivity.TIME_1 == null ){
            timeEdit1.setText("08.30");
            pHour1 = 8;
            pMinute1 =30;


        }else {
            timeEdit1.setText(SettingSystemActivity.TIME_1);
            pHour1 = SettingSystemActivity.TIME_11;
            pMinute1 = SettingSystemActivity.TIME_12;


        }
        if (SettingSystemActivity.TIME_2 == null ){
            timeEdit2.setText("13.30");
            pHour2 = 13;
            pMinute2 =30;

        }else {
            timeEdit2.setText(SettingSystemActivity.TIME_2);
            pHour2 = SettingSystemActivity.TIME_21;
            pMinute2 = SettingSystemActivity.TIME_22;

        }
        if (SettingSystemActivity.TIME_3 == null ){
            timeEdit3.setText("18.30");
            pHour3 = 13;
            pMinute3 =30;
        }else {
            timeEdit3.setText(SettingSystemActivity.TIME_3);
            pHour3 = SettingSystemActivity.TIME_31;
            pMinute3 = SettingSystemActivity.TIME_32;

        }
        if (SettingSystemActivity.TIME_4 == null ){
            timeEdit4.setText("22.30");
            pHour4 = 22;
            pMinute4 =30;
        }else {
            timeEdit4.setText(SettingSystemActivity.TIME_4);
            pHour4 = SettingSystemActivity.TIME_41;
            pMinute4 = SettingSystemActivity.TIME_42;

        }
    }
    //--------------------------------------------------------------------------------------------------------------------------------
    public void ClickItem(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.type1:
                atTime = "ก่อนอาหารทันที";
                if (checked)

                    break;
            case R.id.type2:
                atTime = "หลังอาหารทันที";
                if (checked)
                    break;
            case R.id.type33:
                atTime = "ก่อนอาหาร 30นาที";
                if (checked)
                    break;
            case R.id.type44:
                atTime = "หลังอาหาร 30นาที";
                if (checked)
                    break;
        }
    }

    public void ClickItem1(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.type5:
                if (checked)

                    break;
            case R.id.type6:
                if (checked)

                    break;

        }
    }

    //-------------------------------------------------------------------------------------------------------------------
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour1 = hourOfDay;
                    pMinute1 = minute;


                    updateDisplay();
                    displayToast();
                }
            };
    private void updateDisplay() {
        timeEdit1.setText(
                new StringBuilder()
                        .append(pad(pHour1)).append(":")
                        .append(pad(pMinute1)));

    }
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this,
                        mTimeSetListener, pHour1, pMinute1, false);
            case TIME_DIALOG_ID1:
                return new TimePickerDialog(this,
                        mTimeSetListener1, pHour2, pMinute2, false);
            case TIME_DIALOG_ID2:
                return new TimePickerDialog(this,
                        mTimeSetListener2, pHour3, pMinute3, false);
            case TIME_DIALOG_ID3:
                return new TimePickerDialog(this,
                        mTimeSetListener3, pHour4, pMinute4, false);


        }
        return null;
    }
    private void displayToast() {
        Toast.makeText(this, new StringBuilder().append("Update Time ").append(timeEdit1.getText()), Toast.LENGTH_SHORT).show();

    }
    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    public void time1(View view) {
        timeEdit1 = (TextView) findViewById(R.id.timeEdit1);
        showDialog(TIME_DIALOG_ID);

    }
    //---------------------------------------------------------------------------------------------------
    private TimePickerDialog.OnTimeSetListener mTimeSetListener1 =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour2 = hourOfDay;
                    pMinute2 = minute;

                    updateDisplay1();
                    displayToast1();
                }
            };
    private void updateDisplay1() {
        timeEdit2.setText(
                new StringBuilder()
                        .append(pad1(pHour2)).append(":")
                        .append(pad1(pMinute2)));
    }
    private void displayToast1() {
        Toast.makeText(this, new StringBuilder().append("Update Time ").append(timeEdit2.getText()), Toast.LENGTH_SHORT).show();

    }
    private static String pad1(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    public void time2(View view) {
        timeEdit2 = (TextView) findViewById(R.id.timeEdit2);
        showDialog(TIME_DIALOG_ID1);

    }
    //-------------------------------------------------------------------------------------------------------------------------------

    private TimePickerDialog.OnTimeSetListener mTimeSetListener2 =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour3 = hourOfDay;
                    pMinute3 = minute;

                    updateDisplay2();
                    displayToast2();
                }
            };
    private void updateDisplay2() {
        timeEdit3.setText(
                new StringBuilder()
                        .append(pad2(pHour3)).append(":")
                        .append(pad2(pMinute3)));
    }
    private void displayToast2() {
        Toast.makeText(this, new StringBuilder().append("Update Time ").append(timeEdit3.getText()), Toast.LENGTH_SHORT).show();

    }
    private static String pad2(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
    public void time3(View view) {
        timeEdit3 = (TextView) findViewById(R.id.timeEdit3);
        showDialog(TIME_DIALOG_ID2);

    }
    //------------------------------------------------------------------------------------------------------------------------------------
    private TimePickerDialog.OnTimeSetListener mTimeSetListener3 =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour4 = hourOfDay;
                    pMinute4 = minute;

                    updateDisplay3();
                    displayToast3();
                }
            };
    private void updateDisplay3() {
        timeEdit4.setText(
                new StringBuilder()
                        .append(pad3(pHour4)).append(":")
                        .append(pad3(pMinute4)));
    }
    private void displayToast3() {
        Toast.makeText(this, new StringBuilder().append("Update Time ").append(timeEdit4.getText()), Toast.LENGTH_SHORT).show();

    }
    private static String pad3(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    public void time4(View view) {
        timeEdit4 = (TextView) findViewById(R.id.timeEdit4);
        showDialog(TIME_DIALOG_ID3);
    }
    //----------------------------------------------------------------------------------------------------------------------------


    //-------------------------------------------------------------------------------------------------------------------------
    public void time99(View view) {
        final CharSequence[] items = {"ทุกๆ 1 ชั่วโมง","ทุกๆ 2 ชั่วโมง", "ทุกๆ 3 ชั่วโมง", "ทุกๆ 4 ชั่วโมง", "ทุกๆ 5 ชั่วโมง","ทุกๆ 6 ชั่วโมง",
                "ทุกๆ 7 ชั่วโมง","ทุกๆ 8 ชั่วโมง","ทุกๆ 9 ชั่วโมง","ทุกๆ 10 ชั่วโมง","ทุกๆ 11 ชั่วโมง","ทุกๆ 12 ชั่วโมง"};
        final TextView txt = (TextView) findViewById(R.id.timeEditTime);

        AlertDialog.Builder builder = new AlertDialog.Builder(TimeActivity.this);
        builder.setTitle("เลือกเวลา");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
                txt.setText(items[item]);
                data = (String) items[item];
            }
        });
        AlertDialog alert = builder.create();

        alert.show();
    }
    //--------------------------------------------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------------------------------------
    public void save(View view){
        RadioButton type5 = (RadioButton) findViewById(R.id.type5);
        RadioButton type6 = (RadioButton) findViewById(R.id.type6);

        CheckBox time1 = (CheckBox) findViewById(R.id.time1);
        CheckBox time2 = (CheckBox) findViewById(R.id.time2);
        CheckBox time3 = (CheckBox) findViewById(R.id.time3);
        CheckBox time4 = (CheckBox) findViewById(R.id.time4);

        TextView timeEdit1 = (TextView) findViewById(R.id.timeEdit1);
        TextView timeEdit2 = (TextView) findViewById(R.id.timeEdit2);
        TextView timeEdit3 = (TextView) findViewById(R.id.timeEdit3);
        TextView timeEdit4 = (TextView) findViewById(R.id.timeEdit4);
        TextView timeEditTime = (TextView) findViewById(R.id.timeEditTime);

        String name = getIntent().getStringExtra("name");
        String type = getIntent().getStringExtra("type");
        String item = getIntent().getStringExtra("item");
        String all = getIntent().getStringExtra("all");
        String menuItem = "ชื่อ :" + name + " " + type + "  " + item + " "+all;


        if (type5.isChecked()){
            if(time1.isChecked()){
                timeAll = timeAll+"  "+timeEdit1.getText();
                setAlarm1(pHour1,pMinute1);
            }
            if(time2.isChecked()){
                timeAll = timeAll+"  "+timeEdit2.getText();
                setAlarm1(pHour2,pMinute2);
            }
            if(time3.isChecked()){
                timeAll = timeAll+"  "+timeEdit3.getText();
                setAlarm1(pHour3,pMinute3);

            }
            if(time4.isChecked()){
                timeAll = timeAll+"  "+timeEdit4.getText();
                setAlarm1(pHour4,pMinute4);
            }
            int icon = getIntent().getIntExtra("icon", 0);
            String allTime = " รับประทาน : "+atTime +"  "+timeAll.toString();
            Uri u =Uri.parse("content://productDB");
            ContentValues cv = new ContentValues();
            cv.put("icon",icon);
            cv.put("productname", menuItem.toString());
            cv.put("timeDate", allTime);
            Uri nari = getContentResolver().insert(u, cv);

            Intent intent = new Intent(getApplicationContext(),AddDataMenuActivity.class);
            startActivity(intent);
            finish();
        }
        else if(type6.isChecked()){
            int icon = getIntent().getIntExtra("icon", 0);
            timeAll = timeAll+"  "+timeEditTime.getText();
            String allTime = " รับประทาน : "+atTime +"  "+timeAll.toString();
            Uri u =Uri.parse("content://hour");
            ContentValues cv = new ContentValues();
            cv.put("icon",icon);
            cv.put("productname", menuItem.toString());
            cv.put("timeDate", allTime);
            Uri nari = getContentResolver().insert(u, cv);

            setAlarm(data);

            Intent intent = new Intent(getApplicationContext(),AddDataMenuHourActivity.class);
            startActivity(intent);
            finish();
        }else {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("กรุณาตรวจสอบใหม่อีกครั้ง");
            dlgAlert.setTitle("ข้อมูลไม่ถูกต้อง");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }
    }

    public void setAlarm1(int hour,int min){
        Calendar cal = Calendar.getInstance();
        Calendar cal_now = Calendar.getInstance();

        cal.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE,min);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 00);
        if(cal.before(cal_now)){//if its in the past increment
            cal.add(Calendar.DATE,1);
        }

        MainActivity.calTimes.add(cal);

        alarm();
    }
    public void alarm(){
        AlarmManager[] alarmManager=new AlarmManager[MainActivity.calTimes.size()];
        for (int i = 0; i < MainActivity.calTimes.size();i++) {

            Intent intent = new Intent(TimeActivity.this,
                    AlarmReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    TimeActivity.this, i, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager[i] = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            alarmManager[i].set(AlarmManager.RTC_WAKEUP,MainActivity.calTimes.get(i).getTimeInMillis()
                    ,pi);

            MainActivity.intentarray.add(pi);
        }
    }

    public void setAlarm(String x){

        AlarmManager alarmManager;
            if(x =="ทุกๆ 1 ชั่วโมง") {
                Intent intent = new Intent(TimeActivity.this,
                        AlarmReceiver1.class);
                PendingIntent pi = PendingIntent.getBroadcast(
                        TimeActivity.this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60 , 1000*60*60
                        , pi);

                intentarray.add(pi);
                MainActivity.io++;
            }else if(x =="ทุกๆ 2 ชั่วโมง") {
                Intent intent = new Intent(TimeActivity.this,
                        AlarmReceiver1.class);
                PendingIntent pi = PendingIntent.getBroadcast(
                        TimeActivity.this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*2 , 1000*60*60*2
                        , pi);

                intentarray.add(pi);
                MainActivity.io++;
            }else if(x =="ทุกๆ 3 ชั่วโมง") {
                Intent intent = new Intent(TimeActivity.this,
                        AlarmReceiver1.class);
                PendingIntent pi = PendingIntent.getBroadcast(
                        TimeActivity.this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*3 , 1000*60*60*3
                        , pi);

                intentarray.add(pi);
                MainActivity.io++;
            }else if(x =="ทุกๆ 4 ชั่วโมง") {
                Intent intent = new Intent(TimeActivity.this,
                        AlarmReceiver1.class);
                PendingIntent pi = PendingIntent.getBroadcast(
                        TimeActivity.this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*4 , 1000*60*60*4
                        , pi);

                intentarray.add(pi);
                MainActivity.io++;
            }else if(x =="ทุกๆ 5 ชั่วโมง") {
                Intent intent = new Intent(TimeActivity.this,
                        AlarmReceiver1.class);
                PendingIntent pi = PendingIntent.getBroadcast(
                        TimeActivity.this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*5 , 1000*60*60*5
                        , pi);

                intentarray.add(pi);
                MainActivity.io++;
            }else if(x =="ทุกๆ 6 ชั่วโมง") {
                Intent intent = new Intent(TimeActivity.this,
                        AlarmReceiver1.class);
                PendingIntent pi = PendingIntent.getBroadcast(
                        TimeActivity.this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*6 , 1000*60*60*6
                        , pi);

                intentarray.add(pi);
                MainActivity.io++;
            }else if(x =="ทุกๆ 7 ชั่วโมง") {
                Intent intent = new Intent(TimeActivity.this,
                        AlarmReceiver1.class);
                PendingIntent pi = PendingIntent.getBroadcast(
                        TimeActivity.this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*7 , 1000*60*60*7
                        , pi);

                intentarray.add(pi);
                MainActivity.io++;
            }else if(x =="ทุกๆ 8 ชั่วโมง") {
                Intent intent = new Intent(TimeActivity.this,
                        AlarmReceiver1.class);
                PendingIntent pi = PendingIntent.getBroadcast(
                        TimeActivity.this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*8 , 1000*60*60*8
                        , pi);

                intentarray.add(pi);
                MainActivity.io++;
            }else if(x =="ทุกๆ 9 ชั่วโมง") {
                Intent intent = new Intent(TimeActivity.this,
                        AlarmReceiver1.class);
                PendingIntent pi = PendingIntent.getBroadcast(
                        TimeActivity.this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*9 , 1000*60*60*9
                        , pi);

                intentarray.add(pi);
                MainActivity.io++;
            }else if(x =="ทุกๆ 10 ชั่วโมง") {
                Intent intent = new Intent(TimeActivity.this,
                        AlarmReceiver1.class);
                PendingIntent pi = PendingIntent.getBroadcast(
                        TimeActivity.this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*10 , 1000*60*60*10
                        , pi);

                intentarray.add(pi);
                MainActivity.io++;
            }else if(x =="ทุกๆ 11 ชั่วโมง") {
                Intent intent = new Intent(TimeActivity.this,
                        AlarmReceiver1.class);
                PendingIntent pi = PendingIntent.getBroadcast(
                        TimeActivity.this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*11 , 1000*60*60*11
                        , pi);

                intentarray.add(pi);
                MainActivity.io++;
            }else if(x =="ทุกๆ 12 ชั่วโมง") {
                Intent intent = new Intent(TimeActivity.this,
                        AlarmReceiver1.class);
                PendingIntent pi = PendingIntent.getBroadcast(
                        TimeActivity.this, MainActivity.io, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*60*12 , 1000*60*60*12
                        , pi);

                intentarray.add(pi);
                MainActivity.io++;
            }

    }

    public void btnBack(View v){
        Intent intent = new Intent(getApplicationContext(),AddActivity.class);
        startActivity(intent);
        finish();

    }


}
