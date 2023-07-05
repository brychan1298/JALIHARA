package com.example.jalihara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int flag1 = 0;
    private int flag2 = 0;

    String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = (Button) findViewById(R.id.loginBtn);
        EditText usernameTxt = (EditText) findViewById(R.id.usernameTxt);
        EditText passwordTxt = (EditText) findViewById(R.id.passwordTxt);



        TextView usernameError = (TextView) findViewById(R.id.errorUsername);
        TextView passwordError = (TextView) findViewById(R.id.errorPassword);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slidedown);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                openTicketForm();
                if(usernameTxt.getText().toString().equals("")){
                    usernameError.setVisibility(View.VISIBLE);
                    usernameError.setText("Username must be filled!");
                    usernameError.startAnimation(slideDown);
                    flag2 = 0;
                } else if (usernameTxt.getText().length() < 6) {
                    usernameError.setVisibility(View.VISIBLE);
                    usernameError.setText("Username must be at least 6!");
                    usernameError.startAnimation(slideDown);
                    flag2 = 0;
                }else{
                    usernameError.setVisibility(View.INVISIBLE);
                    flag1 = 1;
                }

                if(passwordTxt.getText().toString().equals("")){
                    passwordError.setVisibility(View.VISIBLE);
                    passwordError.setText("Password must be filled!");
                    passwordError.startAnimation(slideDown);
                    flag2 = 0;
                } else if (passwordTxt.getText().length() < 9) {
                    passwordError.setVisibility(View.VISIBLE);
                    passwordError.setText("Password must be at least 9!");
                    passwordError.startAnimation(slideDown);
                    flag2 = 0;
                }else {
                    passwordError.setVisibility(View.INVISIBLE);
                    flag2 = 1;
                }

                if(flag1 == 1 && flag2 == 1){
                    Global global = new Global();
                    global.username = usernameTxt.getText().toString();
                    openTicketForm();
                }
            }
        });
    }

    public void openTicketForm(){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
}