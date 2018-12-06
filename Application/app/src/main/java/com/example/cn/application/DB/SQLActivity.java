package com.example.cn.application.DB;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cn.application.LogUtils;
import com.example.cn.application.R;

import java.util.Random;

public class SQLActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_create, bt_add, bt_update, bt_delete;
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        bt_create = findViewById(R.id.bt_Create);
        bt_add = findViewById(R.id.bt_add);
        bt_update = findViewById(R.id.bt_update);
        bt_delete = findViewById(R.id.bt_delete);

        bt_add.setOnClickListener(this);
        bt_create.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_delete.setOnClickListener(this);

        dbHelper = new DBHelper(this);
        sqLiteDatabase = dbHelper.getWritableDatabase();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add:
                insertData();
                break;
            case R.id.bt_delete:
                deletedata();
                break;
            case R.id.bt_update:
                updataData();
                break;
            case R.id.bt_Create:
                queryData();
                break;
        }
    }

    private void deletedata() {
        sqLiteDatabase.delete(DBHelper.TABLE_NAME, DBHelper.NAME + "=?", new String[]{"鹿晗"});
    }

    private void updataData() {
        ContentValues values = new ContentValues();
        values.put(DBHelper.NAME, "傻逼" + System.currentTimeMillis());
        values.put(DBHelper.AGE, 17);
        sqLiteDatabase.update(DBHelper.TABLE_NAME,
                values,
                DBHelper.AGE + "=?",
                new String[]{"16"});
    }

    // 表名
    // null。数据库如果插入的数据为null，会引起数据库不稳定。为了防止崩溃，需要传入第二个参数要求的对象
    // 如果插入的数据不为null，没有必要传入第二个参数避免崩溃，所以为null
    // 插入的数据
    private void insertData() {
        ContentValues values = new ContentValues();
        values.put(DBHelper.NAME, "鹿晗" + System.currentTimeMillis());
        values.put(DBHelper.AGE, 17);
        sqLiteDatabase.insert(DBHelper.TABLE_NAME, null, values);
        Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
    }

    // 表名
    // 查询字段
    // 查询条件
    // 满足查询的值
    // 分组
    // 分组筛选关键字
    // 排序
    private void queryData() {
        Cursor cursor = sqLiteDatabase.query(DBHelper.TABLE_NAME,
                new String[]{DBHelper.NAME, DBHelper.AGE},
                DBHelper.AGE + " > ?",
                new String[]{"16"},
                null,
                null,
                DBHelper.AGE + " desc");// 注意空格！

        int nameIndex = cursor.getColumnIndex(DBHelper.NAME);
        int ageIndex = cursor.getColumnIndex(DBHelper.AGE);
        while (cursor.moveToNext()) {
            String name = cursor.getString(nameIndex);
            String age = cursor.getString(ageIndex);

            LogUtils.Log("name: " + name + ", age: " + age);
        }

    }
}
