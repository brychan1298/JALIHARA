package com.example.jalihara;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jalihara.databinding.ActivityTicketformBinding;

public class ticketform extends AppCompatActivity {

    ActivityTicketformBinding binding;
    private boolean isMenuOpen = false;
    private int menuContainerWidth = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ticketform);
        binding = ActivityTicketformBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView usernameLbl = findViewById(R.id.usernameLbl);
        usernameLbl.setText(Global.username);
//
        Intent intent = this.getIntent();
        if(intent != null){

            String eventName = intent.getStringExtra("eventName");
            String eventDate = intent.getStringExtra("eventDate");
            String eventTime = intent.getStringExtra("eventTime");
            String eventPrice = intent.getStringExtra("eventPrice");

            binding.eventNameLbl.setText(eventName);
            binding.eventDateLbl.setText(eventDate);
            binding.eventTimeLbl.setText(eventTime);
            binding.eventPriceLbl.setText(eventPrice);
        }
        String username = intent.getStringExtra("username");

        // VALIDATION PROCESS
        EditText customerTxt = (EditText) findViewById(R.id.customerTxt);
        EditText qtyTxt = (EditText) findViewById(R.id.qtyTxt);
        RadioButton VIPRadio = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton regularRadio = (RadioButton) findViewById(R.id.radioButton2);
        LinearLayout buyBtn = (LinearLayout) findViewById(R.id.buyBtn);
        TextView errorMsg = (TextView) findViewById(R.id.errorMsg);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slidedown);
        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(customerTxt.getText().toString().equals("")){
                    errorMsg.setVisibility(View.VISIBLE);
                    errorMsg.setText("Please Fill Customer Name!!");
                    errorMsg.startAnimation(slideDown);
                } else if (qtyTxt.getText().toString().equals("")) {
                    errorMsg.setVisibility(View.VISIBLE);
                    errorMsg.setText("Please Fill Quantity!!");
                    errorMsg.startAnimation(slideDown);
                } else if (qtyTxt.getText().toString().equals("0")){
                    errorMsg.setVisibility(View.VISIBLE);
                    errorMsg.setText("Quantity Must be More than 0!!");
                    errorMsg.startAnimation(slideDown);
                } else if (VIPRadio.isChecked() == false && regularRadio.isChecked() == false){
                    errorMsg.setVisibility(View.VISIBLE);
                    errorMsg.setText("Please Choose Booth Type");
                    errorMsg.startAnimation(slideDown);
                }
                else{
                    backToHome();
                }
            }
        });

        LinearLayout backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTicketList();
            }
        });


        ImageView menuBtn = findViewById(R.id.menuBtn);
        LinearLayout menu = findViewById(R.id.menu);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (menu.getVisibility() == View.INVISIBLE) {
                    Animation slideDownAnimation = AnimationUtils.loadAnimation(ticketform.this, R.anim.menuslidedown);
                    menu.startAnimation(slideDownAnimation);
                    menu.setVisibility(View.VISIBLE);
                } else {
                    Animation slideUpAnimation = AnimationUtils.loadAnimation(ticketform.this, R.anim.menuslideup);
                    menu.startAnimation(slideUpAnimation);
                    menu.setVisibility(View.INVISIBLE);
                }
            }
        });

        LinearLayout homeMenu = findViewById(R.id.homeMenu);
        LinearLayout ticketMenu = findViewById(R.id.ticketMenu);
        LinearLayout aboutusMenu = findViewById(R.id.aboutusMenu);
        LinearLayout logoutMenu = findViewById(R.id.logoutMenu);

        homeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });

        ticketMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTicketList();
            }
        });

        aboutusMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAboutUs();
            }
        });

        logoutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }
    public void backToHome(){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }

    public void openHome(){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }

    public void openTicketList(){
        Intent intent = new Intent(this, ticketlist.class);
        startActivity(intent);
    }

    public void openAboutUs(){
        Intent intent = new Intent(this, aboutus.class);
        startActivity(intent);
    }

    public void logout(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}