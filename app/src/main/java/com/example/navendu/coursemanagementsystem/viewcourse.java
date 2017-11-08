package com.example.navendu.coursemanagementsystem;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class viewcourse extends AppCompatActivity {



    SharedPreferences sharedPreferences;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_viewcourse);


        sharedPreferences=getSharedPreferences("CourseManagementSystem",MODE_PRIVATE);

        // SharedPreferences sharedPreferences = getSharedPreferences("CourseManagementSystem",MODE_PRIVATE);



        Button bb=(Button)findViewById(R.id.bb);
        bb .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  getSupportFragmentManager().beginTransaction().remove(fragmentA).commit();

                EditText e=(EditText) findViewById(R.id.ff1);



                    if (TextUtils.isEmpty(e.getText())) {
                        e.setError("Empty");
                        return;

                    }



                TextView e1=(TextView)findViewById(R.id.e1);

                TextView e2=(TextView)findViewById(R.id.e2);

                TextView e3=(TextView)findViewById(R.id.e3);

                TextView e4=(TextView)findViewById(R.id.e4);


                String retrievedValue = sharedPreferences.getString("courses","0");
                Log.i("yoyoyo",retrievedValue);

               // TextView t=(TextView) findViewById(R.id.ff);


                String[] ans=retrievedValue.split(";");
boolean flag=false;
                for(int i=0;i<ans.length;++i)
                {String s=ans[i].split(" ")[0];
                    if(e.getText().toString().compareTo(s)==0)
                    {
                       String[] h=ans[i].split(" ");

                        e1.setText(h[0]);
                        e2.setText(h[1]);
                        e3.setText(h[2]);
                        e4.setText(h[3]);
                        flag=true;


                        // t.setText(ans[i]);

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
