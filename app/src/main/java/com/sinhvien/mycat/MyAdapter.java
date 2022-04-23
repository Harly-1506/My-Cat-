package com.sinhvien.mycat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter {

    LayoutInflater inflater;
    TextView Catname, NgaySinh, GioiTinh, CanNang, Tiem;
    Context context;
    ArrayList<Cat> arrayList;
    int layout;

    //    public MyAdapter(Context context){
//        inflater = LayoutInflater.from(context);
//        this.context = context;
//    }
    public MyAdapter(@NonNull Context context, int resource, ArrayList<Cat> arrayList) {
        super(context, resource, arrayList);
        this.context = context;
        this.arrayList = arrayList;
        this.layout = resource;
    }
//
//    @Override
//    public int getCount(){ return CatList.cats.size();}
//
//    @Override
//    public Object getItem(int position) {
//        return CatList.cats.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return CatList.cats.get(position).get_id();
//    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Cat cat = arrayList.get(position);
        if (convertView == null) convertView = LayoutInflater.from(context).inflate(layout, null);
        Catname =  convertView.findViewById(R.id.txtCatname);
        Catname.setText(cat.getCatname());
        GioiTinh =  convertView.findViewById(R.id.txtGioitinh);
        GioiTinh.setText(cat.getGioitinh());
        CanNang =  convertView.findViewById(R.id.txtCan);
        CanNang.setText(cat.getCannang());
        NgaySinh =  convertView.findViewById(R.id.txtNgaysinh);
        NgaySinh.setText(cat.getNgaysinh());
        Tiem =  convertView .findViewById(R.id.txtTiem);
        Tiem.setText(cat.getTiem());
        TextView btnDelete = convertView.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity_InfoCat.database.xoa(cat);
                arrayList.remove(position);
                Toast.makeText(getContext(),"Thông tin đã được xóa",Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

}