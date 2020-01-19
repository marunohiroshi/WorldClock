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

import static android.content.ContentValues.TAG;

public class JapanFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            return inflater.inflate(R.layout.japan_fragment, container, false);
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
        TextView japanDate = getView().findViewById(R.id.Japan_Date);
        String s = getToday();
        japanDate.setText(s);
    }
}
