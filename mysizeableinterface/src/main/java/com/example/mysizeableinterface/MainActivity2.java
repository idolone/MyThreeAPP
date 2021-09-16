package com.example.mysizeableinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "KIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        Student student = (Student)intent.getSerializableExtra("Student");
        Log.e(TAG, "onCreate serializable: "+ student.getId() +student.getName() );

        Toast.makeText(this, " name:",Toast.LENGTH_SHORT).show();


    }
}