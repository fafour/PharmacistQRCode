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

import java.util.Calendar;

public class TimeActivity extends Activity {
    TextView txt,timeEdit1,timeEdit2,timeEdit3,timeEdit4,timeEdit5;
    private int pHour1;
    private int pMinute1;
    private int pHour2;
    private int pMinute2;
    private int pHour3;
    private int pMinute3;
    private int pHour4;
    private int pMinute4;
    private int pHour5;
    private int pMinute5;
    static final int TIME_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID1 = 1;
    static final int TIME_DIALOG_ID2 = 2;
    static final int TIME_DIALOG_ID3 = 3;
    static final int TIME_DIALOG_ID4 = 4;

    String timeAll = "";
    String atTime = null;
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    Calendar cal3 = Calendar.getInstance();
    Calendar cal4 = Calendar.getInstance();
    Calendar cal5 = Calendar.getInstance();


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
        timeEdit5 = (TextView) findViewById(R.id.timeEdit5);

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
        if (SettingSystemActivity.TIME_5 == null ){
            timeEdit5.setText("09.30");
            pHour5 = 9;
            pMinute5 =30;
        }else {
            timeEdit5.setText(SettingSystemActivity.TIME_5);
            pHour5 = SettingSystemActivity.TIME_51;
            pMinute5 = SettingSystemActivity.TIME_52;
        }

    }
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

                    cal1.set(Calendar.HOUR_OF_DAY, pHour1);
                    cal1.set(Calendar.MINUTE, pMinute1);

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
            case TIME_DIALOG_ID4:
                return new TimePickerDialog(this,
                        mTimeSetListener4, pHour5, pMinute5, false);

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

                    cal2.set(Calendar.HOUR_OF_DAY, pHour2);
                    cal2.set(Calendar.MINUTE, pHour2);

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

                    cal3.set(Calendar.HOUR_OF_DAY, pHour3);
                    cal3.set(Calendar.MINUTE, pMinute3);

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

                    cal4.set(Calendar.HOUR_OF_DAY, pHour4);
                    cal4.set(Calendar.MINUTE, pMinute4);

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

    private TimePickerDialog.OnTimeSetListener mTimeSetListener4 =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour5 = hourOfDay;
                    pMinute5 = minute;

                    cal5.set(Calendar.HOUR_OF_DAY, pHour5);
                    cal5.set(Calendar.MINUTE, pMinute5);

                    updateDisplay4();
                    displayToast4();
                }
            };

    private void updateDisplay4() {
        timeEdit5.setText(
                new StringBuilder()
                        .append(pad4(pHour5)).append(":")
                        .append(pad4(pMinute5)));
    }
    private void displayToast4() {
        Toast.makeText(this, new StringBuilder().append("Update Time ").append(timeEdit5.getText()), Toast.LENGTH_SHORT).show();


    }
    private static String pad4(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
    public void time5(View view) {
        timeEdit5 = (TextView) findViewById(R.id.timeEdit5);
        showDialog(TIME_DIALOG_ID4);
    }

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
            }
        });
        AlertDialog alert = builder.create();

        alert.show();
    }
    //--------------------------------------------------------------------------------------------------------------------------------
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
        TextView timeEdit5 = (TextView) findViewById(R.id.timeEdit5);


        if (type5.isChecked()){
            if(time1.isChecked()){
                timeAll = timeAll+"  "+timeEdit1.getText();
                setAlarm(cal1);
            }
            if(time2.isChecked()){
                timeAll = timeAll+"  "+timeEdit2.getText();
                setAlarm(cal2);
            }
            if(time3.isChecked()){
                timeAll = timeAll+"  "+timeEdit3.getText();
                setAlarm(cal3);
            }
            if(time4.isChecked()){
                timeAll = timeAll+"  "+timeEdit4.getText();
                setAlarm(cal4);
            }
        }
        else if(type6.isChecked()){
            timeAll = timeAll+"  "+timeEditTime.getText()+"  เริ่ม  "+timeEdit5.getText();
            setAlarm(cal5);
        }

        String name = getIntent().getStringExtra("name");
        String type = getIntent().getStringExtra("type");
        String item = getIntent().getStringExtra("item");
        String all = getIntent().getStringExtra("all");
        int icon = getIntent().getIntExtra("icon", 0);
        String menuItem = "ชื่อ :" + name + " ประเภท :" + type + " ชนิด : " + item + " "+all;
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
    public void btnBack(View v){
        Intent intent = new Intent(getApplicationContext(),AddActivity.class);;
        startActivity(intent);
        finish();

    }

    private void setAlarm(Calendar targetCal){

        final int _id = (int) System.currentTimeMillis();

        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), _id, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);

    }

}
