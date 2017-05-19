package com.example.mavl.mvpproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class ListViewBaseAdapter<T> extends BaseAdapter {
    public Context mContext;
    public List<T> list;
    public LayoutInflater mInflater;

    public ListViewBaseAdapter(Context context, List<T> list) {
        this.list = list;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list != null && !list.isEmpty() ? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    public abstract View createView(int position, View convertView, ViewGroup parent);
}
