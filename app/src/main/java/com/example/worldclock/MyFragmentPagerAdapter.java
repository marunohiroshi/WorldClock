package com.example.worldclock;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] list = {"日本", "Asia/Tokyo", "インド", "Asia/Kolkata", "アラスカ", "US/Alaska"};

    MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //メソッドでそのインデックスに応じたフラグメントを返す。
    @Override
    public Fragment getItem(int i) {
        int a = i + i;
        int b = a + 1;

        switch (i) {
            case 0:
            case 1:
            case 2:
                MyFragmentPagerAdapter.Page page = new MyFragmentPagerAdapter.Page(list[a], list[b]);
                return DateFragment.newInstance(page.country, page.date);
        }
        return null;
    }


    //メソッドでページ数を返す。
    @Override
    public int getCount() {
        return list.length / 2;
    }

    //メソッドでそのインデックスに応じたページのタイトルを返す。
    @Override
    public CharSequence getPageTitle(int position) {
        return "ページ" + (position + 1);
    }

    private static class Page {
        private final String country;
        private final String date;

        private Page(String country, String date) {
            this.country = country;
            this.date = date;
        }
    }
}