package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SettingSystemActivity extends Activity implements AdapterView.OnItemSelectedListener{
    TextView timeEdit1,timeEdit2,timeEdit3,timeEdit4;
    MediaPlayer mediaPlayer;
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


    static String TIME_1 = null;
    static String TIME_2 = null;
    static String TIME_3 = null;
    static String TIME_4 = null;

    static int TIME_11 = 0;
    static int TIME_21 = 0;
    static int TIME_31 = 0;
    static int TIME_41 = 0;

    static int TIME_12 = 0;
    static int TIME_22 = 0;
    static int TIME_32 = 0;
    static int TIME_42 = 0;

    static String SING= null;
    String song = "สั่น";
    Vibrator mVibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_system);
        timeEdit1 = (TextView) findViewById(R.id.timeEdit1);
        timeEdit2 = (TextView) findViewById(R.id.timeEdit2);
        timeEdit3 = (TextView) findViewById(R.id.timeEdit3);
        timeEdit4 = (TextView) findViewById(R.id.timeEdit4);


        if (TIME_1 == null ){
            timeEdit1.setText("08.30");
            TIME_1 = (String) timeEdit1.getText();
        }else {
            timeEdit1.setText(SettingSystemActivity.TIME_1);

        }
        if (TIME_2 == null ){
            timeEdit2.setText("13.30");
            TIME_2 = (String) timeEdit2.getText();
        }else {
            timeEdit2.setText(SettingSystemActivity.TIME_2);

        }
        if (TIME_3 == null ){
            timeEdit3.setText("18.30");
            TIME_3 = (String) timeEdit3.getText();
        }else {
            timeEdit3.setText(SettingSystemActivity.TIME_3);

        }
        if (TIME_4 == null ){
            timeEdit4.setText("22.30");
            TIME_4 = (String) timeEdit4.getText();
        }else {
            timeEdit4.setText(SettingSystemActivity.TIME_4);

        }
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        List categories = new ArrayList();
        categories.add("สั่น");
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
                    long[] pattern = {0, 100, 1000, 300, 200, 100, 500, 200, 100};
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(pattern, -1);
                    song = "สั่น";

                }
                else if (position==1){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    song = "เสียง1";
                    mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.aaa);
                    mediaPlayer.start();

                }
                else if (position==2){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    song = "เสียง2";
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.ddd);
                    mediaPlayer.start();

                }
                else if (position==3){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    song = "เสียง3";
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.fff);
                    mediaPlayer.start();

                }
                else if (position==4){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    song = "เสียง4";
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.ggg);
                    mediaPlayer.start();

                }
                else if (position==5){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    song = "เสียง5";
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.sss);
                    mediaPlayer.start();

                }
                else if (position==6){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    song = "เสียง6";
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.vvv);
                    mediaPlayer.start();

                }
                else if (position==7){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    song = "เสียง7";
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.xxx);
                    mediaPlayer.start();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });


    }
    public void btnBack(View v){
        if(mediaPlayer!=null) {
            mediaPlayer.stop();
        }
        finish();
    }
    //-------------------------------------------------------------------------------------------------------------------
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour1 = hourOfDay;
                    pMinute1 = minute;

                    TIME_11 = pHour1;
                    TIME_12 = pMinute1;


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
        TIME_1 = (String) timeEdit1.getText();

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

                    TIME_21 = pHour2;
                    TIME_22 = pMinute2;

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
        TIME_2 = (String) timeEdit2.getText();
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

                    TIME_31 = pHour3;
                    TIME_32 = pMinute3;

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
        TIME_3 = (String) timeEdit3.getText();
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

                    TIME_41 = pHour4;
                    TIME_42 = pMinute4;

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
        TIME_4 = (String) timeEdit4.getText();
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    //----------------------------------------------------------------------------------------------------------------------------
    public void save(View view) {
        if(mediaPlayer!=null) {
            mediaPlayer.stop();
        }
        SING = song;
        finish();

    }


}
