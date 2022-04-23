package com.sinhvien.mycat;

import static com.sinhvien.mycat.CalendarUtils.daysInMonthArray;
import static com.sinhvien.mycat.CalendarUtils.monthYearFromDate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class  Calendar extends AppCompatActivity implements CalendarAdapter.OnItemListener {
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private LocalDate selectedDate;
    TextView txt_cal_1 , txt_cal_2 , txt_cal_3 ,txt_cal_4;
    LinearLayout linear1, linear2 , linear3 , linear4;
    ImageButton btn_img_1,  btn_img_2, btn_img_3, btn_img_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initWidgets();
        CalendarUtils.selectedDate = LocalDate.now();
        setMonthView();
        txt_cal_1 = findViewById(R.id.Txt_cal_1);
        txt_cal_2 = findViewById(R.id.Txt_cal_2);
        txt_cal_3 = findViewById(R.id.Txt_cal_3);
        txt_cal_4 = findViewById(R.id.Txt_cal_4);
        linear1 = findViewById(R.id.Linear_cal_1);
        linear2 = findViewById(R.id.Linear_cal_2);
        linear3 = findViewById(R.id.Linear_cal_3);
        linear4 = findViewById(R.id.Linear_cal_4);
        btn_img_1 = findViewById(R.id.btn_img_1);
        btn_img_2 = findViewById(R.id.btn_img_2);
        btn_img_3 = findViewById(R.id.btn_img_3);
        btn_img_4 = findViewById(R.id.btn_img_4);

        txt_cal_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear1.setVisibility(View.VISIBLE);
                linear2.setVisibility(View.GONE);
                linear3.setVisibility(View.GONE);
                linear4.setVisibility(View.GONE);
            }
        });
        btn_img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear1.setVisibility(View.GONE);
            }
        });
        txt_cal_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear2.setVisibility(View.VISIBLE);
                linear1.setVisibility(View.GONE);
                linear3.setVisibility(View.GONE);
                linear4.setVisibility(View.GONE);
            }
        });
        btn_img_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear2.setVisibility(View.GONE);
            }
        });
        txt_cal_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear3.setVisibility(View.VISIBLE);
                linear1.setVisibility(View.GONE);
                linear2.setVisibility(View.GONE);
                linear4.setVisibility(View.GONE);
            }
        });
        btn_img_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear3.setVisibility(View.GONE);
            }
        });
        txt_cal_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear4.setVisibility(View.VISIBLE);
                linear1.setVisibility(View.GONE);
                linear2.setVisibility(View.GONE);
                linear3.setVisibility(View.GONE);
            }
        });
        btn_img_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear4.setVisibility(View.GONE);
            }
        });



    }

    private void initWidgets() {
        calendarRecyclerView = findViewById(R.id.calenderRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
    }

    private void setMonthView() {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray(CalendarUtils.selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

//    private ArrayList<String> daysInMonthArray(LocalDate date) {
//        ArrayList<String> daysInMonthArray = new ArrayList<>();
//        YearMonth yearMonth = YearMonth.from(date);
//
//        int daysInMonth = yearMonth.lengthOfMonth();
//
//        LocalDate firstOfMonth = selectedDate.withDayOfMonth(1);
//        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();
//
//        for (int i = 1; i <= 42; i++) {
//            if (i <= dayOfWeek || i > daysInMonth + dayOfWeek) {
//                daysInMonthArray.add("");
//            } else {
//                daysInMonthArray.add(String.valueOf(i - dayOfWeek));
//            }
//        }
//        return daysInMonthArray;
//    }

//    private String monthYearFromDate(LocalDate date) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
//        return date.format(formatter);
//    }

    public void previousMonthAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusMonths(1);
        setMonthView();
    }

    public void nextMonthAction(View view) {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusMonths(1);
        setMonthView();
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        if(date != null)
        {
            CalendarUtils.selectedDate = date;
            setMonthView();
        }
    }

    public void weeklyAction(View view)
    {
        startActivity(new Intent(this, WeekViewActivity.class));
    }
}


