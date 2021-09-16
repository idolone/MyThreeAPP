package com.example.mymedia;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      ActivityCompat.requestPermissions(this,new String[]
                {Manifest.permission.RECORD_AUDIO,Manifest.permission.CAMERA}
                ,100);

    }

    public void record(View view) {
        Intent intent = new Intent(this,MediaRecordActivity.class);

        startActivity(intent);


    }

    public void playVideo(View view) {
        Intent intent = new Intent(this,MediaPlayerActivity.class);

        startActivity(intent);
    }

    public void playAudio(View view) {
        Intent intent = new Intent(this,MediaRecordActivity.class);

        startActivity(intent);
    }
}