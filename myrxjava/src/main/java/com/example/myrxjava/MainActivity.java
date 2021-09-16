package com.example.myrxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private static final String PATH = "http://pic1.win4000.com/wallpaper/c/53cdd1f7c1f21.jpg";
    private ProgressDialog progressDialog;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         imageView = findViewById(R.id.img);
    }

    public void btnonclick(View view) {
        //TODO 第二步
        Observable.just(PATH)
                //TODO 第三步
                .map(new Function<String, Bitmap>() {
                    @Override
                    public Bitmap apply(@NotNull String path) throws Exception {
                        try {
                            URL url = new URL(path);
                            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                            httpURLConnection.setConnectTimeout(5000);
                            int responseCode = httpURLConnection.getResponseCode();//200成功，404错误
                            if(responseCode == HttpURLConnection.HTTP_OK)
                            {
                                InputStream inputStream = httpURLConnection.getInputStream();

                                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                                return  bitmap;
                            }

                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        return null;
                    }
                })
                //给上面的分配异步线程
                .subscribeOn(Schedulers.io())

                //给终点分配Android主线程
                .observeOn(AndroidSchedulers.mainThread())

                //关联观察者设计模式 关联 起点 终点
                .subscribe(new Observer<Bitmap>() {
                    //TODO 第一步
                    @Override
                    public void onSubscribe(@org.jetbrains.annotations.NotNull Disposable d) {
                     //订阅成功
                        progressDialog = new ProgressDialog(MainActivity.this);
                        progressDialog.setTitle("正在加载中...");
                        progressDialog.show();
                    }
                    //TODO 第四步
                    //上一层给我的响应
                    @Override
                    public void onNext(@org.jetbrains.annotations.NotNull Bitmap s) {


                        imageView.setImageBitmap(s);

                    }
                    //链条思维发生异常
                    @Override
                    public void onError(@org.jetbrains.annotations.NotNull Throwable e) {

                    }
                    //TODO 第五步
                    //整个链条结束
                    @Override
                    public void onComplete() {
                             if(progressDialog != null)
                             {
                                 progressDialog.dismiss();
                             }
                    }
                });





    }
}