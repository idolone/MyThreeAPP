package com.example.mymedia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class MediaPlayerActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener ,MediaPlayer.OnCompletionListener{
    private TextureView textureView;
    private Button player_btn;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        textureView = findViewById(R.id.textureV);
        player_btn = findViewById(R.id.btn_rec);

        player_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CharSequence text = player_btn.getText();

        if(TextUtils.equals(text,"开始")) {
            player_btn.setText("结束");
            
            mediaPlayer = new MediaPlayer();

            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnCompletionListener(this);

            try {
                mediaPlayer.setDataSource(new File(getExternalFilesDir(""),"a.mp4").getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.setSurface(new Surface(textureView.getSurfaceTexture()));
            mediaPlayer.prepareAsync();

        }else{
            player_btn.setText("开始");
            mediaPlayer.stop();
            mediaPlayer.release();

        }


    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlayer.start();

    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        player_btn.setText("开始");
        mediaPlayer.release();
    }
}