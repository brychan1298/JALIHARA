package com.example.jalihara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.jalihara.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {

    ActivityHomeBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListItem> dataArrayList = new ArrayList<>();
    ListItem listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());

        Global global = new Global();

//        setContentView(R.layout.activity_home);
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();
//        if(intent != null){

        binding.usernameLbl.setText(global.username);
//        }

        int[] imageList = {R.drawable.ticket1, R.drawable.ticket2, R.drawable.ticket3};
        String[] nameList = {"INDO IN TECHNO", "KING OF GUITAR", "WAYANG GOLEK"};
        String[] dateList = {"22-Feb-23", "16-Sept-23", "20-Jan-23"};
        String[] timeList = {"10:30 AM", "09:00 AM", "12:45 PM"};
        String[] priceList = {"$6.50", "$10.00", "$12.05"};

        for(int i = 0; i < imageList.length; i++){
            listItem = new ListItem(nameList[i], dateList[i], timeList[i], priceList[i], imageList[i]);
            dataArrayList.add(listItem);
        }

        listAdapter = new ListAdapter(home.this, dataArrayList);
        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(home.this, ticketform.class);
                intent.putExtra("eventName", nameList[i]);
                intent.putExtra("eventDate", dateList[i]);
                intent.putExtra("eventTime", timeList[i]);
                intent.putExtra("eventPrice", priceList[i]);
                intent.putExtra("eventImage", imageList[i]);
                startActivity(intent);
            }
        });

        ListAdapter listAdapter = (ListAdapter) binding.listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(binding.listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, binding.listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = binding.listView.getLayoutParams();
        params.height = totalHeight + (binding.listView.getDividerHeight() * (listAdapter.getCount() - 1));
        binding.listView.setLayoutParams(params);
        binding.listView.requestLayout();

        TextView seeMorebtn = (TextView) findViewById(R.id.seeMoreBtn);

        seeMorebtn.setOnClickListener(new View.OnClickListener() {
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
                    Animation slideDownAnimation = AnimationUtils.loadAnimation(home.this, R.anim.menuslidedown);
                    menu.startAnimation(slideDownAnimation);
                    menu.setVisibility(View.VISIBLE);
                    RelativeLayout homeBody = findViewById(R.id.bodyHome);
                    homeBody.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Animation slideUpAnimation = AnimationUtils.loadAnimation(home.this, R.anim.menuslideup);
                            menu.startAnimation(slideUpAnimation);
                            menu.setVisibility(View.INVISIBLE);
                        }
                    });

                } else {
                    Animation slideUpAnimation = AnimationUtils.loadAnimation(home.this, R.anim.menuslideup);
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

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = (ListAdapter) listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}