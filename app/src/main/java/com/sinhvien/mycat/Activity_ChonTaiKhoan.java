package com.sinhvien.mycat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_ChonTaiKhoan extends AppCompatActivity {

    Button lg_mycat,lg_fb, lg_gg, re_mycat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_tai_khoan);

        lg_mycat = findViewById(R.id.btn_loginmycat_chontaikhoan);
        re_mycat = findViewById(R.id.btn_resmycat_chontaikhoan);

        lg_mycat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_ChonTaiKhoan.this,Activity_login.class);
                startActivityForResult(intent, 100);
            }
        });
        re_mycat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_ChonTaiKhoan.this,Activity_register.class);
                startActivityForResult(intent, 100);
            }
        });
    }
}