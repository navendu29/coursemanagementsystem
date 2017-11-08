package com.example.navendu.coursemanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


/**

 */
public class mmarks extends Fragment {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static mmarks newInstance(int count) {

        Bundle args = new Bundle();
        args.putInt("count",count);
        mmarks fragment = new mmarks();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {




        sharedPreferences = getActivity().getSharedPreferences("CourseManagementSystem",MODE_PRIVATE);
        editor = sharedPreferences.edit();


        if (container != null) {
            container.removeAllViews();
        }

        View v = inflater.inflate(R.layout.maintainmarks,container,false);
        //  ((TextView)v.findViewById(R.id.countA)).setText(""+getArguments().getInt("count"));




        v.findViewById(R.id.b1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText e1=(EditText) getActivity().findViewById(R.id.e1);

                Spinner e2=(Spinner)getActivity().findViewById(R.id.e2);
                EditText e3=(EditText) getActivity().findViewById(R.id.e3);

                Spinner e4=(Spinner)getActivity().findViewById(R.id.e4);
                EditText e5=(EditText) getActivity().findViewById(R.id.e5);
                Spinner e6=(Spinner)getActivity().findViewById(R.id.e6);
                EditText e7=(EditText) getActivity().findViewById(R.id.e7);
                Spinner e8=(Spinner)getActivity().findViewById(R.id.e8);
                EditText e9=(EditText) getActivity().findViewById(R.id.e9);
                Spinner e10=(Spinner)getActivity().findViewById(R.id.e10);
                EditText e11=(EditText) getActivity().findViewById(R.id.e11);




                if (TextUtils.isEmpty(e1.getText())) {
                    e1.setError("Empty");
                    return;

                }


                if (TextUtils.isEmpty(e3.getText())) {
                    e3.setError("Empty");
                    return;

                }
                if (TextUtils.isEmpty(e5.getText())) {
                    e5.setError("Empty");
                    return;

                }



                if (TextUtils.isEmpty(e7.getText())) {
                    e7.setError("Empty");
                    return;

                }
                if (TextUtils.isEmpty(e9.getText())) {
                    e9.setError("Empty");
                    return;

                }


                if (TextUtils.isEmpty(e11.getText())) {
                    e11.setError("Empty");
                    return;

                }




                String s1=e2.getSelectedItem().toString();

                String s2=e4.getSelectedItem().toString();

                String s3=e6.getSelectedItem().toString();

                String s4=e8.getSelectedItem().toString();
                String s5=e10.getSelectedItem().toString();






                String retrievedValue = sharedPreferences.getString("marks","0");


                retrievedValue+=e1.getText().toString()+" "+s1+" "+e3.getText().toString()+" "+s2+" "+e5.getText().toString()+" "+s3+" "+e7.getText().toString()+" "+s4+" "+e9.getText().toString()+" "+s5+" "+e11.getText().toString()+";";

                Log.i("hello",retrievedValue);



                editor.putString("marks",retrievedValue);


                editor.commit();

                e1.setText("");
                e3.setText("");
                e5.setText("");
                e7.setText("");

                e9.setText("");  e11.setText("");
                Toast.makeText(getContext(),"marks added",Toast.LENGTH_SHORT).show();


            }
        });








        v.findViewById(R.id.b2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText e1=(EditText) getActivity().findViewById(R.id.e1);

                Intent i=new Intent(getActivity(),viewmarks.class);
                startActivity(i);





            }
        });

















        return v;
    }
}
