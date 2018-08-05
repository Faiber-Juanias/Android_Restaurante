package com.example.multimedia.android_restaurante.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.multimedia.android_restaurante.R;

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
        objContent.put(Constantes.IMAGEN_TBL_PLATOS, R.drawable.sopa_mariscos);

        //Insertamos los datos en la tabla
        db.insert(Constantes.TBL_PLATOS, null, objContent);

        //Listamos los datos a insertar
        ContentValues objContentUno = new ContentValues();
        objContentUno.put(Constantes.NOMBRE_TBL_PLATOS, "Pescado Entero Frito");
        objContentUno.put(Constantes.DESC_TBL_PLATOS, "Con arroz y vegetales");
        objContentUno.put(Constantes.PRECIO_TBL_PLATOS, 7000);
        objContentUno.put(Constantes.IMAGEN_TBL_PLATOS, R.drawable.pescado_entero);

        //Insertamos los datos en la tabla
        db.insert(Constantes.TBL_PLATOS, null, objContentUno);

        //Listamos los datos a insertar
        ContentValues objContentDos = new ContentValues();
        objContentDos.put(Constantes.NOMBRE_TBL_PLATOS, "Filete de Pescado");
        objContentDos.put(Constantes.DESC_TBL_PLATOS, "Empanizado o a la plancha con arroz y vegetales");
        objContentDos.put(Constantes.PRECIO_TBL_PLATOS, 8000);
        objContentDos.put(Constantes.IMAGEN_TBL_PLATOS, R.drawable.filete_pescado);

        //Insertamos los datos en la tabla
        db.insert(Constantes.TBL_PLATOS, null, objContentDos);

        //Listamos los datos a insertar
        ContentValues objContentTres = new ContentValues();
        objContentTres.put(Constantes.NOMBRE_TBL_PLATOS, "Atún a la Plancha");
        objContentTres.put(Constantes.DESC_TBL_PLATOS, "Afilete de atun servido con pasta japonesa, vegetales y wasabi");
        objContentTres.put(Constantes.PRECIO_TBL_PLATOS, 15000);
        objContentTres.put(Constantes.IMAGEN_TBL_PLATOS, R.drawable.atun_plancha);

        //Insertamos los datos en la tabla
        db.insert(Constantes.TBL_PLATOS, null, objContentTres);

        //Listamos los datos a insertar
        ContentValues objContentCuatro = new ContentValues();
        objContentCuatro.put(Constantes.NOMBRE_TBL_PLATOS, "Arroz con Pollo");
        objContentCuatro.put(Constantes.DESC_TBL_PLATOS, "Con ensalada mixta o papas fritas");
        objContentCuatro.put(Constantes.PRECIO_TBL_PLATOS, 7000);
        objContentCuatro.put(Constantes.IMAGEN_TBL_PLATOS, R.drawable.arroz_pollo);

        //Insertamos los datos en la tabla
        db.insert(Constantes.TBL_PLATOS, null, objContentCuatro);

        //Listamos los datos a insertar
        ContentValues objContentCinco = new ContentValues();
        objContentCinco.put(Constantes.NOMBRE_TBL_PLATOS, "Caldo de costilla");
        objContentCinco.put(Constantes.DESC_TBL_PLATOS, "Con silantro, papa");
        objContentCinco.put(Constantes.PRECIO_TBL_PLATOS, 4500);
        objContentCinco.put(Constantes.IMAGEN_TBL_PLATOS, R.drawable.caldo_costilla);

        //Insertamos los datos en la tabla
        db.insert(Constantes.TBL_PLATOS, null, objContentCinco);

        //Listamos los datos a insertar
        ContentValues objContentSeis = new ContentValues();
        objContentSeis.put(Constantes.NOMBRE_TBL_PLATOS, "Mojarra frita");
        objContentSeis.put(Constantes.DESC_TBL_PLATOS, "Con arroz, petacon y ensalada");
        objContentSeis.put(Constantes.PRECIO_TBL_PLATOS, 8000);
        objContentSeis.put(Constantes.IMAGEN_TBL_PLATOS, R.drawable.mojarra_frita);

        //Insertamos los datos en la tabla
        db.insert(Constantes.TBL_PLATOS, null, objContentSeis);
    }
}
