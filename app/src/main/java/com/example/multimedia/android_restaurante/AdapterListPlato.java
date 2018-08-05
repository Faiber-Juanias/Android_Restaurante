package com.example.multimedia.android_restaurante;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterListPlato extends RecyclerView.Adapter<AdapterListPlato.HolderDatos>
    implements View.OnClickListener{

    //Creamos el Array
    private ArrayList<DatosPlato> arrayDatos;
    private Context objContext;

    private static final String TAG = "MyActivity";

    //Para generar eventos creamos el escuchador
    private View.OnClickListener listener;

    public AdapterListPlato(ArrayList<DatosPlato> arrayDatos, Context objContext) {
        this.arrayDatos = arrayDatos;
        this.objContext = objContext;
    }

    @NonNull
    @Override
    public AdapterListPlato.HolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //Inflo a item_list_platoxml
        View view = LayoutInflater.from(objContext).inflate(R.layout.item_list_plato, null, false);

        view.setOnClickListener(this);
        //Retornamos una instancia de HolderDatos
        return new HolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListPlato.HolderDatos holderDatos, int i) {
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

        //Creamos las referencias de item_list_plato
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
