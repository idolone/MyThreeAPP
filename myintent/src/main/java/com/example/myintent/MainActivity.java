package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Switch2Activity2(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
//        intent.putExtra("name","idol");
//        intent.putExtra("sex","M");

        Bundle bundle = new Bundle();
        bundle.putString("name","keee");
        bundle.putString("sex","male");
        intent.putExtras(bundle);

        startActivity(intent);
    }
}