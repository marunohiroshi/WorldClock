package com.example.worldclock;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

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
                DateFragment Japan = DateFragment.newInstance(country, date);
                return Japan;
            case 1:
                country = "インド";
                date = "Asia/Kolkata";
                DateFragment India = DateFragment.newInstance(country, date);
                return India;
            default:
                country = "アラスカ";
                date = "US/Alaska";
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

}