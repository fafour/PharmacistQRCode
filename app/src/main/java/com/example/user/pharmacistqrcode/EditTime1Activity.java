package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class EditTime1Activity extends Activity  {
    private int pHour1;
    private int pMinute1;
    static final int TIME_DIALOG_ID = 0;
    TextView timeEditQRcode1;
    ArrayList<PendingIntent> intentarray = new ArrayList<PendingIntent>();
    ArrayList<Calendar>calTimes = new ArrayList<Calendar>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_time1);
        String txt = getIntent().getStringExtra("txt");
        TextView txt0 = (TextView) findViewById(R.id.txtData1);
        TextView txt1 = (TextView) findViewById(R.id.txtData2);
        String a []= txt.split(";");



        TextView atTime = (TextView) findViewById(R.id.atTime);
        timeEditQRcode1 = (TextView) findViewById(R.id.timeEditQRcode1);


        if (SettingSystemActivity.TIME_1 == null && a[1].equals("Morning   ") ) {
            timeEditQRcode1.setText("08.30");
            pHour1 = 8;
            pMinute1 =30;
        }else if (SettingSystemActivity.TIME_1 != null && a[1].equals("Morning   ")  ) {
            timeEditQRcode1.setText(SettingSystemActivity.TIME_1);
            pHour1 = SettingSystemActivity.TIME_11;
            pMinute1 = SettingSystemActivity.TIME_12;
        }else if (SettingSystemActivity.TIME_2 == null && a[1].equals(" Lunch  ")  ) {
            timeEditQRcode1.setText("13.30");
            pHour1 = 13;
            pMinute1 =30;
        }else if (SettingSystemActivity.TIME_2 != null && a[1].equals(" Lunch  ")  ) {
            timeEditQRcode1.setText(SettingSystemActivity.TIME_2);
            pHour1 = SettingSystemActivity.TIME_21;
            pMinute1 = SettingSystemActivity.TIME_22;
        }else if (SettingSystemActivity.TIME_3 == null &&  a[1].equals("  Dinner ")  ) {
            timeEditQRcode1.setText("18.30");
            pHour1 = 18;
            pMinute1 =30;
        }else if (SettingSystemActivity.TIME_3 != null &&  a[1].equals("  Dinner ")  ) {
            timeEditQRcode1.setText(SettingSystemActivity.TIME_3);
            pHour1 = SettingSystemActivity.TIME_31;
            pMinute1 = SettingSystemActivity.TIME_32;
        }else if (SettingSystemActivity.TIME_4 == null && a[1].equals("   Bed")  ) {
            timeEditQRcode1.setText("22.30");
            pHour1 = 22;
            pMinute1 =30;
        }else if (SettingSystemActivity.TIME_4 != null && a[1].equals("   Bed")  ) {
            timeEditQRcode1.setText(SettingSystemActivity.TIME_4);
            pHour1 = SettingSystemActivity.TIME_41;
            pMinute1 = SettingSystemActivity.TIME_42;
        }

        if (a[1].equals("Morning   ") ){
            txt0.setText("    ชื่อยา: "+ a[0]+"  ช่วงเวลา :เช้า ");
            txt1.setText("    รับประทาน : "+ a[2]+"  จำนวน : "+ a[3]);
            atTime.setText("ตอนเช้า");
        }else if (a[1].equals(" Lunch  ")){
            txt0.setText("    ชื่อยา: "+ a[0]+"  ช่วงเวลา :เที่ยง ");
            txt1.setText("    รับประทาน : "+ a[2]+"  จำนวน : "+ a[3]);
            atTime.setText("ตอนเที่ยง");
        }else if ( a[1].equals("   Bed")){
            txt0.setText("    ชื่อยา: "+ a[0]+"  ช่วงเวลา :ก่อนนอน ");
            txt1.setText("    รับประทาน : "+ a[2]+"  จำนวน : "+ a[3]);
            atTime.setText("ก่อนนอน");
        }else if (a[1].equals("  Dinner ")){
            txt0.setText("    ชื่อยา: "+ a[0]+"  ช่วงเวลา :Dinner ");
            txt1.setText("    รับประทาน : "+ a[2]+"  จำนวน : "+ a[3]);
            atTime.setText("ตอนเย็น");
        }


    }
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
        timeEditQRcode1.setText(
                new StringBuilder()
                        .append(pad(pHour1)).append(":")
                        .append(pad(pMinute1)));

    }
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this,
                        mTimeSetListener, pHour1, pMinute1, false);

        }
        return null;
    }
    private void displayToast() {
        Toast.makeText(this, new StringBuilder().append("Update Time ").append(timeEditQRcode1.getText()), Toast.LENGTH_SHORT).show();

    }
    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    public void time1(View view) {
        timeEditQRcode1 = (TextView) findViewById(R.id.timeEditQRcode1);
        showDialog(TIME_DIALOG_ID);

    }
    public void saves(View view){
        String txt = getIntent().getStringExtra("txt");
        String a []= txt.split(";");
        int icon = R.drawable.images;
        String menuItem = "  ชื่อยา: "+ a[0]+" ช่วงเวลา : "+ a[1]+" "+ a[3];
        String allTime = "  รับประทาน : "+ a[2]+"  เวลา : "+timeEditQRcode1.getText().toString();

        Uri u =Uri.parse("content://qrcode");
        ContentValues cv = new ContentValues();
        cv.put("icon",icon);
        cv.put("productname", menuItem.toString());
        cv.put("timeDate", allTime);
        Uri nari = getContentResolver().insert(u, cv);

        setAlarm1(pHour1,pMinute1);

        Intent intent = new Intent(getApplicationContext(),QRCodeMenuActivity.class);
        startActivity(intent);
        finish();

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

        MainActivity.calTimes1.add(cal);

        alarm();
    }
    public void alarm(){
        AlarmManager[] alarmManager=new AlarmManager[MainActivity.calTimes1.size()];
        for (int i = 0; i < MainActivity.calTimes1.size();i++) {

            Intent intent = new Intent(this,
                    AlarmReceiver2.class);
            PendingIntent pi = PendingIntent.getBroadcast(this, i, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager[i] = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            alarmManager[i].set(AlarmManager.RTC_WAKEUP,MainActivity.calTimes1.get(i).getTimeInMillis()
                    ,pi);

            MainActivity.intentarray1.add(pi);
        }
    }

}
