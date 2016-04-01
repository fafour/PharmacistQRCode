package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScanQRCodeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qrcode);

        int REQUEST_CAMERA = 0;
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "IMG_" + timeStamp + ".jpg";
        File f = new File(Environment.getExternalStorageDirectory()
                , "DCIM/Camera/" + imageFileName);
        Uri uri = Uri.fromFile(f);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(Intent.createChooser(intent
                , "Take a picture with"), REQUEST_CAMERA);


    }

}
