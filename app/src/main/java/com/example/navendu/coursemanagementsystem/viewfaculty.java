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

public class viewfaculty extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfaculty);

        sharedPreferences=getSharedPreferences("CourseManagementSystem",MODE_PRIVATE);

        // SharedPreferences sharedPreferences = getSharedPreferences("CourseManagementSystem",MODE_PRIVATE);



        Button bb=(Button)findViewById(R.id.bb);
        bb .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


TextView t1=(TextView)findViewById(R.id.t1);

                TextView t2=(TextView)findViewById(R.id.t2);

                TextView t3=(TextView)findViewById(R.id.t3);

                TextView t4=(TextView)findViewById(R.id.t4);

                TextView t5=(TextView)findViewById(R.id.t5);

                TextView t6=(TextView)findViewById(R.id.t6);

                TextView t7=(TextView)findViewById(R.id.t7);

                TextView t8=(TextView)findViewById(R.id.t8);

                TextView t9=(TextView)findViewById(R.id.t9);

                TextView t10=(TextView)findViewById(R.id.t10);



                //  getSupportFragmentManager().beginTransaction().remove(fragmentA).commit();

                EditText e=(EditText) findViewById(R.id.ff1);

                if (TextUtils.isEmpty(e.getText())) {
                    e.setError("Empty");
                    return;

                }
                String retrievedValue = sharedPreferences.getString("faculty","0");
                Log.i("yoyoyo",retrievedValue);

                //TextView t=(TextView) findViewById(R.id.ff4);

boolean flag=false;
                String[] ans=retrievedValue.split(";");

                for(int i=0;i<ans.length;++i)
                {String s=ans[i].split(" ")[0];
                    if(e.getText().toString().compareTo(s)==0)
                    {  // t.setText(ans[i]);

                        t1.setText(ans[0]);
                        t2.setText(ans[1]);
                        t3.setText(ans[2]);
                        t4.setText(ans[3]);
                        t5.setText(ans[4]);
                        t6.setText(ans[5]);
                        t7.setText(ans[6]);
                        t8.setText(ans[6]);
                        t9.setText(ans[6]);
                        t10.setText(ans[6]);




                        flag=true;
                        break;
                    }

                }

                if(flag==false)
                {
                    e.setError("invalid course id");
                    return;


                }

                /// t.setText(retrievedValue);



            }
        });





    }
    }

