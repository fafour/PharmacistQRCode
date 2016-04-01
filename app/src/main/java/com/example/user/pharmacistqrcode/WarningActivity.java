package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WarningActivity extends Activity {
    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> laptopCollection;
    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning);

        createGroupList();

        createCollection();

        expListView = (ExpandableListView) findViewById(R.id.laptop_list);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, laptopCollection);
        expListView.setAdapter(expListAdapter);

        //setGroupIndicatorToRight();

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                final String selected = (String) expListAdapter.getChild(
                        groupPosition, childPosition);
                Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG)
                        .show();

                return true;
            }
        });


    }


    private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("ยานอนหลับ กับ ยาแก้แพ้");
        groupList.add("ยาละลายลิ่มเลือด กับ น้ำมันปลา");
        groupList.add("ยารักษาสิว กับ วิตามินเอ");
        groupList.add("ยาลดความดัน กับ ยาขยายหลอดลม");
        groupList.add("ยาขับปัสสาวะ กับ กาแฟ");
        groupList.add("ยาลดความอ้วน กับ ยาไทรอยด์ หรือ ยาขับปัสสาวะ");
        groupList.add("ยาปฏิชีวนะ กับ ส้มโอ");
        groupList.add("ยาพาราฯ กับ สมุนไพร");
        groupList.add("ยาบำรุงเลือด กับ ธาตุเหล็ก");
        groupList.add("วิตามินอี และ อีฟนิ่งพริมโรส");
        groupList.add("แคลเซียมเสริม กับ แคลเซียมสด");
        groupList.add("กาแฟ กับ แคลเซียม");
        groupList.add("ธาตุเหล็ก กับ เลือดจางธาลัสซีเมีย");
    }

    private void createCollection() {
        // preparing laptops collection(child)
        String[] data1 = { "มีฤทธิ์กล่อมให้ง่วงเหมือน ๆ กัน การกินควบกันไปจึงไม่ค่อยดีนัก ไม่เหมาะกับผู้ที่ต้องทำงานกับเครื่องจักร, ขับรถ, ขับเครื่องบินหรือต้องใช้สมองทั้งหลาย เพราะสติสัมปชัญญะจะเหลือเพียงแค่น้อยนิด ชีวิตอื่น ๆ ที่ฝากไว้ในมือก็จะพากันไปท่องปรโลกเสียหมด"};
        String[] data2 = { "ยาละลายลิ่มเลือดที่ว่านี้เช่น แอสไพริน, วาฟาริน, เฮปาริน และยาที่ทำให้เลือดไม่จับตัวกันแบบอื่น ๆ การกินร่วมกับน้ำมันปลาทำให้ยิ่งเพิ่มความเสี่ยงต่อภาวะเลือดไหลไม่หยุด ท่านที่จำเป็นต้องกินยาละลายลิ่มเลือดก็ขอให้ระวังเรื่องน้ำมันปลาและอาหารเสริมที่ช่วยให้เลือดใสไว้ให้ดี"};
        String[] data3 = { "ท่านที่รักษาผิวหน้ายิ่งชีพต้องระวังปรากฏการณ์ หน้าใสใกล้ตับวาย เพราะกินยารักษาสิวยอดนิยมมีกรดวิตามินเอ (Retinoic acid) เป็นส่วนประกอบมาก ทำให้ตับทำงานหนักอยู่แล้ว ยิ่งถ้าได้วิตามินเอเสริมเข้าไปอีกอาจทำให้ตับทำงานหนักเกินตัวจนเกิดภาวะตับวายและดีซ่านตัวเหลืองได้"};
        String[] data4 = { "ยาลดความดันกลุ่มที่ไปฉุดหัวใจให้เต้นช้าไม่ควรใช้ในคนป่วยโรคหอบหืดหรือภูมิแพ้ ยิ่งถ้าใช้ร่วมกับยาขยายหลอดลมจะยิ่งพาให้หัวใจเต้นช้าจนผิดจังหวะเกิดอาการผิดปกติ เป็นอันตรายได้"};
        String[] data5 = { "ลำพังดื่มกาแฟก็ทำให้ปัสสาวะบ่อยอยู่แล้ว ยิ่งได้ยาขับน้ำเข้าไปอีกร่างกายจะยิ่งเสียน้ำเพิ่มขึ้นจนอาจถึงขั้นอ่อนเพลีย อีกทั้งเกลือแร่ที่เสียไปทางปัสสาวะก็ทำให้เกิดอาการหมดแรงจนถึงชักเกร็งได้"};
        String[] data6 = { "จะทำให้เกิดอาการ ช็อก ถึงขั้นหัวใจหยุดเต้นได้ ไม่ใช่เรื่องเล่น ๆ เลยเพราะเคยเกิดขึ้นมาแล้ว ด้วยยาลดความอ้วนส่วนใหญ่มีส่วนผสมของยาที่ช่วยเผาผลาญ, ยากดสมองและยาขับน้ำ ที่สำคัญคือมักไม่บอกชื่อแซ่ที่แท้จริงของยา แต่มักจัดมาเป็นชุด คนป่วยที่กินยาพวกไทรอยด์หรือยาขับปัสสาวะอยู่เป็นประจำต้องคอยสังเกตให้ดี"};
        String[] data7 = { "ดูไม่เกี่ยวอะไรกันกับยาเคมี ส้มโอพันธุ์ดีเนื้อหวานชื่นใจหรือจะทำอันตรายใคร ขออย่าเพิ่งนอนใจครับ เพราะ ยาฆ่าเชื้อหลายชนิดไม่ควรกินคู่กับน้ำผลไม้ ในฝอยยาว่าเป็นพวก \"เกรปฟรุท\" ซึ่งก็อยู่ในเครือญาติเดียวกับส้มโอ บ้านเราไม่มีเกรปฟรุทแต่มีญาติของมันเยอะเลย ส้มเช้ง, ส้มเขียวหวานและอีกหลาย ๆ ส้ม ถ้าไม่แน่ใจให้กินยากับน้ำเปล่าเป็นที่ดีสุด"};
        String[] data8 = { "หยิบพาราเซตามอลกินขำ ๆ แก้ปวดลดไข้ทีละ 2 เม็ด ถ้ากินร่วมกับสมุนไพรจะไม่ค่อยดีกับ ตับ นัก มีสิทธิ์ทำให้ตับพังและวายได้ ตัวอย่างที่พบบ่อยคือกินทั้งพาราเซตามอลและฟ้าทลายโจร อย่างนี้เหมือนโดน 2 เด้งที่เนื้อตับ"};
        String[] data9 = { "ในคนป่วยธาลัสซีเมีย (เลือดจางจากพันธุกรรม) ไม่ควรกินธาตุเหล็กมากเพราะจะไปสะสมทำอันตรายอวัยวะสำคัญอย่าง หัวใจ กับ ตับ ควรเว้นการกินอาหารที่มีธาตุเหล็กสูงอย่าง เลือดหมู, ลาบเลือด, หอยแครงลวก, ตับหวาน, ฟัวกราส์, ผัดตับ, ตับทอด"};
        String[] data10 = { "มีคนไข้ที่อยากผิวสวยมาหาพร้อมบอกว่ามีคนแนะให้กินวิตามินอี แต่บ้างก็ให้เลือกเป็นอีฟนิ่งพริมโรสแทนจะเลือกอย่างไรดี จึงได้บอกไปให้เลือกอย่างหนึ่งก็พอ เพราะล้วนแต่มีวิตามินอีทั้งนั้น ซึ่งถ้าได้มากไปอาจทำให้เกิดหัวใจวายแทน"};
        String[] data11 = { "ถ้า ท่านกินงาดำได้วันละ 4 ช้อนโต๊ะ หรือเต้าหู้ขาวแข็งวันละ 3 ขีดก็จะได้แคลเซียมราว 1,000 มิลลิกรัมอยู่แล้ว ซึ่งถ้าไปหาแคลเซียมเม็ดมากินเติมอีก จะทำให้แคลเซียมเกินและไปจับกับหลอดเลือดทำให้ตีบแข็งได้"};
        String[] data12 = { "ขอให้เลี่ยงกินแคลเซียมร่วมกับกาแฟ เพราะกาแฟจะไปยับยั้งการดูดซึมแคลเซียม นอกจากนั้นยังไปดึงแคลเซียมออกจากกระดูกอีกด้วย + นมสด (ไม่ใช่นมถั่วเหลือง) ก็ไม่ควรกินกับแคลเซียม จะให้ไม่ดูดซึมเช่นกัน กาแฟ"};
        String[] data13 = { "เป็นไม้เบื่อไม้เมากันทีเดียว ขอให้ลืมความเชื่อที่ว่าถ้าเลือดจางต้องกินธาตุเหล็ก ไม่เสมอไปครับ หากท่านเป็นเลือดจางชนิดธาลัสซีเมียแล้วไปกินธาตุเหล็กเสริม จะเท่ากับเติมยาพิษให้กับหัวใจและตับ"};


        laptopCollection = new LinkedHashMap<String, List<String>>();

        for (String laptop : groupList) {
            if (laptop.equals("ยานอนหลับ กับ ยาแก้แพ้")) {
                loadChild(data1);
            } else if (laptop.equals("ยาละลายลิ่มเลือด กับ น้ำมันปลา"))
                loadChild(data2);
            else if (laptop.equals("ยารักษาสิว กับ วิตามินเอ"))
                loadChild(data3);
            else if (laptop.equals("ยาลดความดัน กับ ยาขยายหลอดลม"))
                loadChild(data4);
            else if (laptop.equals("ยาขับปัสสาวะ กับ กาแฟ"))
                loadChild(data5);
            else if (laptop.equals("ยาลดความอ้วน กับ ยาไทรอยด์ หรือ ยาขับปัสสาวะ"))
                loadChild(data6);
            else if (laptop.equals("ยาปฏิชีวนะ กับ ส้มโอ"))
                loadChild(data7);
            else if (laptop.equals("ยาพาราฯ กับ สมุนไพร"))
                loadChild(data8);
            else if (laptop.equals("ยาบำรุงเลือด กับ ธาตุเหล็ก"))
                loadChild(data9);
            else if (laptop.equals("วิตามินอี และ อีฟนิ่งพริมโรส"))
                loadChild(data10);
            else if (laptop.equals("แคลเซียมเสริม กับ แคลเซียมสด"))
                loadChild(data11);
            else if (laptop.equals("กาแฟ กับ แคลเซียม"))
                loadChild(data12);
            else if (laptop.equals("ธาตุเหล็ก กับ เลือดจางธาลัสซีเมีย"))
                loadChild(data13);

            laptopCollection.put(laptop, childList);
        }
    }

    private void loadChild(String[] laptopModels) {
        childList = new ArrayList<String>();
        for (String model : laptopModels)
            childList.add(model);
    }

    private void setGroupIndicatorToRight() {
        /* Get the screen width */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;

        expListView.setIndicatorBounds(width - getDipsFromPixel(35), width
                - getDipsFromPixel(5));
    }

    // Convert pixel to dip
    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }




    public void btnBack(View v) {
        Intent intent = new Intent(getApplicationContext(),AddActivity.class);
        startActivity(intent);
        finish();
    }
}
