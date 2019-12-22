package com.example.worldclock;

import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainActivity extends FragmentActivity {
    ViewPager viewPager;
    public TextView japanDate;
    public TextView indiaDate;
    public TextView alaskaDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        japanDate = findViewById(R.id.JapanDate);
        indiaDate = findViewById(R.id.IndiaDate);
        alaskaDate = findViewById(R.id.AlaskaDate);
        viewPager = findViewById(R.id.viewPager);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        viewPager.setAdapter(
                new MyFragmentPagerAdapter(
                        getSupportFragmentManager()
                )
        );
    }

}

