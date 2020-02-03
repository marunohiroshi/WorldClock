package com.example.worldclock;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import static com.example.worldclock.DateFragment.newInstance;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {


    MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //メソッドでそのインデックスに応じたフラグメントを返す。
    @Override
    public Fragment getItem(int i) {
        String country;
        String date;

        switch (i) {
            case 0:
                country = "日本";
                date = "Asia/Tokyo";
                return newInstance(country, date);
            case 1:
                country = "インド";
                date = "Asia/Kolkata";
                return newInstance(country, date);
            default:
                country = "アラスカ";
                date = "US/Alaska";
                return newInstance(country, date);
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


}