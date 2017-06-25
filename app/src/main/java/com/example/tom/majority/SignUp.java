package com.example.tom.majority;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button mEmailSignInButton = (Button) findViewById(R.id.profileUpdate);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                EditText mEdit   = (EditText)findViewById(R.id.enterUsername);
                RadioGroup avatarChoice = (RadioGroup) findViewById(R.id.radioGroup1);


                //Intent i=new Intent(SignUp.this, DashboardActivity.class);
                //startActivity(i);
            }
        });


    }
}
