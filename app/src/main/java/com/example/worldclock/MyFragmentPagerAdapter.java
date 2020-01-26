package com.example.worldclock;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private Fragment mCurrentFragment;
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

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (mCurrentFragment != object) {
            mCurrentFragment = (Fragment) object;
        }
        super.setPrimaryItem(container, position, object);
    }

    public Fragment getCurrentFragment() {
        return mCurrentFragment;
    }
}