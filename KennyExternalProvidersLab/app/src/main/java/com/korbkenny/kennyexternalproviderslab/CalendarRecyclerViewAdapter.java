package com.korbkenny.kennyexternalproviderslab;

import android.database.Cursor;
import android.provider.BaseColumns;
import android.provider.CalendarContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KorbBookProReturns on 11/28/16.
 */

public class CalendarRecyclerViewAdapter extends RecyclerView.Adapter<CalendarViewHolder> {
    private List<Event> mEventList;

    public CalendarRecyclerViewAdapter(List<Event> eventList) {
        mEventList = eventList;
    }

    @Override
    public CalendarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new CalendarViewHolder(inflater.inflate(android.R.layout.simple_list_item_1,parent,false));
    }

    @Override
    public void onBindViewHolder(CalendarViewHolder holder, int position) {
        holder.mName.setText(mEventList.get(position).getName());
        holder.mDate.setText(mEventList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return mEventList.size();
    }

    public void swapData(Cursor cursor) {
        mEventList.clear();

        if(cursor != null && cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                String name = cursor.getString(cursor.getColumnIndex(CalendarContract.Events.TITLE));
                String date = cursor.getString(cursor.getColumnIndex(CalendarContract.Events.RDATE));
                mEventList.add(new Event(name,date));
                cursor.moveToNext();
            }
        }
        notifyDataSetChanged();
    }


}
