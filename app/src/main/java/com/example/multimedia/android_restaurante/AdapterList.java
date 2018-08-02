package com.example.multimedia.android_restaurante;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        Datos objDatos = (Datos) getItem(i);

        //Inflo la vista
        View vista = view;
        LayoutInflater objInflater = LayoutInflater.from(objContext);
        vista = objInflater.inflate(R.layout.item_list, null);

        //Creo las referencias
        ImageView objImagen = (ImageView) vista.findViewById(R.id.img_list_view);
        TextView objViewNombre = (TextView) vista.findViewById(R.id.view_nombre_plato);
        TextView objViewPrecio = (TextView) vista.findViewById(R.id.view_precio_plato);

        //Asigno los datos a los componentes
        objImagen.setImageResource(objDatos.getImagen());
        objViewNombre.setText(objDatos.getNombre());
        objViewPrecio.setText(objDatos.getPrecio());

        return view;
    }
}
