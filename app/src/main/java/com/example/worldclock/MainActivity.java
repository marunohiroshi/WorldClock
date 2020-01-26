package com.example.worldclock;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;


public class MainActivity extends FragmentActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        MyFragmentPagerAdapter PA = new MyFragmentPagerAdapter(getSupportFragmentManager());

        ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                DateFragment fragment = new DateFragment();
                fragmentTransaction.replace(R.id.date_fragment,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                FragmentManager manager = getSupportFragmentManager();
                int count = manager.getBackStackEntryCount();
                if (0 < count) {
                    FragmentManager.BackStackEntry entry = manager.getBackStackEntryAt(count -1);
                    Fragment fragment = manager.findFragmentByTag(entry.getName());
                }
            }
        };
        viewPager.addOnPageChangeListener(listener);
        viewPager.setAdapter(PA);
    }
}

