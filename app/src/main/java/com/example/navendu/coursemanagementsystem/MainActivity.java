package com.example.navendu.coursemanagementsystem;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    int r = 0, b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front);


        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        String retrievedValue = sharedPreferences.getString("login", "0");

        // textView.setText(retrievedValue);

        final SharedPreferences.Editor editor = sharedPreferences.edit();


        final FragmentA fragmentA = new FragmentA();
        final FragmentB fragmentB = new FragmentB();


        Button red = (Button) findViewById(R.id.redButton);
        Button blue = (Button) findViewById(R.id.blueButton);
        Button green = (Button) findViewById(R.id.greenButton);
        Button pink = (Button) findViewById(R.id.pinkButton);
        Button b1 = (Button) findViewById(R.id.Button1);
        Button b2 = (Button) findViewById(R.id.Button2);

        Button b3 = (Button) findViewById(R.id.Button3);

        Button b4 = (Button) findViewById(R.id.Button4);


        final FragmentManager fragmentManager = getSupportFragmentManager();

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r++;


                LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
                ll.setVisibility(View.INVISIBLE);



                LinearLayout ll2 = (LinearLayout) findViewById(R.id.ll2);
                ll2.setVisibility(View.INVISIBLE);
                //getSupportFragmentManager().beginTransaction().remove(fragmentB).commit();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.container, FragmentB.newInstance(r));
                transaction.commit();
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  getSupportFragmentManager().beginTransaction().remove(fragmentA).commit();
                b++;
                LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
                ll.setVisibility(View.INVISIBLE);

                LinearLayout ll2 = (LinearLayout) findViewById(R.id.ll2);
                ll2.setVisibility(View.INVISIBLE);
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.container, FragmentA.newInstance(b));
                transaction.commit();
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  getSupportFragmentManager().beginTransaction().remove(fragmentA).commit();
                b++;
                LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
                ll.setVisibility(View.INVISIBLE);

                LinearLayout ll2 = (LinearLayout) findViewById(R.id.ll2);
                ll2.setVisibility(View.INVISIBLE);
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.container, FragmentD.newInstance(b));
                transaction.commit();
            }
        });


        pink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r++;
                //getSupportFragmentManager().beginTransaction().remove(fragmentB).commit();

                LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
                ll.setVisibility(View.INVISIBLE);
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.ll2);
                ll2.setVisibility(View.INVISIBLE);
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.container, mmarks.newInstance(r));
                transaction.commit();
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r++;
                //getSupportFragmentManager().beginTransaction().remove(fragmentB).commit();
                LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
                ll.setVisibility(View.INVISIBLE);
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.ll2);
                ll2.setVisibility(View.INVISIBLE);

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.container, mattendance.newInstance(r));
                transaction.commit();
            }
        });
/*
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r++;
                //getSupportFragmentManager().beginTransaction().remove(fragmentB).commit();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.container,upload.newInstance(r));
                transaction.commit();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r++;
                //getSupportFragmentManager().beginTransaction().remove(fragmentB).commit();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.container,download.newInstance(r));
                transaction.commit();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r++;
                //getSupportFragmentManager().beginTransaction().remove(fragmentB).commit();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.container,forum.newInstance(r));
                transaction.commit();
            }
        });










*/


    }

    private void clearBackStack() {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main2, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        //respond to menu item selection
        switch (item.getItemId()) {
            case R.id.settings:
                LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
                ll.setVisibility(View.VISIBLE);
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.ll2);
                ll2.setVisibility(View.VISIBLE);


                return true;
        }

return false;
    }
}