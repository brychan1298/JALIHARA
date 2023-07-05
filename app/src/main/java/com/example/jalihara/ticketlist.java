package com.example.jalihara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.jalihara.databinding.ActivityHomeBinding;
import com.example.jalihara.databinding.ActivityTicketlistBinding;

import java.util.ArrayList;

public class ticketlist extends AppCompatActivity {

    ActivityTicketlistBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListItem> dataArrayList = new ArrayList<>();
    ListItem listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ticketlist);
        binding = ActivityTicketlistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();
        String username = intent.getStringExtra("username");


        int[] imageList = {R.drawable.ticket1, R.drawable.ticket2, R.drawable.ticket3, R.drawable.ticket4, R.drawable.ticket5};
        String[] nameList = {"INDO IN TECHNO", "KING OF GUITAR", "JOHN DOE", "SWIFTIES", "DRUM ROLL"};
        String[] dateList = {"22-Feb-23", "12-Sept-23", "20-July-23", "02-Oct-23", "02-June-23"};
        String[] timeList = {"10:30 AM", "09:00 AM", "12:45 PM", "07:00 PM", "10:00 AM"};
        String[] priceList = {"$6.50", "$10.00", "$12.05", "$4.75", "$10.00"};

        for(int i = 0; i < imageList.length; i++){
            listItem = new ListItem(nameList[i], dateList[i], timeList[i], priceList[i], imageList[i]);
            dataArrayList.add(listItem);
        }

        listAdapter = new ListAdapter(ticketlist.this, dataArrayList);
        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ticketlist.this, ticketform.class);
                intent.putExtra("username",username);
                intent.putExtra("eventName", nameList[i]);
                intent.putExtra("eventDate", dateList[i]);
                intent.putExtra("eventTime", timeList[i]);
                intent.putExtra("eventPrice", priceList[i]);
                intent.putExtra("eventImage", imageList[i]);
                startActivity(intent);
            }
        });
    }

}