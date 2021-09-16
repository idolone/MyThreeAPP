package com.example.mysp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    SharedPreferences sp;
    private EditText et_name;
    private EditText et_password;
    private CheckBox cb_rem;
    private CheckBox cb_auto;
    private Button b_reg,b_login;

    private final String  USER_NAME = "username";
    private final String  PASSWORD = "password";
    private final String  REM_PWD = "rempwd";
    private final String  AUTO_LOGIN = "autologin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sp = getSharedPreferences("config", Context.MODE_PRIVATE);
        initView();

        //第二次打开的时候需要读状态
        boolean remberpwd = sp.getBoolean(REM_PWD,false);
        boolean autologin = sp.getBoolean(AUTO_LOGIN,false);

        if(remberpwd)
        {
           String name = sp.getString(USER_NAME,"");
           String password = sp.getString(PASSWORD,"");
           et_name.setText(name);
           et_password.setText(password);
           cb_rem.setChecked(true);
        }




    }

    private void initView() {
         et_name = findViewById(R.id.UserName);
         et_password = findViewById(R.id.Password);
         cb_rem = findViewById(R.id.cb_remberpwd);
         cb_auto = findViewById(R.id.cb_autologin);

         b_reg = findViewById(R.id.btn_reg);
         b_login = findViewById(R.id.btn_login);

         b_reg.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });

         b_login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String name = et_name.getText().toString().trim();
                 String pwd = et_password.getText().toString().trim();
                 if(TextUtils.isEmpty(name)|| TextUtils.isEmpty(pwd))
                 {
                    // Toast.makeText(this,"登录名密码为空",Toast.LENGTH_SHORT).show();
                     Toast.makeText(MainActivity2.this,"登录名密码为空",Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     if(cb_rem.isChecked()){
                         //用户名和密码都要保存，同时保存记住密码项
                         SharedPreferences.Editor editor = sp.edit();
                         editor.putString(USER_NAME,name);
                         editor.putString(PASSWORD,pwd);
                         editor.putBoolean(REM_PWD,true);
                         editor.apply();

                     }
                     if(cb_auto.isChecked()){
                         //用户名和密码都要保存，同时保存记住密码项
                         SharedPreferences.Editor editor = sp.edit();

                         editor.putBoolean(AUTO_LOGIN,true);
                         editor.apply();

                     }
                 }

             }
         });
    }
}