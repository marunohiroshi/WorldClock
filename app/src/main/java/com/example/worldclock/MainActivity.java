package com.example.worldclock;

import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.Calendar;

public class MainActivity extends FragmentActivity {
    ViewPager viewPager;
    public TextView japanDate;
    public TextView indiaDate;
    public TextView alaskaDate;
    TextView a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        japanDate = findViewById(R.id.JapanDate);
        indiaDate = findViewById(R.id.IndiaDate);
        alaskaDate = findViewById(R.id.AlaskaDate);
        viewPager = findViewById(R.id.viewPager);
        Calendar rightNow = Calendar.getInstance();
        int year = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH) + 1;
        int date = rightNow.get(Calendar.DATE);
        AlaskaFragment AF = AlaskaFragment.newInstance(year, month, date);

        viewPager.setAdapter(
                new MyFragmentPagerAdapter(
                        getSupportFragmentManager()
                )
        );
    }

}

