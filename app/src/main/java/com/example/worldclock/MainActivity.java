package com.example.worldclock;

import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends FragmentActivity {
    ViewPager viewPager;
    public TextView japanDate;
    public TextView indiaDate;
    public TextView alaskaDate;
    public  TextView dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        japanDate = findViewById(R.id.JapanDate);
        indiaDate = findViewById(R.id.IndiaDate);
        alaskaDate = findViewById(R.id.AlaskaDate);
        viewPager = findViewById(R.id.viewPager);

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        japanDate.setText(sdf.format(date));

        viewPager.setAdapter(
                new MyFragmentPagerAdapter(
                        getSupportFragmentManager()
                )
        );
    }

    public static String getNowDate(){
        final DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        final Date date = new Date(System.currentTimeMillis());
        return df.format(date);
    }
}

