package com.sinhvien.mycat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_login extends AppCompatActivity {
    EditText username, password;
    Button lg_btn, forgetpw_btn;
    ConnectDatabase dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new ConnectDatabase(this);
        username = findViewById(R.id.ed_username_login);
        password = findViewById(R.id.pw_matkhau_login);
        lg_btn = findViewById(R.id.btn_login_login);
        forgetpw_btn = findViewById(R.id.btn_forgotpw_login);

        lg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sukienDangNhap();
            }
        });
    }

    public void sukienDangNhap() {
        String ten = username.getText().toString();
        String matkhau = password.getText().toString();

        if(ten.equals("") || matkhau. equals("")){
            Toast.makeText(Activity_login.this, "Hay nhap du thong tin", Toast.LENGTH_SHORT).show();
        }
        else{
            Boolean kiemtraTaiKhoan = dbHelper.CheckAccount(ten,matkhau);
            if(kiemtraTaiKhoan == true){
                Toast.makeText(Activity_login.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                Intent login = new Intent(Activity_login.this, Activity_InfoCat.class);
//                    Bundle b = new Bundle();
//                    b.putString("ten", ten);
//                    b.putString("matkhau", matkhau);
//                    it_trangthongtin.putExtras(b);
                startActivity(login);
            }
            else{
                Toast.makeText(Activity_login.this, "Tai khoan hoac mat khau khong dung", Toast.LENGTH_SHORT).show();
            }
        }
    }

}