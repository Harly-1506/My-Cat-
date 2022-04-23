package com.sinhvien.mycat;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ConnectDatabase extends SQLiteOpenHelper {

    // database version
    private static final int DATABASE_VERSION = 1;
    // database name

    private static final String DATABASE_NAME = "db_StudentManagement";
    // table name
    private static final String TABLE_PERSON = "tbl_Person";
    private static final String TABLE_CAT = "tbl_Cat";

    // tao cot
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "_username";
    public static final String KEY_EMAIL = "_email";
    public static final String KEY_PASS = "_password";
    public static final String KEY_CATNAME = "_catname";
    public static final String KEY_GIOITINH = "_gioitinh";
    public static final String KEY_NGAYSINH = "_ngaysinh";
    public static final String KEY_TIEM = "_tiemchung";
    public static final String KEY_CANNANG = "_cannang";



    public ConnectDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_PERSON_TABLE = "CREATE TABLE " + TABLE_PERSON + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_EMAIL + " TEXT,"
                + KEY_PASS + " TEXT" + ")";

        String CREATE_CAT_TABLE = "CREATE TABLE " + TABLE_CAT + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CATNAME + " TEXT,"
                + KEY_GIOITINH + " TEXT," +  KEY_NGAYSINH + " TEXT," + KEY_TIEM + " TEXT," + KEY_CANNANG + " TEXT" + ")";

        sqLiteDatabase.execSQL(CREATE_PERSON_TABLE);
        sqLiteDatabase.execSQL(CREATE_CAT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAT);
    }

    public Boolean AddUser(String username, String email, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, username);
        contentValues.put(KEY_EMAIL, email);
        contentValues.put(KEY_PASS, password);
        long ketqua = myDB.insert(TABLE_PERSON, null, contentValues);
        if(ketqua == -1) return false;
        else{
            return true;
        }
    }

    //Cac phuong thuc kiem tra
    public Boolean CheckAccount(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from "+ TABLE_PERSON
                +" where "+ KEY_NAME + " = ? and " + KEY_PASS + "= ?", new String[] {username, password});
        if(cursor.getCount() > 0){
            return true;
        }
        else
            return false;
    }
    public void AddCat(String catname, String gioitinh, String ngaysinh, String tiem, String cannang){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CATNAME, catname);
        values.put(KEY_GIOITINH, gioitinh);
        values.put(KEY_NGAYSINH, ngaysinh);
        values.put(KEY_TIEM, tiem);
        values.put(KEY_CANNANG, cannang);



        // Inserting Row
        db.insert(TABLE_CAT, null, values);
        db.close(); // Closing database connection
    }
    public Cursor GetAllCat(){
        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor mCursor = db.query(TABLE_CAT,new String[]{KEY_ID,KEY_CATNAME,KEY_GIOITINH,KEY_NGAYSINH,KEY_TIEM,KEY_CANNANG},null,null,null,null,null);
//        if (mCursor != null) {
//            mCursor.moveToFirst();
//        }
//        return mCursor;
        String[] Cot = {KEY_ID,KEY_CATNAME,KEY_GIOITINH,KEY_NGAYSINH,KEY_TIEM,KEY_CANNANG};
        Cursor cursor = null;
        cursor = db.query(
                TABLE_CAT, Cot, null, null, null, null,
                KEY_ID + " DESC");

        return cursor;
    }
    @SuppressLint("Range")
    public ArrayList<Cat> getAllCat(){
        String[] column = {KEY_ID, KEY_CATNAME, KEY_GIOITINH, KEY_CANNANG, KEY_TIEM,KEY_NGAYSINH};
        ArrayList<Cat> res = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_CAT, column, null,null,null,null,null);

        while (cursor.moveToNext()){
            Cat cat = new Cat();
            cat.set_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_ID))));
            cat.setCatname(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_CATNAME)));
            cat.setNgaysinh(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_NGAYSINH)));
            cat.setCannang(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_CANNANG)));
            cat.setGioitinh(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_GIOITINH)));
            cat.setTiem(cursor.getString(cursor.getColumnIndex(ConnectDatabase.KEY_TIEM)));
            res.add(cat);
        }
        return res;
    }
    public long xoa(Cat cat) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_CAT, KEY_ID+"="+ cat.get_id(), null);

    }


    public long Sua(Cat cat){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CATNAME, cat.getCatname());
        values.put(KEY_GIOITINH, cat.getGioitinh());
        values.put(KEY_NGAYSINH, cat.getNgaysinh());
        values.put(KEY_TIEM, cat.getTiem());
        values.put(KEY_CANNANG, cat.getCannang());

        return db.update(TABLE_CAT, values, KEY_ID + " = "
                + cat.get_id(), null);
    }


}