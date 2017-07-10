package com.example.tom.majority;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Projectprofile extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navhome:
                    Intent homeIntent = new Intent(Projectprofile.this,Projectprofile.class);
                    startActivityForResult(homeIntent, 0);
                    break;
                case R.id.navcreate:
                    Intent navIntent = new Intent(Projectprofile.this,CreateProjectActivity.class);
                    startActivityForResult(navIntent, 0);
                    break;
                case R.id.navsearch:
                    Intent searchIntent = new Intent(Projectprofile.this,SearchActivity.class);
                    startActivityForResult(searchIntent, 0);
                    break;
                case R.id.navprofile:
                    Intent profileIntent = new Intent(Projectprofile.this,Userprofile.class);
                    startActivityForResult(profileIntent, 0);
                    break;
                case R.id.navextra:
                    Intent contactIntent = new Intent(Projectprofile.this,ContactActivity.class);
                    startActivityForResult(contactIntent, 0);
                    break;
            }

            return true;
            }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectprofile);




    }

}
