package com.sinhvien.mycat;

import java.sql.Date;

public class Cat {
    private long id;
    private String catname;
    private String ngaysinh;
    private String gioitinh;
    private String tiem;
    private String cannang;

    public Cat(long id, String catname, String ngaysinh, String gioitinh, String cannang, String tiem) {
        this.id = id;
        this.catname = catname;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.tiem = tiem;
        this.cannang = cannang;

    }
    public Cat(){}
    public long get_id() {
        return id;
    }

    public void set_id(long id) {
        this.id = id;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }


    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getTiem() {
        return tiem;
    }

    public void setTiem(String tiem) {
        this.tiem = tiem;
    }

    public String getCannang() {
        return cannang;
    }

    public void setCannang(String cannang) {
        this.cannang = cannang;
    }
}