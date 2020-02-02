package com.example.worldclock;

import android.os.Bundle;
import android.util.Log;
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

import static android.content.ContentValues.TAG;

public class DateFragment extends Fragment {
    private static final String COUNTRY = "COUNTRY";
    private static final String DATETIME = "DATE&TIME";
    private TextView country;
    private TextView dateTime;


    static DateFragment newInstance(String country, String date) {
        Bundle args = new Bundle();
        DateFragment fragment = new DateFragment();
        args.putString(COUNTRY, country);
        args.putString(DATETIME, date);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date_fragment, container, false);
        country = view.findViewById(R.id.country);
        dateTime = view.findViewById(R.id.date);
        try {
            return view;
        } catch (Exception e) {
            Log.e(TAG, "onCreateView", e);
            throw e;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        assert bundle != null;
        final TimeZone timeZone;
        String time;
        country.setText(bundle.getString(COUNTRY));
        timeZone = TimeZone.getTimeZone(bundle.getString(DATETIME));
        time = getToday(timeZone);
        dateTime.setText(time);
    }

    private String getToday(TimeZone timeZone) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/\nHH/mm/ss", Locale.getDefault());
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }

    void timeUpdate() {
        Bundle bundle = getArguments();
        assert bundle != null;
        final TimeZone tzn;
        String time;
        tzn = TimeZone.getTimeZone(bundle.getString(DATETIME));
        time = getToday(tzn);
        dateTime.setText(time);
    }
}
