package com.example.mysp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mysp.room.Student;
import com.example.mysp.room.manager.DBEngine;

public class MainActivity4 extends AppCompatActivity {
    private DBEngine dbEngine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        dbEngine = new DBEngine(this);
    }

    public void QueryAction(View view) {
       dbEngine.QueryAllStudents();
    }

    public void InsertAction(View view) {
//        Student student1 = new Student(0,"蒋一",18);
//        Student student2 = new Student(1,"李二",17);
//        Student student3 = new Student(2,"张三",16);
//        Student student4 = new Student(3,"李四",15);
//        Student student5 = new Student(4,"王五",14);
//        Student student1 = new Student(1,"蒋一",18);
//        Student student2 = new Student(2,"李二",17);
//        Student student3 = new Student(3,"张三",16);
//        Student student4 = new Student(4,"李四",15);
//        Student student5 = new Student(5,"王五",14);
        Student student1 = new Student("蒋一",18);
        Student student2 = new Student("李二",17);
        Student student3 = new Student("张三",16);
        Student student4 = new Student("李四",15);
        Student student5 = new Student("王五",14);



        dbEngine.insertStudents(student1,student2,student3,student4,student5);
    }

    public void UpdateAction(View view) {
        Student student = new Student("liyuan",22);
        student.setId(3);
        dbEngine.UpdateStudents(student);
    }

    public void DeleteAction(View view) {
        Student student = new Student("null",0);
        student.setId(3);
        dbEngine.DeleteStudents(student);
    }

    public void DeleteAllAction(View view) {
        dbEngine.DeleteAllStudents();
    }
}