package com.example.mymedia;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class MediaRecordActivity extends AppCompatActivity {
    private TextureView textureView;
    private Button startrec_btn;
    MediaRecorder mediaRecorder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_record);

        textureView = findViewById(R.id.textureV);
        startrec_btn = findViewById(R.id.btn_rec);

        startrec_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = startrec_btn.getText();

                if(TextUtils.equals(text,"开始"))
                {
                    startrec_btn.setText("结束");
                    mediaRecorder = new MediaRecorder();
                    mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
                    mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                    mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                    mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);

                    mediaRecorder.setOutputFile(new File(getExternalFilesDir(""),"a.mp4").getAbsolutePath());
                    mediaRecorder.setVideoSize(640,480);
                    mediaRecorder.setPreviewDisplay(new Surface(textureView.getSurfaceTexture()));
                    try {
                        mediaRecorder.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mediaRecorder.start();

                }else{
                    startrec_btn.setText("开始");
                    mediaRecorder.stop();
                    mediaRecorder.release();
                }

            }
        });
    }
}
