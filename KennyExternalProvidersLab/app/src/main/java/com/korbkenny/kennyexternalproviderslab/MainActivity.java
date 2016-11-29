package com.korbkenny.kennyexternalproviderslab;

import android.database.Cursor;
import android.provider.CalendarContract;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    RecyclerView mRecyclerView;
    CalendarRecyclerViewAdapter mAdapter;
    List<Event> mEventList = new ArrayList<>();
    public static final int EVENT_LOADER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mEventList = new ArrayList<>();
        mAdapter = new CalendarRecyclerViewAdapter(mEventList);

        mRecyclerView = (RecyclerView)findViewById(R.id.calendar_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        getSupportLoaderManager().initLoader(EVENT_LOADER,null,this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch(id){
            case EVENT_LOADER:
                return new CursorLoader(this, CalendarContract.Events.CONTENT_URI,
                        new String[]{CalendarContract.Events.TITLE,CalendarContract.Events.RDATE},null,null,null);
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapData(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapData(null);
    }
}
