package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EditTime4Activity extends Activity implements AdapterView.OnItemSelectedListener{
    TextView atTime1,atTime2,atTime3,atTime4;
    private int pHour1;
    private int pMinute1;
    private int pHour2;
    private int pMinute2;
    private int pHour3;
    private int pMinute3;
    private int pHour4;
    private int pMinute4;
    MediaPlayer mediaPlayer;

    TextView timeEditQRcode1,timeEditQRcode2,timeEditQRcode3,timeEditQRcode4;

    static final int TIME_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID1 = 1;
    static final int TIME_DIALOG_ID2 = 2;
    static final int TIME_DIALOG_ID3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_time4);
        String txt = getIntent().getStringExtra("txt");
        TextView txt0 = (TextView) findViewById(R.id.txtData1);
        TextView txt1 = (TextView) findViewById(R.id.txtData2);
        String a []= txt.split(";");
        txt0.setText("    ชื่อยา: " + a[0] + " เวลารับประทาน : " + a[1]);
        txt1.setText("    รับประทาน : " + a[2] + "  จำนวน : " + a[3]);

        atTime1 = (TextView) findViewById(R.id.atTime1);
        atTime2 = (TextView) findViewById(R.id.atTime2);
        atTime3 = (TextView) findViewById(R.id.atTime3);
        atTime4 = (TextView) findViewById(R.id.atTime4);

        atTime1.setText("ตอนเช้า");
        atTime1.setText("ตอนเที่ยง");
        atTime1.setText("ตอนเย็น");
        atTime1.setText("ก่อนนอน");

        timeEditQRcode1 = (TextView) findViewById(R.id.timeEditQRcode1);
        timeEditQRcode2 = (TextView) findViewById(R.id.timeEditQRcode2);
        timeEditQRcode3 = (TextView) findViewById(R.id.timeEditQRcode3);
        timeEditQRcode4 = (TextView) findViewById(R.id.timeEditQRcode4);

        if (SettingSystemActivity.TIME_1 == null ){
            timeEditQRcode1.setText("08.30");

        }else {
            timeEditQRcode1.setText(SettingSystemActivity.TIME_1);

        }
        if (SettingSystemActivity.TIME_2 == null ){
            timeEditQRcode2.setText("13.30");

        }else {
            timeEditQRcode2.setText(SettingSystemActivity.TIME_2);

        }
        if (SettingSystemActivity.TIME_3 == null ){
            timeEditQRcode3.setText("18.30");
        }else {
            timeEditQRcode3.setText(SettingSystemActivity.TIME_3);

        }
        if (SettingSystemActivity.TIME_4 == null ){
            timeEditQRcode3.setText("22.30");
        }else {
            timeEditQRcode3.setText(SettingSystemActivity.TIME_4);

        }
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        List categories = new ArrayList();
        categories.add("ไม่มีเสียง");
        categories.add("เสียง1");
        categories.add("เสียง2");
        categories.add("เสียง3");
        categories.add("เสียง4");
        categories.add("เสียง5");
        categories.add("เสียง6");
        categories.add("เสียง7");

        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                if (position==0){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }

                }
                else if (position==1){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.aaa);
                    mediaPlayer.start();

                }
                else if (position==2){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.ddd);
                    mediaPlayer.start();

                }
                else if (position==3){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.fff);
                    mediaPlayer.start();

                }
                else if (position==4){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.ggg);
                    mediaPlayer.start();

                }
                else if (position==5){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.sss);
                    mediaPlayer.start();

                }
                else if (position==6){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.vvv);
                    mediaPlayer.start();

                }
                else if (position==7){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.xxx);
                    mediaPlayer.start();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });



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
            case TIME_DIALOG_ID1:
                return new TimePickerDialog(this,
                        mTimeSetListener1, pHour2, pMinute2, false);
            case TIME_DIALOG_ID2:
                return new TimePickerDialog(this,
                        mTimeSetListener2, pHour3, pMinute3, false);
            case TIME_DIALOG_ID3:
                return new TimePickerDialog(this,
                        mTimeSetListener2, pHour4, pMinute4, false);

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
        timeEditQRcode2.setText(
                new StringBuilder()
                        .append(pad1(pHour2)).append(":")
                        .append(pad1(pMinute2)));
    }
    private void displayToast1() {
        Toast.makeText(this, new StringBuilder().append("Update Time ").append(timeEditQRcode2.getText()), Toast.LENGTH_SHORT).show();

    }
    private static String pad1(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    public void time2(View view) {
        timeEditQRcode2 = (TextView) findViewById(R.id.timeEditQRcode2);
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
        timeEditQRcode3.setText(
                new StringBuilder()
                        .append(pad2(pHour3)).append(":")
                        .append(pad2(pMinute3)));
    }
    private void displayToast2() {
        Toast.makeText(this, new StringBuilder().append("Update Time ").append(timeEditQRcode3.getText()), Toast.LENGTH_SHORT).show();

    }
    private static String pad2(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
    public void time3(View view) {
        timeEditQRcode3 = (TextView) findViewById(R.id.timeEditQRcode3);
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
        timeEditQRcode3.setText(
                new StringBuilder()
                        .append(pad2(pHour4)).append(":")
                        .append(pad2(pMinute4)));
    }
    private void displayToast3() {
        Toast.makeText(this, new StringBuilder().append("Update Time ").append(timeEditQRcode4.getText()), Toast.LENGTH_SHORT).show();

    }
    private static String pad3(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
    public void time4(View view) {
        timeEditQRcode3 = (TextView) findViewById(R.id.timeEditQRcode4);
        showDialog(TIME_DIALOG_ID3);

    }
    //------------------------------------------------------------------------------------------------------------------------------------



    public void saves(View view){
        String txt = getIntent().getStringExtra("txt");
        String a []= txt.split(";");
        int icon = R.drawable.ddf;
        String menuItem = "  ชื่อยา: "+ a[0]+" เวลา : "+ a[1]+"   จำนวน : "+ a[3];
        String allTime = "    รับประทาน : "+ a[2]+"  เวลา : "+timeEditQRcode1.getText().toString()+"  "+timeEditQRcode2.getText().toString()+"  "+timeEditQRcode3.getText().toString()+"  "+timeEditQRcode3.getText().toString();

        Uri u =Uri.parse("content://qrcode");
        ContentValues cv = new ContentValues();
        cv.put("icon",icon);
        cv.put("productname", menuItem.toString());
        cv.put("timeDate", allTime);
        Uri nari = getContentResolver().insert(u, cv);

        Intent intent = new Intent(getApplicationContext(),QRCodeMenuActivity.class);
        startActivity(intent);
        finish();

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
