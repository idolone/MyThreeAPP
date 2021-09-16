package com.example.mysizeableinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,"welcome",Toast.LENGTH_SHORT).show();
    }

    public void Switch2Activity2(View view) {

        Intent intent = new Intent(this,MainActivity2.class);

        Student student = new Student(9,"sin",20);
        intent.putExtra("Student",student);
        startActivity(intent);
    }
}