package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddDataMenuActivity extends Activity implements View.OnClickListener,AdapterView.OnItemClickListener{
    ArrayList<item> itemArrayLists = new ArrayList<>();
    ListView listView;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_menu);

        Uri u =Uri.parse("content://productDB");
        Cursor c =getContentResolver().query(u, null, null, null, null);
        while (c.moveToNext()){
            itemArrayLists.add(new item(c.getInt(1), c.getString(2), c.getString(3)));
        }

        adapter = new ItemAdapter(this, itemArrayLists);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        String b = "";
        TextView a = (TextView) findViewById(R.id.android1);



    }


    @Override
    public void onClick(View v) {

    }
    public void btnBack(View v) {
        adapter.clear();
        Intent intent = new Intent(getApplicationContext(),HistoryActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder adb=new AlertDialog.Builder(AddDataMenuActivity.this);
        adb.setTitle("Select");
        final CharSequence[] items = { "Delete"};
        final int positionToRemove = position;
        adb.setItems(items, new AlertDialog.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                itemArrayLists.remove(positionToRemove);
                Uri u = Uri.parse("content://productDB");
                Cursor c = getContentResolver().query(u, null, null, null, null);
                String ex = "_id =?";
                c.moveToPosition(position);
                String name = c.getString(c.getColumnIndex(ProductDB.COL_ID));
                String[] e = new String[]{String.valueOf(name)};
                int row = getContentResolver().delete(u, ex, e);
                ShowMS("Delete");
                listView.setAdapter(adapter);
            }
        });
        adb.show();
    }
    public void ran1 (View view){

    }
    public void ran2 (View view){
        adapter.clear();
        Intent intent = new Intent(getApplicationContext(),AddDataMenuHourActivity.class);
        startActivity(intent);
        finish();
    }




    public void ShowMS (String ms){
        Toast.makeText(this, ms, Toast.LENGTH_SHORT).show();
    }


}
