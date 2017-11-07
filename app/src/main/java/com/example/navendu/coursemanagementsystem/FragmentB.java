package com.example.navendu.coursemanagementsystem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by the-dagger on 19/06/17.
 */

public class FragmentB extends Fragment {

    public static FragmentB newInstance(int count) {

        Bundle args = new Bundle();
        args.putInt("count",count);
        FragmentB fragment = new FragmentB();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }

        View v = inflater.inflate(R.layout.maintainfacultydetails,container,false);

        //Bundle b = getArguments();
        //int count = b.getInt("count");
      //  TextView textView = (TextView) v.findViewById(R.id.countB);
       // textView.setText(""+count);
        return v;
    }
}
