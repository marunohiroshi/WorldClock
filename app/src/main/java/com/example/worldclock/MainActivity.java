package com.example.worldclock;

import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;


public class MainActivity extends FragmentActivity {
    ViewPager viewPager;
    TextView country;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        country = findViewById(R.id.country);
        date = findViewById(R.id.Date);
        DateFragment Japan = DateFragment.newInstance(country, date);
        DateFragment India = DateFragment.newInstance(country, date);
        DateFragment Alaska = DateFragment.newInstance(country, date);
        MyFragmentPagerAdapter PA = new MyFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(PA);
    }
}

