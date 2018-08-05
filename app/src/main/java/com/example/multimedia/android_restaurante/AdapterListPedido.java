package com.example.multimedia.android_restaurante;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterListPedido extends RecyclerView.Adapter<AdapterListPedido.AdapterHolderPedido>
    implements View.OnClickListener{

    private Context objContext;
    private ArrayList<DatosPedido> arrayDatosPedido;

    //Creo el escuchador del adapter
    private View.OnClickListener listener;

    public AdapterListPedido(Context objContext, ArrayList<DatosPedido> arrayDatosPedido) {
        this.objContext = objContext;
        this.arrayDatosPedido = arrayDatosPedido;
    }

    @NonNull
    @Override
    public AdapterListPedido.AdapterHolderPedido onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vista = LayoutInflater.from(objContext).inflate(R.layout.item_list_pedido, null, false);

        //Asigno a la vista el escuchador del evento
        vista.setOnClickListener(this);

        return new AdapterHolderPedido(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListPedido.AdapterHolderPedido objHolder, int i) {
        objHolder.viewNombre.setText(arrayDatosPedido.get(i).getNombre());
        objHolder.viewCantidad.setText(String.valueOf(arrayDatosPedido.get(i).getCantidad()));
        objHolder.viewPrecio.setText(String.valueOf(arrayDatosPedido.get(i).getPrecio()));
    }

    @Override
    public int getItemCount() {
        return arrayDatosPedido.size();
    }

    //Creamos el metodo que recibe el evento
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }
    }

    public class AdapterHolderPedido extends RecyclerView.ViewHolder {

        //Creo los objetos necesarios
        TextView viewNombre, viewCantidad, viewPrecio;

        public AdapterHolderPedido(@NonNull View itemView) {
            super(itemView);

            //Creo las referencias
            viewNombre = (TextView) itemView.findViewById(R.id.view_nombre_pedido);
            viewCantidad = (TextView) itemView.findViewById(R.id.view_cantidad_pedido);
            viewPrecio = (TextView) itemView.findViewById(R.id.view_precio_pedido);
        }
    }
}
