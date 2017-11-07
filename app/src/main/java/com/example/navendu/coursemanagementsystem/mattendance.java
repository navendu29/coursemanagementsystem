package com.example.navendu.coursemanagementsystem;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class mattendance extends Fragment {
    public static mattendance newInstance(int count) {

        Bundle args = new Bundle();
        args.putInt("count",count);
        mattendance fragment = new mattendance();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }

        View v = inflater.inflate(R.layout.maintainattendance,container,false);
        //  ((TextView)v.findViewById(R.id.countA)).setText(""+getArguments().getInt("count"));
        return v;
    }
}
