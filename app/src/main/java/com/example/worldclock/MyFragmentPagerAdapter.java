package com.example.worldclock;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private Page[] list = {new Page("日本", "Asia/Tokyo"), new Page("インド", "Asia/Kolkata"), new Page("アラスカ", "US/Alaska")};

    MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //メソッドでそのインデックスに応じたフラグメントを返す。
    @Override
    public Fragment getItem(int i) {
        return DateFragment.newInstance(list[i].country, list[i].date);
    }


    //メソッドでページ数を返す。
    @Override
    public int getCount() {
        return list.length;
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