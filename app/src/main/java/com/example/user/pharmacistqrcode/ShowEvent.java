package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class ShowEvent extends Activity implements OnClickListener {

    PowerManager pm;
    WakeLock wl;
    KeyguardManager km;
    KeyguardLock kl;
    Ringtone r;
    MediaPlayer mediaPlayer;
    Vibrator v;

    String sings = "สั่น";

    Button btnStop;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.i("ShowEvent", "onCreate() in DismissLock");
        pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        km=(KeyguardManager)getSystemService(Context.KEYGUARD_SERVICE);
        kl=km.newKeyguardLock("ShowEvent");
        wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.ON_AFTER_RELEASE, "ShowEvent");
        wl.acquire(); //wake up the screen
        kl.disableKeyguard();

        setContentView(R.layout.sec);
        TextView as = (TextView) findViewById(R.id.as);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        String currentDate = df.format(c.getTime());
        as.setText(currentDate);

        if (SettingSystemActivity.SING == null ){
            sings = "สั่น";
        }else {
            sings = SettingSystemActivity.SING;
        }


        btnStop = (Button)findViewById(R.id.btnStop);
        btnStop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnStop){
            this.finish();
        }
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.cancel();
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 00);

        if(MainActivity.calTimes.size() != 0){
            MainActivity.calTimes.remove(cal);
        }
        if(MainActivity.calTimes1.size() != 0){
            MainActivity.calTimes1.remove(cal);
        }
        if(MainActivity.calTimes2.size() != 0){
            MainActivity.calTimes2.remove(cal);
        }
        if(MainActivity.calTimes3.size() != 0){
            MainActivity.calTimes3.remove(cal);
        }
        if(MainActivity.calTimes4.size() != 0){
            MainActivity.calTimes4.remove(cal);
        }



    }

    @Override
    protected void onResume() {
        if (sings=="ไม่มีเสียง"){
            super.onResume();
            wl.acquire();//must call this!
            if(mediaPlayer!=null) {
                mediaPlayer.stop();
            }
            mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.aaa);
            mediaPlayer.pause();

        }

        else if (sings=="สั่น"){
            super.onResume();
            wl.acquire();//must call this!
            if(mediaPlayer!=null) {
                mediaPlayer.stop();
            }
            long[] pattern = {0, 1000, 500, 1000, 500, 1000, 2000};
            v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(pattern, 0);
            mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.aaa);
            mediaPlayer.pause();

        }
        else if (sings=="เสียง1"){
            super.onResume();
            wl.acquire();//must call this!
            if(mediaPlayer!=null) {
                mediaPlayer.stop();
            }

            mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.aaa);
            mediaPlayer.start();
        }
        else if (sings=="เสียง2"){
            super.onResume();
            wl.acquire();//must call this!
            if(mediaPlayer!=null) {
                mediaPlayer.stop();
            }
            mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.ddd);
            mediaPlayer.start();
        }
        else if (sings=="เสียง3"){
            super.onResume();
            wl.acquire();//must call this!
            if(mediaPlayer!=null) {
                mediaPlayer.stop();
            }
            mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.fff);
            mediaPlayer.start();
        }
        else if (sings=="เสียง4"){
            super.onResume();
            wl.acquire();//must call this!
            if(mediaPlayer!=null) {
                mediaPlayer.stop();
            }
            mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.ggg);
            mediaPlayer.start();
        }
        else if (sings=="เสียง5"){
            super.onResume();
            wl.acquire();//must call this!
            if(mediaPlayer!=null) {
                mediaPlayer.stop();
            }
            mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.sss);
            mediaPlayer.start();
        }
        else if (sings=="เสียง6"){
            super.onResume();
            wl.acquire();//must call this!
            if(mediaPlayer!=null) {
                mediaPlayer.stop();
            }
            mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.vvv);
            mediaPlayer.start();
        }
        else if (sings=="เสียง7"){
            super.onResume();
            wl.acquire();//must call this!
            if(mediaPlayer!=null) {
                mediaPlayer.stop();
            }
            mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.xxx);
            mediaPlayer.start();
        }

    }

    @Override
    public void onPause(){
        super.onPause();
        wl.release();
        if(mediaPlayer.isPlaying()){
            if(mediaPlayer!=null) {
                mediaPlayer.stop();
            }
        }

    }

}
