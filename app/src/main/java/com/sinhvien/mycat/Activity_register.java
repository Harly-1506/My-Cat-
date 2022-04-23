package com.sinhvien.mycat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_register extends AppCompatActivity {

    EditText username, email, password;
    Button register, had_accout;
    ConnectDatabase dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.ed_yourname_register);
        email = findViewById(R.id.pw_password_register);
        password = findViewById(R.id.pw_confirmpassword_register);


        dbHelper = new ConnectDatabase(this);
        register = findViewById(R.id.btn_register_register);
        had_accout = findViewById(R.id.btn_accounted_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sukienLuuThongTin();
            }
        });

        had_accout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_register.this,Activity_login.class);
                startActivity(intent);
            }
        });
    }
    public void sukienLuuThongTin(){
        String ten = username.getText().toString();
        String thudientu = email.getText().toString();
        String matkhau = password.getText().toString();

        if(ten.equals("") || matkhau.equals("")){
            Toast.makeText(Activity_register.this, "Hãy nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        }
        else{
            Boolean kiemtraTaiKhoan = dbHelper.CheckAccount(ten, matkhau);
            if(kiemtraTaiKhoan == true){
                Toast.makeText(Activity_register.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
            }
            else{
                Boolean luuThongTin = dbHelper.AddUser(ten, thudientu ,matkhau);
                if(luuThongTin){
                    Toast.makeText(Activity_register.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Activity_register.this,Activity_login.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Activity_register.this, "Tạo tài khoản thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}