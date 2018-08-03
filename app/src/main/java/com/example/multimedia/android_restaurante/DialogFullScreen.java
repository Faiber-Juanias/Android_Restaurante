package com.example.multimedia.android_restaurante;

import android.app.Dialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.multimedia.android_restaurante.db.Constantes;
import com.example.multimedia.android_restaurante.db.OpenHelper;

public class DialogFullScreen extends DialogFragment{

    private TextView objTitulo;
    private ImageView objImagen;
    private TextView objPrecio;
    private TextView objDesc;
    private EditText objCantidad;
    private Button btnPedido;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.dialog_full_screen, container, false);

        //Creo las referencias
        objTitulo = (TextView) vista.findViewById(R.id.view_titulo);
        objImagen = (ImageView) vista.findViewById(R.id.imagen_desc);
        objPrecio = (TextView) vista.findViewById(R.id.view_precio_desc);
        objDesc = (TextView) vista.findViewById(R.id.view_desc);

        objCantidad = (EditText) vista.findViewById(R.id.cantidad_pedido);
        btnPedido = (Button) vista.findViewById(R.id.btn_agrega_pedido);
        
        //Verifico si llegan datos del Bundle
        if (getArguments() != null){
            //Almaceno el dato de la imagen
            final String imagen = String.valueOf(getArguments().getInt("imagen"));

            //Creamos la conexion
            SQLiteDatabase objDb = conecta();

            /**
             * Hacemos una consulta para traer los datos de la tabla Platos, de acuerdo al numero de imagen seleccionado de la lista
             */
            String[] campos = new String[]{Constantes.NOMBRE_TBL_PLATOS, Constantes.DESC_TBL_PLATOS, Constantes.PRECIO_TBL_PLATOS};
            String[] args = new String[]{imagen};
            Cursor objCursor = objDb.query(Constantes.TBL_PLATOS, campos, "" + Constantes.IMAGEN_TBL_PLATOS + " = ?", args, null, null, null);
            //Verifico si hay registros
            if (objCursor.moveToFirst()){
                do {
                   objTitulo.setText(objCursor.getString(0));
                   objImagen.setImageResource(getArguments().getInt("imagen"));
                   objDesc.setText(objCursor.getString(1));
                   String precio = "$ " + objCursor.getString(2);
                   objPrecio.setText(precio);
                }while (objCursor.moveToNext());
            }else {
                Toast.makeText(getContext(), "Ningun registro.", Toast.LENGTH_SHORT).show();
            }
        }

        //Definimos el evento para el boton del pedido
        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Rescato el valor del campo de cantidad
                int cantidad = Integer.parseInt(objCantidad.getText().toString());

                //Creamos la conexion
                SQLiteDatabase objDb = conecta();

                //Hacemos la consulta
                String[] campos = new String[]{Constantes.ID_TBL_PLATOS};
                String[] args = new String[]{String.valueOf(getArguments().getInt("imagen"))};
                Cursor objCursor = objDb.query(Constantes.TBL_PLATOS, campos, "" + Constantes.IMAGEN_TBL_PLATOS + " = ?", args, null, null, null);
                int idPlatos = 0;
                if (objCursor.moveToFirst()){
                    do {
                        idPlatos = objCursor.getInt(0);
                    }while (objCursor.moveToNext());
                }

                ContentValues objContent = new ContentValues();
                objContent.put(Constantes.ID_TBL_PLATOS_TBL_PEDIDO, idPlatos);
                objContent.put(Constantes.CANTIDAD_TBL_PEDIDO, cantidad);
                
                long n = objDb.insert(Constantes.TBL_PEDIDO, null, objContent);
                if (n != 0){
                    Toast.makeText(getContext(), "Pedido agregado.", Toast.LENGTH_SHORT).show();
                    objCantidad.setText("");
                }
            }
        });

        return vista;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    //Metodo que devuelve la conexion a la base de datos
    public SQLiteDatabase conecta(){
        OpenHelper objConecta = new OpenHelper(getContext(), "restaurante", null, 1);
        SQLiteDatabase objDb = objConecta.getWritableDatabase();
        return objDb;
    }
}
