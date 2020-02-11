package com.example.worldclock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateFragment extends Fragment {
    private static final String KEY_COUNTRY = "COUNTRY";
    private static final String KEY_DATE_AND_TIME = "DATE&TIME";
    private TextView textViewCountry;
    private TextView textViewDateAndTime;


    static DateFragment newInstance(String country, String date) {
        Bundle args = new Bundle();
        DateFragment fragment = new DateFragment();
        args.putString(KEY_COUNTRY, country);
        args.putString(KEY_DATE_AND_TIME, date);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date_fragment, container, false);
        textViewCountry = view.findViewById(R.id.country);
        textViewDateAndTime = view.findViewById(R.id.date);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        updateTime();
        if (bundle != null) {
            textViewCountry.setText(bundle.getString(KEY_COUNTRY));
        }
    }

    private String getToday(TimeZone timeZone) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/\nHH/mm/ss", Locale.getDefault());
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }

    void updateTime() {
        Bundle bundle = getArguments();
        TimeZone tzn;
        String time;
        if (bundle != null) {
            tzn = TimeZone.getTimeZone(bundle.getString(KEY_DATE_AND_TIME));
            time = getToday(tzn);
            textViewDateAndTime.setText(time);
        }
    }
}
