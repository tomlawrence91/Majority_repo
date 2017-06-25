package com.example.tom.majority;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
                //Retrieve username value as string
                EditText chooseUsername   = (EditText)findViewById(R.id.enterUsername);
                String username = chooseUsername.getText().toString();
                //Retrieve radioAvatar value as string
                RadioGroup avatars = (RadioGroup) findViewById(R.id.radioGroup1);
                String avatarChoice = ((RadioButton)findViewById(avatars.getCheckedRadioButtonId()))
                                .getText().toString();

                boolean checked = ((CheckBox) view).isChecked();

                // Check which checkbox was clicked
                switch(view.getId()) {
                    case R.id.topic1:
                        if (checked) {
                        // add topic
                            }
                        else
                        // do not add topic
                        break;
                    case R.id.topic2:
                        if (checked) {
                            // add topic
                        }
                        else
                        // do not add topic
                        break;
                    case R.id.topic3:
                        if (checked) {
                            // add topic
                        }
                        else
                        // do not add topic
                        break;
                    case R.id.topic4:
                        if (checked) {
                        // add topic
                        }
                        else
                        // do not add topic
                        break;
                    case R.id.topic5:
                        if (checked) {
                            // add topic
                        }
                        else
                        // do not add topic
                        break;
                    case R.id.topic6:
                        if (checked) {
                            // add topic
                        }
                        else
                        // do not add topic
                        break;
                    case R.id.topic7:
                        if (checked) {
                            // add topic
                        }
                        else
                        // do not add topic
                        break;
                    case R.id.topic8:
                        if (checked) {
                            // add topic
                        }
                        else
                        // do not add topic
                        break;
                    case R.id.topic9:
                        if (checked) {
                            // add topic
                        }
                        else
                        // do not add topic
                        break;
                    case R.id.topic10:
                        if (checked) {
                            // add topic
                        }
                        else
                        // do not add topic
                        break;

                }

                Log.i("Username is", username);
                Log.i("Avatar is", avatarChoice);
                //Intent i=new Intent(SignUp.this, DashboardActivity.class);
                //startActivity(i);
            }
        });


    }
}
