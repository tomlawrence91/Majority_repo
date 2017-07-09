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
                    Intent intent = new Intent(this, ActivityForItemOne.class);
                    this.startActivity(intent);
                    break;
                case R.id.navcreate:
                    Intent intent = new Intent(this, ActivityForItemOne.class);
                    this.startActivity(intent);
                    break;
                case R.id.navsearch:
                    Intent intent = new Intent(this, ActivityForItemOne.class);
                    this.startActivity(intent);
                    break;
                case R.id.navprofile:
                    Intent intent = new Intent(this, ActivityForItemOne.class);
                    this.startActivity(intent);
                    break;
                case R.id.navextra:
                    Intent intent = new Intent(this, ActivityForItemOne.class);
                    this.startActivity(intent);
                    break;
                default:
                    return super.onOptionsItemSelected(item);
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
