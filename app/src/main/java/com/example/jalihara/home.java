package com.example.jalihara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
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
        String[] nameList = {"INDO IN TECHNO", "KING OF GUITAR", "JOHN DOE"};
        String[] dateList = {"22-Feb-23", "12-Sept-23", "20-July-23"};
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

        TextView seeMorebtn = (TextView) findViewById(R.id.seeMoreBtn);

        seeMorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTicketList();
            }
        });
    }
    public void openTicketList(){
        Intent intent = new Intent(this, ticketlist.class);
        startActivity(intent);
    }
}