package com.sinhvien.mycat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;


import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    MenuItem menuItem;
    ViewFlipper viewFlipper;
    int[]  arrayHinh = {R.drawable.download1,R.drawable.download2,R.drawable.download3,R.drawable.download4,R.drawable.download5};
    ImageButton btn_calendar , btn_info , btn_tool,btn_food , btn_health,btn_album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_calendar = (ImageButton) findViewById(R.id.btn_vaccin_main);
        btn_info = (ImageButton) findViewById(R.id.btn_info_main);
        btn_tool = (ImageButton) findViewById(R.id.btn_tool_main);
        btn_food = (ImageButton) findViewById(R.id.btn_food_main);
        btn_health = (ImageButton) findViewById(R.id.btn_health_main);
        btn_album = (ImageButton) findViewById(R.id.btn_album_main);
        btn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Calendar.class);
                startActivity(intent);
            }
        });
        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CatList.class);
                startActivity(intent);
            }
        });
        btn_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Activity_CatTool.class);
                startActivity(intent);
            }
        });
        btn_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Activity_food.class);
                startActivity(intent);
            }
        });
        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Activity_health.class);
                startActivity(intent);
            }
        });
        btn_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Activity_Album.class);
                startActivity(intent);
            }
        });

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        viewFlipper = (ViewFlipper)findViewById(R.id.vf_slide_activitymain);
        for (int i = 0 ; i < arrayHinh.length ; i++ ){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(arrayHinh[i]);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }
     @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem  menuItem) {
         switch (menuItem.getItemId()) {
             case R.id.nav_info:
                 Intent intent = new Intent (MainActivity.this,Activity_InfoCat.class);
                 startActivity(intent);
                 break;
             case R.id.nav_vaccination:
                 Intent intent1 = new Intent (MainActivity.this,Calendar.class);
                 startActivity(intent1);
                 break;
             case R.id.nav_healthcondition:
                 Intent intent2 = new Intent (MainActivity.this,Activity_health.class);
                 startActivity(intent2);
                 break;
             case R.id.nav_tool:
                 Intent intent3 = new Intent (MainActivity.this,Activity_CatTool.class);
                 startActivity(intent3);
                 break;
             case R.id.nav_diet:
                 Intent intent5 = new Intent (MainActivity.this,Activity_food.class);
                 startActivity(intent5);
                 break;
             case R.id.nav_album:
                 Intent intent6 = new Intent (MainActivity.this,Activity_Album.class);
                 startActivity(intent6);
                 break;
             case R.id.nav_logout:
                 Intent intent7 = new Intent (MainActivity.this,Activity_ChonTaiKhoan.class);
                 startActivity(intent7);
                 break;
         }
         drawerLayout.closeDrawer(GravityCompat.START);
         return true;
    }
}