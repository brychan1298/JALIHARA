package com.example.jalihara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class aboutus extends AppCompatActivity {
    private TabLayout myTabLayout;
    private ViewPager2 myViewPager2;

    private myFragmentAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        TextView usernameLbl = findViewById(R.id.usernameLbl);
        usernameLbl.setText(Global.username);

        myTabLayout = findViewById(R.id.tabLayout);
        myViewPager2 = findViewById(R.id.viewPager2);

        myTabLayout.addTab(myTabLayout.newTab().setText("About Us"));
        myTabLayout.addTab(myTabLayout.newTab().setText("Contact Us"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        myAdapter = new myFragmentAdapter(fragmentManager , getLifecycle());
        myViewPager2.setAdapter(myAdapter);

        myTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                myViewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        myViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                myTabLayout.selectTab(myTabLayout.getTabAt(position));
            }
        });

        ImageView menuBtn = findViewById(R.id.menuBtn);
        LinearLayout menu = findViewById(R.id.menu);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (menu.getVisibility() == View.INVISIBLE) {
                    Animation slideDownAnimation = AnimationUtils.loadAnimation(aboutus.this, R.anim.menuslidedown);
                    menu.startAnimation(slideDownAnimation);
                    menu.setVisibility(View.VISIBLE);

                    ViewPager2 aboutUsBody = findViewById(R.id.viewPager2);
                    aboutUsBody.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Animation slideUpAnimation = AnimationUtils.loadAnimation(aboutus.this, R.anim.menuslideup);
                            menu.startAnimation(slideUpAnimation);
                            menu.setVisibility(View.INVISIBLE);
                        }
                    });

                    Toolbar aboutUsBody2 = findViewById(R.id.toolbar);
                    aboutUsBody2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Animation slideUpAnimation = AnimationUtils.loadAnimation(aboutus.this, R.anim.menuslideup);
                            menu.startAnimation(slideUpAnimation);
                            menu.setVisibility(View.INVISIBLE);
                        }
                    });

//                    LinearLayout ticketListBody2 = findViewById(R.id.bodyContactUsFragment);
//                    ticketListBody2.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Animation slideUpAnimation = AnimationUtils.loadAnimation(aboutus.this, R.anim.menuslideup);
//                            menu.startAnimation(slideUpAnimation);
//                            menu.setVisibility(View.INVISIBLE);
//                        }
//                    });
                } else {
                    Animation slideUpAnimation = AnimationUtils.loadAnimation(aboutus.this, R.anim.menuslideup);
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