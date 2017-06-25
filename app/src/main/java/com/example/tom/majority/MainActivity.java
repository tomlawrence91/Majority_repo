package com.example.tom.majority;

import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

    //Method that automatically loads the Login Page
    private Handler handler;
    private Runnable delayRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        handler = new Handler();
        delayRunnable = new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        };
        handler.postDelayed(delayRunnable, 3000);

    }
}
