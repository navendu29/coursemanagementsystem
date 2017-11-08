package com.example.navendu.coursemanagementsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by the-dagger on 19/06/17.
 */

public class FragmentB extends Fragment {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
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











        v.findViewById(R.id.b1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getActivity().getSharedPreferences("CourseManagementSystem",MODE_PRIVATE);
                editor = sharedPreferences.edit();


                EditText e1=(EditText) getActivity().findViewById(R.id.t1);
                EditText e2=(EditText) getActivity().findViewById(R.id.t2);
                EditText e4=(EditText) getActivity().findViewById(R.id.t3);
                CalendarView c1=(CalendarView) getActivity().findViewById(R.id.t4);
                CalendarView c2=(CalendarView) getActivity().findViewById(R.id.t9);

                EditText e5=(EditText) getActivity().findViewById(R.id.t5);
                EditText e6=(EditText) getActivity().findViewById(R.id.t6);
                Spinner s=(Spinner)getActivity().findViewById(R.id.t7);
                EditText e7=(EditText) getActivity().findViewById(R.id.t8);
              //  EditText e8=(EditText) getActivity().findViewById(R.id.t9);
                EditText e9=(EditText) getActivity().findViewById(R.id.t10);

  String ss=s.getSelectedItem().toString();

  String cc1=c1.toString();
  String cc2=c2.toString();






                if (TextUtils.isEmpty(e1.getText())) {
                    e1.setError("Empty");
                    return;

                }


                if (TextUtils.isEmpty(e2.getText())) {
                    e2.setError("Empty");
                    return;

                }
                if (TextUtils.isEmpty(e4.getText())) {
                    e4.setError("Empty");
                    return;

                }


                if (TextUtils.isEmpty(e5.getText())||(!e5.getText().toString().contains("@"))) {
                    e5.setError("add @");
                    return;

                }


                if (e6.getText().toString().length()!=10) {
                    e6.setError("invalid phone no");
                    return;

                }
                if (TextUtils.isEmpty(e9.getText())) {
                    e9.setError("Empty");
                    return;

                }


                if (TextUtils.isEmpty(e7.getText())) {
                    e7.setError("Empty");
                    return;

                }

















                String retrievedValue = sharedPreferences.getString("faculty","0");
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
                            e1.setError("faculty already exists");
                            return;


                        }


                        // t.setText(ans[i]);

                        break;
                    }

                }





                 retrievedValue = sharedPreferences.getString("faculty","0");


                retrievedValue+=e1.getText().toString()+" "+e2.getText().toString()+" "+e4.getText().toString()+" "+"29-10-1996"+" "+e4.getText().toString()+" "+e5.getText().toString()+" "+e6.getText().toString()+" "+ss+" "+e7.getText().toString()+" "+"9-11-2017"+" "+e9.getText().toString()+";";

                Log.i("hello",retrievedValue);



                editor.putString("faculty",retrievedValue);


                editor.commit();

                e1.setText("");
                e2.setText("");
                e4.setText("");
                e5.setText("");
                e6.setText("");
                e7.setText("");
                //e8.setText("");
                e9.setText("");
                //.setText("");
                Toast.makeText(getContext(),"faculty added",Toast.LENGTH_SHORT).show();



            }
        });




        v.findViewById(R.id.b2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText e1=(EditText) getActivity().findViewById(R.id.e1);

                if (TextUtils.isEmpty(e1.getText())) {
                    e1.setError("empty");
                    return;

                }



                // SharedPreferences sharedPreferences = getActivity().getPreferences(MODE_PRIVATE);

                String retrievedValue = sharedPreferences.getString("faculty","0");

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




                editor.putString("faculty",ret);

                //editor.apply();
                editor.commit();
                Toast.makeText(getContext(),"faculty deleted",Toast.LENGTH_SHORT).show();

            }
        });






        v.findViewById(R.id.b3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // EditText e1=(EditText) getActivity().findViewById(R.id.e1);

                Intent i=new Intent(getActivity(),viewfaculty.class);
                startActivity(i);





            }
        });

        return v;
    }
}
