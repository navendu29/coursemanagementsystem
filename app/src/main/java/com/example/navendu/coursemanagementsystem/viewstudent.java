package com.example.navendu.coursemanagementsystem;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class viewstudent extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstudent);
        sharedPreferences=getSharedPreferences("CourseManagementSystem",MODE_PRIVATE);

        // SharedPreferences sharedPreferences = getSharedPreferences("CourseManagementSystem",MODE_PRIVATE);



        Button bb=(Button)findViewById(R.id.bb);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  getSupportFragmentManager().beginTransaction().remove(fragmentA).commit();

                EditText e=(EditText) findViewById(R.id.ff1);

                if (TextUtils.isEmpty(e.getText())) {
                    e.setError("Empty");
                    return;

                }
                String retrievedValue = sharedPreferences.getString("student","0");
                Log.i("yoyoyo",retrievedValue);

                TextView t=(TextView) findViewById(R.id.ff4);

boolean flag=false;
                String[] ans=retrievedValue.split(";");

                for(int i=0;i<ans.length;++i)
                {String s=ans[i].split(" ")[0];
                    Log.i("nav",s);

                    if(e.getText().toString().compareTo(s)==0)
                    {   t.setText(ans[i]);
flag=true;
                        break;
                    }

                }
                if(flag==false)
                {
                    e.setError("invalid student id");
                    return;


                }

                /// t.setText(retrievedValue);



            }
        });





    }


    }

