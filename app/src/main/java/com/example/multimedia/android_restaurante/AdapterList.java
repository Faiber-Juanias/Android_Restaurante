package com.example.multimedia.android_restaurante;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdapterList extends RecyclerView.Adapter<AdapterList.HolderDatos>
    implements View.OnClickListener{

    //Creamos el Array
    private ArrayList<Datos> arrayDatos;
    private Context objContext;

    private static final String TAG = "MyActivity";

    //Para generar eventos creamos el escuchador
    private View.OnClickListener listener;

    public AdapterList(ArrayList<Datos> arrayDatos, Context objContext) {
        this.arrayDatos = arrayDatos;
        this.objContext = objContext;
    }

    @NonNull
    @Override
    public AdapterList.HolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //Inflo a item_list_platos.xml
        View view = LayoutInflater.from(objContext).inflate(R.layout.item_list_platos, null, false);

        view.setOnClickListener(this);
        //Retornamos una instancia de HolderDatos
        return new HolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterList.HolderDatos holderDatos, int i) {
        //try {
            //Asigno la informacion a los componentes
            holderDatos.objImagen.setImageResource(arrayDatos.get(i).getImagen());
            holderDatos.objNombrePlato.setText(arrayDatos.get(i).getNombre());
            holderDatos.objPrecioPlato.setText(String.valueOf(arrayDatos.get(i).getPrecio()));
        //}catch (Exception e){
            //Log.e(TAG, e.getMessage());
        //}
    }

    @Override
    public int getItemCount() {
        return arrayDatos.size();
    }

    //Creamos el metodo que se encarga de escuchar el evento
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class HolderDatos extends RecyclerView.ViewHolder {

        //Creamos las referencias de item_list_platos
        ImageView objImagen;
        TextView objNombrePlato;
        TextView objPrecioPlato;

        public HolderDatos(@NonNull View itemView) {
            super(itemView);

            objImagen = (ImageView) itemView.findViewById(R.id.img_list_view);
            objNombrePlato = (TextView) itemView.findViewById(R.id.view_nombre_plato);
            objPrecioPlato = (TextView) itemView.findViewById(R.id.view_precio_plato);
        }
    }
}
