package com.example.worldclock;

import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //メソッドでそのインデックスに応じたフラグメントを返す。
    @Override
    public Fragment getItem(int i) {
        String country;
        String date;
        TimeZone tzn;
        switch (i) {
            case 0:
                country = "日本";
                tzn = TimeZone.getTimeZone("Asia/Tokyo");
                date = getToday(tzn);
                DateFragment Japan = DateFragment.newInstance(country, date);
                return Japan;
            case 1:
                country = "インド";
                tzn = TimeZone.getTimeZone("Asia/Kolkata");
                date = getToday(tzn);
                DateFragment India = DateFragment.newInstance(country, date);
                return India;
            default:
                country = "アラスカ";
                tzn = TimeZone.getTimeZone("US/Alaska");
                date = getToday(tzn);
                DateFragment Alaska = DateFragment.newInstance(country, date);
                return Alaska;
        }
    }

    //メソッドでページ数を返す。
    @Override
    public int getCount() {
        return 3;
    }

    //メソッドでそのインデックスに応じたページのタイトルを返す。
    @Override
    public CharSequence getPageTitle(int position) {
        return "ページ" + (position + 1);
    }

    private String getToday(TimeZone tzn) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/\nHH/mm/ss", Locale.getDefault());
        simpleDateFormat.setTimeZone(tzn);
        return simpleDateFormat.format(date);
    }
}