package com.example.multimedia.android_restaurante.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenHelper extends SQLiteOpenHelper {

    public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creamos la tabla Platos
        db.execSQL(Constantes.CREA_TBL_PLATOS);

        //Creamos la tabla Pedido
        db.execSQL(Constantes.CREA_TBL_PEDIDO);

        //Llenamos la tabla Platos
        llenaPlatos(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Llenamos la tabla Platos
    private void llenaPlatos(SQLiteDatabase db){
        //Listamos los datos a insertar
        ContentValues objContent = new ContentValues();
        objContent.put(Constantes.NOMBRE_TBL_PLATOS, "Sopa de mariscos");
        objContent.put(Constantes.DESC_TBL_PLATOS, "Pescado, camarón, cangrejo, calamar y pulpo en un consomé de vino blanco y ajo");
        objContent.put(Constantes.PRECIO_TBL_PLATOS, 13000);
        objContent.put(Constantes.IMAGEN_TBL_PLATOS, "1");

        //Insertamos los datos en la tabla
        db.insert(Constantes.TBL_PLATOS, null, objContent);

        //Listamos los datos a insertar
        ContentValues objContentUno = new ContentValues();
        objContentUno.put(Constantes.NOMBRE_TBL_PLATOS, "Pescado Entero Frito");
        objContentUno.put(Constantes.DESC_TBL_PLATOS, "Con arroz y vegetales");
        objContentUno.put(Constantes.PRECIO_TBL_PLATOS, 7000);
        objContentUno.put(Constantes.IMAGEN_TBL_PLATOS, "2");

        //Insertamos los datos en la tabla
        db.insert(Constantes.TBL_PLATOS, null, objContentUno);

        //Listamos los datos a insertar
        ContentValues objContentDos = new ContentValues();
        objContentDos.put(Constantes.NOMBRE_TBL_PLATOS, "Filete de Pescado");
        objContentDos.put(Constantes.DESC_TBL_PLATOS, "Empanizado o a la plancha con arroz y vegetales");
        objContentDos.put(Constantes.PRECIO_TBL_PLATOS, 8000);
        objContentDos.put(Constantes.IMAGEN_TBL_PLATOS, "3");

        //Insertamos los datos en la tabla
        db.insert(Constantes.TBL_PLATOS, null, objContentDos);

        //Listamos los datos a insertar
        ContentValues objContentTres = new ContentValues();
        objContentTres.put(Constantes.NOMBRE_TBL_PLATOS, "Atún a la Plancha");
        objContentTres.put(Constantes.DESC_TBL_PLATOS, "Afilete de atun servido con pasta japonesa, vegetales y wasabi");
        objContentTres.put(Constantes.PRECIO_TBL_PLATOS, 15000);
        objContentTres.put(Constantes.IMAGEN_TBL_PLATOS, "4");

        //Insertamos los datos en la tabla
        db.insert(Constantes.TBL_PLATOS, null, objContentTres);

        //Listamos los datos a insertar
        ContentValues objContentCuatro = new ContentValues();
        objContentCuatro.put(Constantes.NOMBRE_TBL_PLATOS, "Arroz con Pollo");
        objContentCuatro.put(Constantes.DESC_TBL_PLATOS, "Con ensalada mixta o papas fritas");
        objContentCuatro.put(Constantes.PRECIO_TBL_PLATOS, 7000);
        objContentCuatro.put(Constantes.IMAGEN_TBL_PLATOS, "5");

        //Insertamos los datos en la tabla
        db.insert(Constantes.TBL_PLATOS, null, objContentCuatro);
    }
}
