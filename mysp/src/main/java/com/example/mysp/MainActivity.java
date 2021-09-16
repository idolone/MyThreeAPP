package com.example.mysp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveData(View view) {

       SharedPreferences sp = getSharedPreferences("SPDerryName", Context.MODE_PRIVATE);
        sp.edit().putString("DerryKey","九阳神功").apply();
    }

    public void GetData(View view) {
        SharedPreferences sp = getSharedPreferences("SPDerryName", Context.MODE_PRIVATE);
        String str = sp.getString("DerryKey","默认值");
        Toast.makeText(this,""+str,Toast.LENGTH_SHORT).show();
        String str1 = sp.getString("DerryKey1","默认值");
        Toast.makeText(this,""+str1,Toast.LENGTH_SHORT).show();
    }
}