package com.example.worldclock;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import static android.content.ContentValues.TAG;


public class AlaskaFragment extends Fragment {
    private static final String YEAR = "YEAR";
    private static final String MONTH = "YEAR";
    private static final String DATE = "YEAR";

    static AlaskaFragment newInstance(int y, int m, int d) {

        Bundle args = new Bundle();
        args.putInt(YEAR, y);
        args.putInt(MONTH, m);
        args.putInt(DATE, d);
        AlaskaFragment fragment = new AlaskaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            return inflater.inflate(R.layout.alaska_fragment, container, false);
        } catch (Exception e) {
            Log.e(TAG, "onCreateView", e);
            throw e;
        }
    }
}
