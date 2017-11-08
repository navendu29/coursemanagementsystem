package com.example.navendu.coursemanagementsystem;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class viewmarks extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmarks);
        sharedPreferences=getSharedPreferences("CourseManagementSystem",MODE_PRIVATE);

        // SharedPreferences sharedPreferences = getSharedPreferences("CourseManagementSystem",MODE_PRIVATE);



        Button bb=(Button)findViewById(R.id.bb);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  getSupportFragmentManager().beginTransaction().remove(fragmentA).commit();


                Spinner s1=(Spinner)findViewById(R.id.s1);
                Spinner s2=(Spinner)findViewById(R.id.s2);
                Spinner s3=(Spinner)findViewById(R.id.s3);
                Spinner s4=(Spinner)findViewById(R.id.s4);
                Spinner s5=(Spinner)findViewById(R.id.s5);
TextView m1=(TextView)findViewById(R.id.m1);
                TextView m2=(TextView)findViewById(R.id.m2);
                TextView m3=(TextView)findViewById(R.id.m3);
                TextView m4=(TextView)findViewById(R.id.m4);
                TextView m5=(TextView)findViewById(R.id.m5);



                EditText e=(EditText) findViewById(R.id.ff1);
                if (TextUtils.isEmpty(e.getText())) {
                    e.setError("Empty");
                    return;

                }

                String retrievedValue = sharedPreferences.getString("marks","0");
                Log.i("yoyoyo",retrievedValue);

                TextView t=(TextView) findViewById(R.id.ff4);


                String[] ans=retrievedValue.split(";");
boolean flag=false;
                for(int i=0;i<ans.length;++i)
                {String s=ans[i].split(" ")[0];
                    Log.i("nav",s);

                    if(e.getText().toString().compareTo(s)==0)
                    {  // t.setText(ans[i]);

                        String[] g=ans[i].split(" ");
flag=true;
                        m1.setText(g[2]);
                        s1.setSelection(0);
                        s2.setSelection(1);
                        s3.setSelection(2);
                        s4.setSelection(3);
                        s5.setSelection(4);

                        m2.setText(g[4]);
                        m3.setText(g[6]);
                        m4.setText(g[8]);
                        m5.setText(g[10]);




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
