package com.example.navendu.coursemanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import static android.content.Context.MODE_PRIVATE;


public class FragmentD extends Fragment {
    public static FragmentD newInstance(int count) {

        Bundle args = new Bundle();
        args.putInt("count",count);
        FragmentD fragment = new FragmentD();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }

        View v = inflater.inflate(R.layout.maintaincoursedetails,container,false);












        v.findViewById(R.id.f1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText e1=(EditText) getActivity().findViewById(R.id.e1);
                EditText e2=(EditText) getActivity().findViewById(R.id.e2);
                EditText e3=(EditText) getActivity().findViewById(R.id.e3);
                Spinner s=(Spinner) getActivity().findViewById(R.id.e4);
                String ss=s.getSelectedItem().toString();






                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("CourseManagementSystem",MODE_PRIVATE);
                String retrievedValue = sharedPreferences.getString("courses","0");


              retrievedValue+=e1.toString()+" "+e2.toString()+" "+e3.toString()+" "+ss+";";

              Log.i("hello",retrievedValue);
                final SharedPreferences.Editor editor = sharedPreferences.edit();




                editor.putString("couses",retrievedValue);


                editor.commit();

                e1.setText("");
                e2.setText("");
                e3.setText("");



            }
        });




        v.findViewById(R.id.f2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText e1=(EditText) getActivity().findViewById(R.id.e1);





                SharedPreferences sharedPreferences = getActivity().getPreferences(MODE_PRIVATE);

                String retrievedValue = sharedPreferences.getString("courses","0");

                String ret="";
                if(retrievedValue!=null) {
                    String[] ans = retrievedValue.split(";");

                    if (ans != null) {

                        for(int i=0;i<ans.length;++i)
                        {
                            if(ans[i].split(" ")[0].compareTo(e1.getText().toString())==0)
                            {


                            }
                            else
                            {
                                ret+=ans[i];
                                ret+=";";

                            }

                        }

                    }

                }

                final SharedPreferences.Editor editor = sharedPreferences.edit();




                editor.putString("couses",ret);

                editor.apply();
                editor.commit();

            }
        });






        v.findViewById(R.id.f3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText e1=(EditText) getActivity().findViewById(R.id.e1);

                Intent i=new Intent(getActivity(),viewcourse.class);
                startActivity(i);





            }
        });

























        //  ((TextView)v.findViewById(R.id.countA)).setText(""+getArguments().getInt("count"));
        return v;
    }
}
