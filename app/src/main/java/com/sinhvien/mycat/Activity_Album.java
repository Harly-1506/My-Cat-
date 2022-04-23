package com.sinhvien.mycat;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Activity_Album extends AppCompatActivity {
    ImageView imageView , imageview2;
    ImageButton btn_back;
    Bitmap bitmap = null;
    byte img[];
    private DataBase mdb=null;
    private SQLiteDatabase db=null;
    private Cursor c=null;
    private static final String DATABASE_NAME = "ImageDb.db";
    public static final int DATABASE_VERSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageview2 = (ImageView) findViewById(R.id.imageview2);
        btn_back = (ImageButton) findViewById(R.id.img_back_album);
        mdb= new  DataBase(getApplicationContext(), DATABASE_NAME,null,
                DATABASE_VERSION);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Album.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void selectImage(View view)
    {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode== Activity.RESULT_OK && data !=null)
        {
            Uri selectedImage = data.getData();
            try{
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedImage);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,bos);
                img = bos.toByteArray();
                imageView.setImageBitmap(bitmap); } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @SuppressWarnings("deprecation")
    public void uploadImage(View view)
    {
        db=mdb.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("image", img);
        db.insert("tableimage", null, cv);
        imageView.setAlpha(0);
        Toast.makeText(this, "Thêm ảnh thành công", Toast.LENGTH_SHORT).show();
    }
    public void retImage(View view)
    {
        String[] col={"image"};
        db=mdb.getReadableDatabase();
        c=db.query("tableimage", col, null, null, null, null, null);
        if(c!=null){
            c.moveToFirst();
            do{
                img=c.getBlob(c.getColumnIndex("image"));
            }while(c.moveToNext());
        }
        Bitmap b1=BitmapFactory.decodeByteArray(img, 0, img.length);
        imageview2.setImageBitmap(b1);
        Toast.makeText(this, "Ảnh đã tải lên", Toast.LENGTH_SHORT).show();
    }
}