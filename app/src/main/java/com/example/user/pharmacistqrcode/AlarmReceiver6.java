package com.example.user.pharmacistqrcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by User on 9/5/2559.
 */
public class AlarmReceiver6 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        intent = new Intent(context, ShowEvent.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}