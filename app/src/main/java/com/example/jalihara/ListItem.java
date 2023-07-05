package com.example.jalihara;

public class ListItem {
    String eventName, eventDate, eventTime, eventPrice;
    int eventImage;

    public ListItem(String eventName, String eventDate, String eventTime, String eventPrice, int eventImage) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventPrice = eventPrice;
        this.eventImage = eventImage;
    }
}
