package com.example.mysp.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

//数据库 关联 之前的表 数据库信息
@Database(entities = {Student.class},version = 1,exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    //用户只需操作DAO，我们必须暴露DAO，DAO被用户拿到后，就能对数据库进行操作

    public abstract StudentDao getStudentDao();

 //单例模式 返回DB
    private static  StudentDatabase mInstance;

   public static synchronized  StudentDatabase getmInstance(Context context)
    {
        if(mInstance == null){
            mInstance = Room.databaseBuilder
                    (context.getApplicationContext(),StudentDatabase.class,"stu_db")
                    .build();

        }
        return mInstance;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
