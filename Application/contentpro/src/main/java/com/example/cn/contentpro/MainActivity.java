package com.example.cn.contentpro;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        testFind();


//        ViewGroup

        SingleInstance instance = SingleInstance.getInstance(this);
    }

    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String TABLE_NAME = "t_person";

    public void testFind() {
        ContentResolver contentResolver = this.getContentResolver();
//        host ：//开放出来的uri/表名
        Uri selectUri = Uri.parse("content://com.example.cn.application/t_person");
        Cursor cursor = contentResolver.query(selectUri, null, null, null, null);
        int nameIndex = cursor.getColumnIndex(NAME);
        int ageIndex = cursor.getColumnIndex(AGE);
        while (cursor.moveToNext()) {
            String name = cursor.getString(nameIndex);
            String age = cursor.getString(ageIndex);

            Log.d("学习", "name: " + name + ", age: " + age);
        }
    }
}
