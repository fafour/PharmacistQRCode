package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends Activity implements AdapterView.OnItemSelectedListener {
    EditText name;
    EditText howmuch;
    String type = "ยา";
    String item = null;
    String total = null;
    int icon = R.drawable.pillicon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        List categories = new ArrayList();
        categories.add("เลือกประเภท");
        categories.add("ยาเม็ด");
        categories.add("ยาแคปซูล");
        categories.add("ยาอม");
        categories.add("ยาทาผิวหนัง");
        categories.add("ยาหยอดตา");
        categories.add("ยาล้างตา");
        categories.add("ยาป้ายตา");
        categories.add("ยาหยอดหู");
        categories.add("ยาหยอดจมูก");
        categories.add("ยาพ่นจมูก");
        categories.add("ยาสูดพ่นเข้าทางปาก");
        categories.add("ยาสอด / ส่วนทวารหนัก");
        categories.add("ยาสอดช่องคลอด");
        categories.add("ยาแผ่น");
        categories.add("ยาฉีด");
        categories.add("ยาผง");
        categories.add("ยาน้ำ");

        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                item = parentView.getItemAtPosition(position).toString();

                Toast.makeText(parentView.getContext(), "Select : " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });


        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(this);
        List data = new ArrayList();
        data.add("เลือกประเภท");
        data.add("กรัม");
        data.add("เม็ด");
        data.add("มิลลิลิตร");
        data.add("ช้อนโต้ะ");
        data.add("ช้อนชา");
        data.add("อื่นๆ");

        ArrayAdapter dataAdapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, data);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                total = parentView.getItemAtPosition(position).toString();

                Toast.makeText(parentView.getContext(), "Select : " + total, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

    }



    //------------------------------------------------------------------------------------------------------------------
    public void ClickItem(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.type1:
                type = "ยา";
                icon = R.drawable.pillicon;
                if (checked)

                    break;
            case R.id.type2:
                type = "อาหารเสริม";
                icon = R.drawable.tabletsicon;
                if (checked)

                    break;
        }
    }


    public void btnClicks(View v){
        name = (EditText) findViewById(R.id.name);
        howmuch = (EditText) findViewById(R.id.howmuch);
        String txt = name.getText().toString();

        if(type == null || txt.length()==0 ||item =="เลือกประเภท" || total == "เลือกประเภท" || howmuch.length()==0){
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("กรุณาตรวจสอบใหม่อีกครั้ง");
            dlgAlert.setTitle("ข้อมูลไม่ถูกต้อง");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

        }else {
            String all  = "จำนวน : " + howmuch.getText().toString() +" "+total;
            Intent intent = new Intent(getApplicationContext(),TimeActivity.class);
            intent.putExtra("name",name.getText().toString());
            intent.putExtra("type",type);
            intent.putExtra("item",item);
            intent.putExtra("icon",icon );
            intent.putExtra("all",all );
            startActivity(intent);
            finish();
        }

    }
    public void btnBack(View v){
        finish();

    }
    public void btnHelp(View v){
        Intent intent = new Intent(getApplicationContext(),DirectionActivity.class);;
        startActivity(intent);
        finish();

    }
    public void btnOnClick(View v){
        Intent intent = new Intent(getApplicationContext(),WarningActivity.class);;
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
