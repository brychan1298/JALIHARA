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
                backToHome();
            }
        });



//        LinearLayout menu = (LinearLayout) findViewById(R.id.menu);
//        LinearLayout menutoggle = (LinearLayout) findViewById(R.id.menutoggle);
//        menuContainerWidth = menu.getWidth();
//
//        menutoggle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                menuContainerWidth = menu.getWidth();
//                if (!isMenuOpen) {
//                    menu.setVisibility(View.VISIBLE);
//                    menu.getLayoutParams().width = 0;
//                    menu.requestLayout();
//
//                    ValueAnimator animator = ValueAnimator.ofInt(0, menuContainerWidth);
//                    animator.setDuration(500);
//                    animator.setInterpolator(new AccelerateDecelerateInterpolator());
//                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                        @Override
//                        public void onAnimationUpdate(ValueAnimator animation) {
//                            int width = (int) animation.getAnimatedValue();
//                            menu.getLayoutParams().width = width;
//                            menu.requestLayout();
//                        }
//                    });
//                    animator.start();
//
//                    isMenuOpen = true;
//                } else {
//                    Toast.makeText(ticketform.this, "Login Succesfull!!", Toast.LENGTH_SHORT).show();
//                    ValueAnimator animator = ValueAnimator.ofInt(menuContainerWidth, 0);
//                    animator.setDuration(500);
//                    animator.setInterpolator(new AccelerateDecelerateInterpolator());
//                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                        @Override
//                        public void onAnimationUpdate(ValueAnimator animation) {
//                            int width = (int) animation.getAnimatedValue();
////                            menu.getLayoutParams().width = width;
//                            menu.requestLayout();
//                        }
//                    });
//                    animator.addListener(new AnimatorListenerAdapter() {
//                        @Override
//                        public void onAnimationEnd(Animator animation) {
//                            menu.setVisibility(View.INVISIBLE);
//
//                        }
//                    });
//                    animator.start();
//                    isMenuOpen = false;
//                }



//                if (menu.getVisibility() == View.INVISIBLE) {
//                    // Menu sedang disembunyikan, animasikan slide right untuk menampilkan menu
////                    Animation slideRightAnimation = AnimationUtils.loadAnimation(ticketform.this, R.anim.menuslideright);
////                    Animation slideRightAnimation = new TranslateAnimation(-85,0,0,0);
////                    slideRightAnimation.setDuration(500);
////                    menu.startAnimation(slideRightAnimation);
////                    menu.setVisibility(View.VISIBLE);
//
//                    menu.setVisibility(View.VISIBLE);
//                    menu.getLayoutParams().width = 0;
//                    menu.requestLayout();
//
//                    // Animasikan efek memperluas lebar menu dari 0% hingga 100%
//                    ValueAnimator animator = ValueAnimator.ofInt(0, menu.getWidth());
//                    animator.setDuration(500);
//                    animator.setInterpolator(new AccelerateDecelerateInterpolator());
//                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                        @Override
//                        public void onAnimationUpdate(ValueAnimator animation) {
//                            int width = (int) animation.getAnimatedValue();
//                            menu.getLayoutParams().width = width;
//                            menu.requestLayout();
//                        }
//                    });
//                    animator.start();
//                } else {
//                    // Menu sedang ditampilkan, animasikan slide left untuk menyembunyikan menu
////                    Animation slideLeftAnimation = AnimationUtils.loadAnimation(ticketform.this, R.anim.menuslideleft);
////                    Animation slideLeftAnimation = new TranslateAnimation(15,-menu.getWidth(),0,0);
////                    slideLeftAnimation.setDuration(500);
////                    menu.startAnimation(slideLeftAnimation);
////                    menu.setVisibility(View.INVISIBLE);
//
//                    ValueAnimator animator = ValueAnimator.ofInt(menu.getWidth(), 0);
//                    animator.setDuration(500);
//                    animator.setInterpolator(new AccelerateDecelerateInterpolator());
//                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                        @Override
//                        public void onAnimationUpdate(ValueAnimator animation) {
//                            int width = (int) animation.getAnimatedValue();
//                            menu.getLayoutParams().width = width;
//                            menu.requestLayout();
//
//                            if (width == 0) {
//                                menu.setVisibility(View.INVISIBLE);
//                            }
//
//                        }
//                    });
//                    animator.start();
//                    menu.setVisibility(View.INVISIBLE);
//                }
//            }
//        });


    }
    public void backToHome(){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
}