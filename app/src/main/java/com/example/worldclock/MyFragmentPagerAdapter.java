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
        switch (i) {
            case 0:
                return new JapanFragment();
            case 1:
                return new IndiaFragment();
            default:
                return new AlaskaFragment();
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