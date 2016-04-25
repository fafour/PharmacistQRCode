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

public class DirectionActivity extends Activity {
    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> laptopCollection;
    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);

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
        groupList.add("ยาเม็ด ยาเม็ดเคลือบ ยาแคปซูล");
        groupList.add("ยารับประทานชนิดน้ำแขวนตะกอน");
        groupList.add("ยาอม");
        groupList.add("ยาผง");
        groupList.add("ยาทาผิวหนัง");
        groupList.add("ยาทาถูนวด");
        groupList.add("ยาหยอดตา");
        groupList.add("ยาล้างตา");
        groupList.add("ยาหยอดหู");
        groupList.add("ยาสูดพ่นเข้าทางปาก");
        groupList.add("ยาสอด/สวนทวารหนัก");
        groupList.add("ยาสอดช่องคลอด");
        groupList.add("ยาแผ่นแปะ");
        groupList.add("ยาฉีด");
    }

    private void createCollection() {
        // preparing laptops collection(child)
        String[] data1 = { "ยาเม็ด ยาเม็ดเคลือบ ยาแคปซูล สำหรับรับประทาน ต้องกลืนไปทั้งเม็ดหรือแคปซูล พร้อมน้ำสะอาด 1 แก้ว หากเม็ดยาหรือแคปซูลมีรูปร่างหน้าตาเปลี่ยนไปจากเมื่อแรกรับยามา เช่น เยิ้ม สีกระดำกระด่าง มีเกล็ดยาเกาะอยู่ แคปซูลบวมพอง แสดงว่ายาเสื่อมคุณภาพแล้ว ห้ามนำมาใช้"};
        String[] data2 = { "ยารับประทานชนิดน้ำแขวนตะกอน หรือ แขวนละออง จะต้องเขย่าขวดก่อนรินยาเสมอ เพื่อให้ตัวยาสำคัญกระจายตัวอย่างสม่ำเสมอ และรินยาโดยใช้ช้อนตวงยา ซึ่ง 1 ช้อนชาจะเท่ากับ 5 ซีซี และ 1 ช้อนโต๊ะจะเท่ากับ 3 ช้อนชา หรือ 15 ซีซี หากเขย่ายาน้ำแขวนตะกอนแล้ว แต่ตะกอนยังจับแน่นอยู่ที่ก้นขวด หรือ เขย่ายาน้ำแขวนละอองแล้ว แต่ยังพบการแยกชั้นของน้ำกับน้ำมัน แสดงว่ายาเสื่อมคุณภาพ ห้ามใช้ยานั้น"};
        String[] data3 = { "ยาอม หากเป็นยาอมใต้ลิ้น จะต้องนำยาเม็ดใส่ไว้ใต้ลิ้น และอมไว้โดยไม่กลืนน้ำลาย เพื่อให้ยาถูกดูดซึมเข้ากระแสเลือดผ่านทางหลอดเลือดในช่องปาก แต่หากเป็นยาอมแก้เจ็บคอ หรือยาอมแก้การติดเชื้อราในปาก ให้นำเม็ดยาวางไว้บนลิ้น และอมไว้ ปล่อยให้น้ำลายมาละลายยา เมื่ออมยาประเภทนี้สามารถกลืนน้ำลายได้ หากเม็ดยามีรูปร่างหน้าตาเปลี่ยนไปจากเมื่อแรกรับยามา เช่น สีกระดำกระด่าง แสดงว่ายาเสื่อมคุณภาพแล้ว ห้ามนำมาใช้"};
        String[] data4 = { "ยาผง สำหรับรับประทาน ต้องนำไปผสมน้ำก่อนดื่ม ควรใช้ตามที่ระบุบนฉลาก เช่น ยาผงเกลือแร่ทดแทนการสูญเสียน้ำและเกลือแร่เมื่อท้องเสีย จะต้องผสมยา 1 ซองกับน้ำต้มสุกที่เย็นแล้ว 1 แก้ว หากใช้ซองใหญ่ก็ต้องผสมกับน้ำ 750 ซีซี คนให้ละลายและดื่ม ห้ามเก็บค้างคืน สำหรับยาผงที่ใช้เป็นยาระบายจะต้องผสมน้ำต้มสุกที่เย็นแล้ว 1 แก้วและดื่มทันที พร้อมดื่มน้ำตามอีก 1 แก้ว ห้ามตั้งทิ้งไว้นาน เพราะยาจะพองตัวมากและข้นหนืดจนดื่มไม่ได้"};
        String[] data5 = { "ยาทาผิวหนัง มักเป็นยาครีม เจล หรือขี้ผึ้ง ก่อนใช้ควรทำความสะอาดผิวหนังบริเวณที่ต้องการ จากนั้นบีบยาลงไปพอประมาณ แล้วทาให้ยาแผ่ไปบางๆ บนผิวหนัง หากหลอดยาบวม หรือเมื่อบีบยาออกมาได้แต่น้ำหรือน้ำมัน ที่แยกชั้นกับเนื้อยา แสดงว่ายาเสื่อมคุณภาพแล้ว ห้ามนำมาใช้"};
        String[] data6 = { "ยาทาถูนวด อาจเป็นยาครีม เจล หรือขี้ผึ้ง ใช้แก้อาการปวดเมื่อย ซึ่งหลังจากทายาแล้ว ต้องทำการถูและนวดผิวหนังบริเวณนั้นด้วย เพื่อให้เกิดความร้อน จึงจะแก้อาการปวดเมื่อยได้"};
        String[] data7 = { "ยาหยอดตา เป็นยาน้ำและถูกทำให้ปราศจากเชื้อ ยาป้ายตาก็เป็นยาที่ถูกทำให้ปราศจากเชื้อ ทั้งยาหยอดตาและป้ายตา บางชนิดต้องเก็บในตู้เย็น ซึ่งขึ้นอยู่ว่าตัวยาสำคัญคือยาใด ก่อนใช้ต้องล้างมือให้สะอาด และหยอดยา 1 หยด หรือป้ายยา 1 เซนติเมตร ลงไปในกระพุ้งเปลือกตาล่าง โดยไม่ให้ปลายหลอดสัมผัสกับตา ยาหยอดตาและยาป้ายตาที่เปิดใช้แล้ว หากใช้ไม่หมดสามารถเก็บไว้ใช้ได้อีก แต่ไม่เกิน 1 เดือน"};
        String[] data8 = { "ยาล้างตา เมื่อเปิดใช้แล้ว มีอายุอยู่ได้เพียง 7 วัน จึงไม่ควรซื้อยาขวดโตมาใช้ แม้ว่าราคาจะถูกกว่าขวดเล็ก"};
        String[] data9 = { "ยาหยอดหู ยาหยอดจมูก ยาพ่นจมูก เป็นยาที่ต้องการให้ออกฤทธิ์เฉพาะที่หู หรือ จมูก เท่านั้น ก่อนหยอดหรือพ่นยา ควรกำจัดสิ่งที่อุดตันออกก่อน ได้แก่ ขี้หู และน้ำมูก ควรใช้ยาตามจำนวนครั้งที่ระบุบนฉลาก การใช้มากเกินไปไม่ช่วยให้ดีขึ้น แต่อาจทำให้อาการเป็นมากขึ้นได้ เช่นกรณียาหยอด/พ่นจมูกซึ่งมักประกอบด้วยตัวยาลดอาการคัดจมูก หากใช้เกินกว่า 4 ครั้งต่อวันหรือนานกว่า 3 วัน จะทำให้เยื่อบุโพรงจมูกบวม และรู้สึกคัดจมูกมากขึ้นกว่าเดิมยาหยอดหู ยาหยอดจมูก ยาพ่นจมูก เป็นยาที่ต้องการให้ออกฤทธิ์เฉพาะที่หู หรือ จมูก เท่านั้น ก่อนหยอดหรือพ่นยา ควรกำจัดสิ่งที่อุดตันออกก่อน ได้แก่ ขี้หู และน้ำมูก ควรใช้ยาตามจำนวนครั้งที่ระบุบนฉลาก การใช้มากเกินไปไม่ช่วยให้ดีขึ้น แต่อาจทำให้อาการเป็นมากขึ้นได้ เช่นกรณียาหยอด/พ่นจมูกซึ่งมักประกอบด้วยตัวยาลดอาการคัดจมูก หากใช้เกินกว่า 4 ครั้งต่อวันหรือนานกว่า 3 วัน จะทำให้เยื่อบุโพรงจมูกบวม และรู้สึกคัดจมูกมากขึ้นกว่าเดิม"};
        String[] data10 = { "ยาสูดพ่นเข้าทางปาก เป็นรูปแบบยาที่มีวิธีใช้พิเศษ ใช้รักษาโรคหืดและโรคปอดอุดกั้นเรื้อรัง โดยให้ออกฤทธิ์เฉพาะที่ที่บริเวณหลอดลม ต้องฝึกวิธีใช้ให้ถูกต้อง จึงจะได้ยาเข้าไปยังหลอดลม แต่หากทำไม่ได้ ควรปรึกษาเภสัชกร เพราะปัจจุบันมีเครื่องช่วยในการสูดพ่น ซึ่งเมื่อนำมาใช้ร่วมจะทำให้ประสบความสำเร็จในการสูดพ่นยา และทำให้ควบคุมอาการของโรคได้ แต่ละชนิดปริมาณที่พ่นเข้าไปจะต่างกัน mcg/puff."};
        String[] data11 = { "ยาสอด/สวนทวารหนัก ใช้เพื่อรักษาริดสีดวงทวาร หรือ เป็นยาระบาย ขึ้นอยู่ว่าตัวยาสำคัญคือยาใด ยาสอดทวารหนักมีส่วนประกอบเป็นขี้ผึ้งเป็นส่วนใหญ่ จึงต้องแช่ในตู้เย็น (ห้ามใส่ในช่องแช่แข็ง) เพื่อให้คงรูปร่างซึ่งคล้ายจรวด เมื่อจะใช้จึงนำออกมาจากตู้เย็น ปล่อยให้คลายตัวสักพัก แล้วฉีกกระดาษหุ้มออก จุ่มยาลงในน้ำสะอาด 1 แก้ว แล้วสอดยาเข้าในทวารหนัก โดยเอาด้านแหลมเข้า หลังจากสอดยาแล้วให้นอนต่อสัก 15 นาที จึงลุกขึ้น"};
        String[] data12 = { "ยาสอดช่องคลอด เป็นยาเม็ดแข็ง ไม่ต้องแช่ตู้เย็น ใช้รักษาอาการตกขาวในผู้หญิง ควรจุ่มเม็ดยาลงในน้ำสะอาด 1 แก้ว ก่อนสอดยาเข้าในช่องคลอด โดยเอาด้านแหลมเข้า เพื่อให้สอดเม็ดยาได้ง่ายขึ้น หลังจากสอดยาแล้วให้นอนต่อสัก 15 นาที จึงลุกขึ้น"};
        String[] data13 = { "ยาแผ่นแปะผิวหนังใช้ในจุดประสงค์ต่างๆ วิธีใช้ยาแผ่นแปะเหล่านี้ก็คือ ต้องติดแผ่นยาทั้งแผ่น ห้ามตัดแบ่ง และใช้ตามระยะเวลาที่ระบุไว้ เช่น ยาแผ่นแปะแก้ปวดเฟนตานิล (fentanyl) ที่ใช้ในผู้ป่วยมะเร็งระยะสุดท้ายมีอายุการใช้ 3วันต่อการแปะ 1 แผ่นการแปะแผ่นยานานกว่านี้จะไม่ได้ผลแก้ปวด นอกจากนี้การแปะแผ่นยาบนผิวหนังไม่ว่าจะเป็นยาใดจะต้องแปะบนผิวหนังที่สะอาด ไม่มีเหงื่อ ไม่มีขน เพื่อให้แผ่นยาแปะอยู่ได้ และไม่ปิดซ้ำที่เดิมเมื่อเปลี่ยนแผ่น หากแผ่นยาหลุดออกมาก่อนเวลาเปลี่ยนแผ่น ให้ทิ้งแผ่นยานั้นไป และนำแผ่นยาแผ่นใหม่มาแปะที่ผิวหนังบริเวณอื่น"};
        String[] data14 = { "ยาฉีดเป็นยาปราศจากเชื้อ ส่วนใหญ่ฉีดโดยแพทย์หรือพยาบาล ยกเว้นยาฉีดอินสุลินที่ผู้ป่วยจะฉีดเอง ยานี้เป็นยาฉีดเข้าใต้ผิวหนัง ต้องเก็บยาในตู้เย็นบริเวณที่ไม่ใช่ช่องแช่แข็ง เมื่อจะใช้ก็นำออกมาจากตู้เย็น ปล่อยให้คลายตัวสักพัก และคลึงขวดยาระหว่างฝ่ามือทั้งสองข้างเพื่อให้อินสุลินมีอุณหภูมิเท่ากับอุณหภูมิกาย หากเป็นอินสุลินชนิดน้ำขุ่น ต้องคลึงขวดยาจนยากระจายตัวเป็นเนื้อเดียวกัน แล้วจึงดูดยาออกมาตามปริมาณที่ระบุไว้บนฉลาก จากนั้นจึงฉีดเข้าใต้ผิวหนัง โดยก่อนฉีดต้องเช็ดทำความสะอาดผิวหนังด้วยสำลีชุบแอลกอฮอล์"};


        laptopCollection = new LinkedHashMap<String, List<String>>();

        for (String laptop : groupList) {
            if (laptop.equals("ยาเม็ด ยาเม็ดเคลือบ ยาแคปซูล")) {
                loadChild(data1);
            } else if (laptop.equals("ยารับประทานชนิดน้ำแขวนตะกอน"))
                loadChild(data2);
            else if (laptop.equals("ยาอม"))
              loadChild(data3);
            else if (laptop.equals("ยาผง"))
                loadChild(data4);
            else if (laptop.equals("ยาทาผิวหนัง"))
                loadChild(data5);
            else if (laptop.equals("ยาทาถูนวด"))
                loadChild(data6);
            else if (laptop.equals("ยาหยอดตา"))
                loadChild(data7);
            else if (laptop.equals("ยาล้างตา"))
                loadChild(data8);
            else if (laptop.equals("ยาหยอดหู"))
                loadChild(data9);
            else if (laptop.equals("ยาสูดพ่นเข้าทางปาก"))
                loadChild(data10);
            else if (laptop.equals("ยาสอด/สวนทวารหนัก"))
                loadChild(data11);
            else if (laptop.equals("ยาสอดช่องคลอด"))
                loadChild(data12);
            else if (laptop.equals("ยาแผ่นแปะ"))
                loadChild(data13);
            else if (laptop.equals("ยาฉีด"))
                loadChild(data14);


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
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);;
        startActivity(intent);
        finish();
    }
}
