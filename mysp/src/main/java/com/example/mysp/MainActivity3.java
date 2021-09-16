package com.example.mysp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    private static final String TAG = "KIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void CreateDB(View view) {

      SQLiteOpenHelper helper = MySQLiteOpenhelper.getmInstance(this);
      //helper.getReadableDatabase()/helper.getWritableDatabase() 来生成相应的db文件
      SQLiteDatabase readDatabase = helper.getReadableDatabase();
    }

    public void Query(View view) {
        SQLiteOpenHelper helper = MySQLiteOpenhelper.getmInstance(this);
        //helper.getReadableDatabase()/helper.getWritableDatabase() 来生成相应的db文件
        SQLiteDatabase readDatabase = helper.getReadableDatabase();

        if(readDatabase.isOpen())
        {
            Cursor cursor = readDatabase.rawQuery("select * from persons",null);
            //迭代游标 往下面移动来遍历
            while (cursor.moveToNext()){
                //偷懒的写法
//                int _id = cursor.getInt(0);
//                String  name = cursor.getString(1);

                //规范的写法
                int _id = cursor.getInt(cursor.getColumnIndex("_id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                Log.i(TAG, "Query: _id:"+_id+"name:"+name);

            }
            //一定记得关闭游标，否则耗费性能
            cursor.close();

            readDatabase.close();

        }
    }

    public void Insert(View view) {

        SQLiteOpenHelper helper = MySQLiteOpenhelper.getmInstance(this);
        //helper.getReadableDatabase()/helper.getWritableDatabase() 来生成相应的db文件
        SQLiteDatabase readDatabase = helper.getWritableDatabase();

        if(readDatabase.isOpen()){
            String sql = "insert into persons(name) values('Jackie')";

            readDatabase.execSQL(sql);


            readDatabase.close();
        }


    }

    public void Modify(View view) {
        SQLiteOpenHelper helper = MySQLiteOpenhelper.getmInstance(this);
        //helper.getReadableDatabase()/helper.getWritableDatabase() 来生成相应的db文件
        SQLiteDatabase readDatabase = helper.getWritableDatabase();

        if(readDatabase.isOpen()){
            String sql = "update  persons set name =? where _id =?" ;

            readDatabase.execSQL(sql,new Object[]{"idol",5});


            readDatabase.close();
        }
    }

    public void Delete(View view) {
        SQLiteOpenHelper helper = MySQLiteOpenhelper.getmInstance(this);
        //helper.getReadableDatabase()/helper.getWritableDatabase() 来生成相应的db文件
        SQLiteDatabase readDatabase = helper.getWritableDatabase();

        if(readDatabase.isOpen()){
            String sql = "delete from persons where _id = ?" ;

            readDatabase.execSQL(sql,new Object[]{4});


            readDatabase.close();
        }
    }
}