package com.example.user.pharmacistqrcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by User on 18/4/2559.
 */
public class AlarmReceiver1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        intent = new Intent(context, ShowEvent.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }



}
