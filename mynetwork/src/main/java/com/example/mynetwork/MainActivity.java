package com.example.mynetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "KIN";
    private OkHttpClient okhttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okhttpClient = new OkHttpClient();
    }

     //需要创建子线程，因为call.execute()会阻塞
    public void GetSync(View view) {
        new Thread(){
            @Override
            public void run() {
                Request request = new Request.Builder().url("https:www.httpbin.org/get?a=1&b=2").build();
                Call call = okhttpClient.newCall(request);

                try {
                    Response response = call.execute();
                    Log.i(TAG, "GetSync: "+ response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    public void GetAsyn(View view) {
        Request request = new Request.Builder().url("https:www.httpbin.org/get?a=1&b=2").build();
        Call call = okhttpClient.newCall(request);
        //异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if(response.isSuccessful())
                {
                    Log.i(TAG, "GetAsyn: "+response.body().string());
                }
            }
        });
    }

    public void PostSync(View view) {
        new Thread(){
            @Override
            public void run() {
                FormBody formBody = new FormBody.Builder()
                        .add("a","1").add("b","2").build();
                Request request = new Request.Builder().url("https:www.httpbin.org/post")
                        .post(formBody).build();
                Call call = okhttpClient.newCall(request);
                try {
                    Response response = call.execute();
                    Log.i(TAG, "PostSync: "+ response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();




    }

    public void PostAsyn(View view) {

        FormBody formBody = new FormBody.Builder()
                .add("a","1").add("b","2").build();
        Request request = new Request.Builder().url("https:www.httpbin.org/post")
                .post(formBody).build();
        Call call = okhttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.i(TAG, "PostAsyn: "+ response.body().string());
            }
        });
    }
}