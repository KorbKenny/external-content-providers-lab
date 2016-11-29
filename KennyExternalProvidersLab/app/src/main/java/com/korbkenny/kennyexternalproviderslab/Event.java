package com.korbkenny.kennyexternalproviderslab;

/**
 * Created by KorbBookProReturns on 11/28/16.
 */
public class Event {

    String mName;
    String mDate;

    public Event(String name, String date) {
        mName = name;
        mDate = date;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }
}
