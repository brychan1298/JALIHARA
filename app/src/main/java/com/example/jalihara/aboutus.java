package com.example.jalihara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class aboutus extends AppCompatActivity {
    private TabLayout myTabLayout;
    private ViewPager2 myViewPager2;

    private myFragmentAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

//        WindowCompat.setDecorFitsSystemWindows(getWindow(),false);

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
    }
}