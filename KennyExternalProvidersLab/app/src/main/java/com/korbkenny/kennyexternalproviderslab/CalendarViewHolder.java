package com.korbkenny.kennyexternalproviderslab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by KorbBookProReturns on 11/28/16.
 */

public class CalendarViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        TextView mDate;

        public CalendarViewHolder(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(android.R.id.text1);
            mDate = (TextView) itemView.findViewById(android.R.id.text2);
        }
    }
