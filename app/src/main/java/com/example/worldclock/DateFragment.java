package com.example.worldclock;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.content.ContentValues.TAG;

public class DateFragment extends Fragment {
    private static final String COUNTRY = "KEY_RED";
    private static final String DATE = "KEY_RED";

    static DateFragment newInstance(TextView country, TextView date) {
        Bundle args = new Bundle();
        DateFragment fragment = new DateFragment();
        args.putString(COUNTRY, country);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.date_fragment, container, false);
        TextView country = v.findViewById(R.id.country);
        TextView Date = v.findViewById(R.id.Date);
        setCountry(country);

        try {
            return v;
        } catch (Exception e) {
            Log.e(TAG, "onCreateView", e);
            throw e;
        }
    }

    private String getToday() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/\nHH/mm/ss", Locale.getDefault());
        return sdf.format(date);
    }

    @Override
    public void onStart() {
        super.onStart();

//        setCountry(country);
        String s = getToday();
        Date.setText(s);
    }

    private void setCountry(TextView textView) {
        //何でその国と判断する？
        if (textView == ) {
            textView.setText("日本");
        } else if (){

        }
    }

    private TextView setDate(TextView textView) {

    }
}
