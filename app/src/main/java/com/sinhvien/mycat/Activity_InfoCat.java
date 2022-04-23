package com.sinhvien.mycat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_InfoCat extends AppCompatActivity
{
    public static CatList catlist;
    Button btn_xacnhan, btn_edit;
    EditText catname, ngaysinh, cannang, tiem, gioitinh;
    public static ConnectDatabase database;
    String name, date, weight, tim, sex;
    public static ArrayList<Cat> cats;
//    private static long id = -1;

    //    public static ListView lvCatList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_cat);

        btn_xacnhan = findViewById(R.id.btn_xacnhan_infocat);
        btn_edit = findViewById(R.id.btn_edit);
        catname =  findViewById(R.id.catname);
        ngaysinh = findViewById(R.id.ngaysinh);
        cannang  = findViewById(R.id.cannang);
        tiem = findViewById(R.id.tiem);
        gioitinh = findViewById(R.id.gioitinh);
        database =new ConnectDatabase(this);

//        lvCatList = findViewById(R.id.lvCatList);


        btn_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.AddCat(catname.getText().toString(),gioitinh.getText().toString(),ngaysinh.getText().toString(),tiem.getText().toString(),cannang.getText().toString());
                Toast.makeText(getApplicationContext(),"Lưu thông tin thành công",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Activity_InfoCat.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CatName = catname.getText().toString().trim();
                String NgaySinh = ngaysinh.getText().toString().trim();
                String CanNang = cannang.getText().toString().trim();
                String GioiTinh = gioitinh.getText().toString().trim();
                String Tiem = tiem.getText().toString().trim();
//
//            if (NgaySinh.length() == 0 || CatName.length() == 0 || id == -1 || CanNang.length() == 0 || GioiTinh.length() == 0 || Tiem.length() == 0) return;
                Cat cat = new Cat(catlist.id, CatName, GioiTinh, NgaySinh, Tiem, CanNang);
                database.Sua(cat);
//                catlist.capNhatDuLieu();
//                catlist.reRenderListView();
                catlist.id = -1;
                Toast.makeText(getApplicationContext(),"Sửa thông tin thành công",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Activity_InfoCat.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }

    public Cat GetCat() {
        name = catname.getText().toString();
        date = ngaysinh.getText().toString();
        weight = cannang.getText().toString();
        tim = tiem.getText().toString();
        sex = gioitinh.getText().toString();
        if (name.trim().length() == 0|| date.trim().length() == 0 || weight.trim().length() == 0 || tim.trim().length() == 0 || sex.trim().length() == 0) {
            return null;
        }
        Cat Meo = new Cat();
        Meo.set_id(catlist.id);
        Meo.setCatname(name);
        Meo.setNgaysinh(date);
        Meo.setTiem(tim);
        Meo.setGioitinh(sex);
        return Meo;
    }

//    @SuppressLint("Range")
//    public void capNhatDuLieu() {
//        if (cats == null) {
//            cats = new ArrayList<Cat>();
//        } else {
//            cats.removeAll(cats);
//        }
//        // Lấy dữ liệu, dùng Cursor nhận lại
//        Cursor cursor = database.GetAllCat();
//
//        if (cursor != null) {
//            /*
//             * Di chuyển đến từng dòng dữ liệu
//             *  thông qua phương thức moveToNext
//             */
//            while (cursor.moveToNext()) {
//                Cat cat = new Cat();
//
//                cat.set_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_ID))));
//                cat.setCatname(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_CATNAME)));
//                cat.setNgaysinh(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_NGAYSINH)));
//                cat.setCannang(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_CANNANG)));
//                cat.setGioitinh(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_GIOITINH)));
//                cat.setTiem(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_TIEM)));
//                // thêm vào danh sách SinhVien
//                cats.add(cat);
//            }
//        }
//    }

    public void sua(View view) {

        Cat Meo1 = GetCat();

        if (Meo1 != null && catlist.id != -1) {
            database.Sua(Meo1);
            catlist.capNhatDuLieu();

//            // Cập nhật lại danh sách
            catlist.lvCatList.invalidateViews();

            catname.setText(null);
            gioitinh.setText(null);
            ngaysinh.setText(null);
            cannang.setText(null);
            tiem.setText(null);
            catlist.id = -1;
        }
    }


}