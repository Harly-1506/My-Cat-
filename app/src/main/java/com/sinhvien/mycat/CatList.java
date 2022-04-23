package com.sinhvien.mycat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class CatList extends AppCompatActivity {

    //    ListView lvStudentList;
//    ConnectDatabase dbHelper;
//    SimpleCursorAdapter myadapter;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cat_list);
//
//
//        // create databe
//        dbHelper = new ConnectDatabase(this);
//
//        //get data from database
//        Cursor c = dbHelper.GetAllCat();
//
//        String[] from = new String[] {"_id","_catname","_gioitinh","_ngaysinh","_tiemchung","_cannang"};
//        int[] to = new int[]{R.id.id,R.id.txtCatname,R.id.txtGioitinh,R.id.txtNgaysinh, R.id.txtTiem, R.id.txtCan};
//
//        lvStudentList = findViewById(R.id.lvStudentList);
//
//        myadapter =new SimpleCursorAdapter(CatList.this,R.layout.lay_out,c,from,to,0);
//
//        lvStudentList.setAdapter(myadapter);
//    }
    public static Activity_InfoCat Info;
    public static ListView lvCatList;
    public static ArrayList<Cat> cats;
    public static ConnectDatabase database;
    private  ArrayList<Cat> arrayList;
    EditText txtcatname, txtngaysinh, txtcannang, txttiem,txtgioitinh;
    ImageButton back;

    public MyAdapter CatAdapter;

    // Lớp hỗ trợ truy vấn dữ liệu
//    private String catname, ngaysinh, cangcan, tiem, gioitinh;
    public static long id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_list);

        database = new ConnectDatabase(this);
        lvCatList = findViewById(R.id.lvCatList);
        arrayList = database.getAllCat();
        txtcatname =  findViewById(R.id.catname);
        txtngaysinh = findViewById(R.id.ngaysinh);
        txtcannang  = findViewById(R.id.cannang);
        txttiem = findViewById(R.id.tiem);
        back = findViewById(R.id.img_back_info);
        txtgioitinh = findViewById(R.id.gioitinh);


        arrayList = database.getAllCat();
        CatAdapter = new MyAdapter(CatList.this, R.layout.lay_out, arrayList);
        lvCatList.setAdapter(CatAdapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatList.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Bắt sự kiện khi click lên ListView
        lvCatList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//                txtcatname.setText(arrayList.get(position).getCatname());
//                txtngaysinh.setText(arrayList.get(position).getNgaysinh());
//                txtcannang.setText(arrayList.get(position).getCannang());
//                txtgioitinh.setText(arrayList.get(position).getGioitinh());
//                txttiem.setText(arrayList.get(position).getTiem());

                id = arrayList.get(position).get_id();
                Intent intent = new Intent(CatList.this, Activity_InfoCat.class);
                startActivity(intent);

            }
        });
    }
    //     cập nhật dl
    @SuppressLint("Range")
    public void capNhatDuLieu() {
        if (cats == null) {
            cats = new ArrayList<Cat>();
        } else {
            cats.removeAll(cats);
        }
        // Lấy dữ liệu, dùng Cursor nhận lại
        Cursor cursor = database.GetAllCat();

        if (cursor != null) {
            /*
             * Di chuyển đến từng dòng dữ liệu
             *  thông qua phương thức moveToNext
             */
            while (cursor.moveToNext()) {
                Cat cat = new Cat();

                cat.set_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_ID))));
                cat.setCatname(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_CATNAME)));
                cat.setNgaysinh(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_NGAYSINH)));
                cat.setCannang(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_CANNANG)));
                cat.setGioitinh(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_GIOITINH)));
                cat.setTiem(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_TIEM)));
                // thêm vào danh sách SinhVien
                cats.add(cat);
            }
        }
    }
//    private void reRenderListView(){
//        sinhVienAdapter.clear();
//        sinhVienAdapter.addAll(database.getAllSinhVien());
//        sinhVienAdapter.notifyDataSetChanged();
//        edtName.setText("");
//        edtClass.setText("");
//    }
    public void reRenderListView(){
    CatAdapter.clear();
    CatAdapter.addAll(database.getAllCat());
    CatAdapter.notifyDataSetChanged();
    }
}