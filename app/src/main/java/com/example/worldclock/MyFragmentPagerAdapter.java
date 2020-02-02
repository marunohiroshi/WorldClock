package com.example.worldclock;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private static Fragment mCurrentFragment;

    MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    static Fragment getCurrentFragment() {
        return mCurrentFragment;
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
                return DateFragment.newInstance(country, date);
            case 1:
                country = "インド";
                date = "Asia/Kolkata";
                return DateFragment.newInstance(country, date);
            default:
                country = "アラスカ";
                date = "US/Alaska";
                return DateFragment.newInstance(country, date);
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

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        if (mCurrentFragment != object) {
            mCurrentFragment = (Fragment) object;
        }
        super.setPrimaryItem(container, position, object);
    }
}