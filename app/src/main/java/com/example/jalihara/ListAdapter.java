package com.example.jalihara;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ListItem> {
    public ListAdapter(@NonNull Context context, ArrayList<ListItem> dataArrayList) {
        super(context, R.layout.items, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ListItem listItem = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.items, parent, false);
        }

        RelativeLayout itemImage = view.findViewById(R.id.itemImage);
        TextView itemName = view.findViewById(R.id.itemName);
        TextView itemDate = view.findViewById(R.id.itemDate);
        TextView itemTime = view.findViewById(R.id.itemTime);
        TextView itemPrice = view.findViewById(R.id.itemPrice);

        itemImage.setBackgroundResource(listItem.eventImage);
        itemName.setText(listItem.eventName);
        itemDate.setText(listItem.eventDate);
        itemTime.setText(listItem.eventTime);
        itemPrice.setText(listItem.eventPrice);

        return view;
    }
}
