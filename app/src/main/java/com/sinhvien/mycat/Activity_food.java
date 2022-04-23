package com.sinhvien.mycat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity_food extends AppCompatActivity {
    TextView Txt1, Txt2 , Txt3 , Txt4;
    ImageButton btn_thu_1, btn_thu_2,btn_thu_3, btn_thu_4, btn_back;
    LinearLayout linear1, linear2,linear3,linear4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Txt1 = findViewById(R.id.Txt_food_1);
        Txt2 = findViewById(R.id.Txt_food_2);
        Txt3 = findViewById(R.id.Txt_food_3);
        Txt4 = findViewById(R.id.Txt_food_4);
        linear1 = findViewById(R.id.linear_food_1);
        linear2 = findViewById(R.id.linear_food_2);
        linear3 = findViewById(R.id.linear_food_3);
        linear4 = findViewById(R.id.linear_food_4);
        btn_thu_1 = findViewById(R.id.btn_food_1);
        btn_thu_2 = findViewById(R.id.btn_food_2);
        btn_thu_3 = findViewById(R.id.btn_food_3);
        btn_thu_4 = findViewById(R.id.btn_food_4);
        btn_back = findViewById(R.id.img_back_info);

        Txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear1.setVisibility(View.VISIBLE);
                linear2.setVisibility(View.GONE);
                linear3.setVisibility(View.GONE);
                linear4.setVisibility(View.GONE);
            }
        });
        btn_thu_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear1.setVisibility(View.GONE);
            }
        });

        Txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear2.setVisibility(View.VISIBLE);
                linear1.setVisibility(View.GONE);
                linear3.setVisibility(View.GONE);
                linear4.setVisibility(View.GONE);
            }
        });
        btn_thu_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear2.setVisibility(View.GONE);
            }
        });

        Txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear3.setVisibility(View.VISIBLE);
                linear1.setVisibility(View.GONE);
                linear2.setVisibility(View.GONE);
                linear4.setVisibility(View.GONE);
            }
        });
        btn_thu_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear3.setVisibility(View.GONE);
            }
        });

        Txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear4.setVisibility(View.VISIBLE);
                linear1.setVisibility(View.GONE);
                linear3.setVisibility(View.GONE);
                linear2.setVisibility(View.GONE);
            }
        });
        btn_thu_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear4.setVisibility(View.GONE);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_food.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}