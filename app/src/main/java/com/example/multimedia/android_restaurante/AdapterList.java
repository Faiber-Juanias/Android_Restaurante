package com.example.multimedia.android_restaurante;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class AdapterList extends BaseAdapter{

    Context objContext;
    ArrayList<Datos> objList;

    public AdapterList(Context objContext, ArrayList<Datos> objList) {
        this.objContext = objContext;
        this.objList = objList;
    }

    @Override
    public int getCount() {
        return objList.size();
    }

    @Override
    public Object getItem(int i) {
        return objList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Inflo la vista
        View vista = view;
        LayoutInflater objInflater = LayoutInflater.from(objContext);
        vista = objInflater.inflate(R.layout.item_list, null);



        return view;
    }
}
