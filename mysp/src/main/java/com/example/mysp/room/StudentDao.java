package com.example.mysp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao  //
public interface StudentDao {
    //
    @Insert
    void insertStudent(Student ... students);
    @Update
    void modifyStudent(Student ... students);
    @Delete
    void deleteStudents(Student ... students);
    //删除所有，@Delete 单个条件删除才使用
    @Query("DELETE FROM Student")
    void deleteAllStudents();

    //查询
    @Query("SELECT * FROM Student ORDER BY ID DESC")
    List<Student> getAllStudent();
}
