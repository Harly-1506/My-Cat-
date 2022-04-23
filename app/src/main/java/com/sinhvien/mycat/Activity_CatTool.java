package com.sinhvien.mycat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity_CatTool extends AppCompatActivity {
    TextView Txt1, Txt2;
    ImageButton btn_thu_1, btn_thu_2, btn_back;
    LinearLayout linear1, linear2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_tool);
        Txt1 = findViewById(R.id.Txt_vac_1);
        Txt2 = findViewById(R.id.Txt_vac_2);

        btn_thu_1 = findViewById(R.id.btn_vac_1);
        btn_thu_2 = findViewById(R.id.btn_vac_2);
        btn_back = findViewById(R.id.img_back_infocat2);

        linear1 = findViewById(R.id.linear_vac_1);
        linear2 = findViewById(R.id.linear_vac_2);

        Txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linear2.setVisibility(View.INVISIBLE);
                linear1.setVisibility(View.VISIBLE);
            }
        });
        btn_thu_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear1.setVisibility(View.GONE);
            }
        });

        Txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                linear2.setVisibility(View.VISIBLE);
                linear1.setVisibility(View.GONE);
            }
        });

        btn_thu_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear2.setVisibility(View.INVISIBLE);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_CatTool.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}