package com.example.mysp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * MySQLiteOpenhelper 工具类   单例模式（1.构造函数私有化 2.对外提供函数）
 */
public class MySQLiteOpenhelper extends SQLiteOpenHelper {
    //2.对外提供函数
    private static SQLiteOpenHelper mInstance;

    public static synchronized  SQLiteOpenHelper getmInstance(Context context){
        if(mInstance == null){
            mInstance = new MySQLiteOpenhelper(context,"idol.db",null,1);
        }
        return mInstance;
    }

    //1.构造函数私有化
    private MySQLiteOpenhelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //数据库初始化
    //创建表  数据库第一次创建的时候使用 第二次发现有了就不会重复创建了
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表 persons表 _id name

        //主键：primary key 必须唯一
        //自动增长数字：如 1 2 3 4 5 6 autoincrement
        //_id标准的写法（要求1） 只能使用  主键只能是Integer类型的（要求2）
        //id 不标准
        String sql = "create table persons(_id integer primary key autoincrement,name text)";

        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
