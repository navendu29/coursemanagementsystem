package com.example.navendu.coursemanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


public class FragmentD extends Fragment {


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
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


        sharedPreferences = getActivity().getSharedPreferences("CourseManagementSystem",MODE_PRIVATE);
         editor = sharedPreferences.edit();



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


                if (TextUtils.isEmpty(e1.getText())) {
                    e1.setError("Empty");
                    return;

                }


                if (TextUtils.isEmpty(e2.getText())) {
                    e2.setError("Empty");
                    return;

                }
                if (TextUtils.isEmpty(e3.getText())) {
                    e3.setError("Empty");
                    return;

                }




                String retrievedValue = sharedPreferences.getString("courses","0");
                Log.i("yoyoyo",retrievedValue);

                // TextView t=(TextView) findViewById(R.id.ff);


                String[] ans=retrievedValue.split(";");
                boolean flag=false;
                for(int i=0;i<ans.length;++i)
                {String d=ans[i].split(" ")[0];
                    if(e1.getText().toString().compareTo(d)==0)
                    {


                        if(flag==false)
                        {
                            e1.setError("course already exists");
                            return;


                        }


                        // t.setText(ans[i]);

                        break;
                    }

                }












                retrievedValue = sharedPreferences.getString("courses","0");


              retrievedValue+=e1.getText().toString()+" "+e2.getText().toString()+" "+e3.getText().toString()+" "+ss+";";

              Log.i("hello",retrievedValue);



                editor.putString("courses",retrievedValue);


                editor.commit();

                e1.setText("");
                e2.setText("");
                e3.setText("");

                Toast.makeText(getContext(),"course added",Toast.LENGTH_SHORT).show();




            }
        });




        v.findViewById(R.id.f2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText e1=(EditText) getActivity().findViewById(R.id.e1);

                if (TextUtils.isEmpty(e1.getText())) {
                    e1.setError("empty");
                    return;

                }

               // SharedPreferences sharedPreferences = getActivity().getPreferences(MODE_PRIVATE);

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




                editor.putString("courses",ret);

                editor.apply();
                editor.commit();


                Toast.makeText(getContext(),"course deleted",Toast.LENGTH_SHORT).show();

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
