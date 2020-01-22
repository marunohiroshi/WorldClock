package com.example.worldclock;

import android.widget.TextView;

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
        switch (i) {
            case 0:
                return DateFragment.newInstance();
            case 1:
                DateFragment India = new DateFragment();
                return India;
            default:
                DateFragment Alaska = new DateFragment();
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