package com.example.multimedia.android_restaurante.db;

public class Constantes {
    //Constantes para la tabla Platos
    public static final String TBL_PLATOS = "Platos";
    public static final String ID_TBL_PLATOS = "Id";
    public static final String NOMBRE_TBL_PLATOS = "Nombre";
    public static final String DESC_TBL_PLATOS = "Descripcion";
    public static final String PRECIO_TBL_PLATOS = "Precio";
    public static final String IMAGEN_TBL_PLATOS = "Imagen";
    public static final String CREA_TBL_PLATOS = "CREATE TABLE " + TBL_PLATOS + " (" +
            ID_TBL_PLATOS + " INTEGER PRIMARY KEY, " +
            NOMBRE_TBL_PLATOS + " TEXT UNIQUE, " +
            DESC_TBL_PLATOS + " TEXT, " +
            PRECIO_TBL_PLATOS + " INTEGER, " +
            IMAGEN_TBL_PLATOS + " INTEGER)";

    //Constantes para la tabla Pedido
    public static final String TBL_PEDIDO = "Pedido";
    public static final String ID_TBL_PEDIDO = "Id";
    public static final String ID_TBL_PLATOS_TBL_PEDIDO = "Plato_id";
    public static final String CANTIDAD_TBL_PEDIDO = "Cantidad";
    public static final String CREA_TBL_PEDIDO = "CREATE TABLE " + TBL_PEDIDO + " (" +
            ID_TBL_PEDIDO + " INTEGER PRIMARY KEY, " +
            ID_TBL_PLATOS_TBL_PEDIDO + " INTEGER, " +
            CANTIDAD_TBL_PEDIDO + " INTEGER, FOREIGN KEY(" + ID_TBL_PLATOS_TBL_PEDIDO + ") REFERENCES " +
            TBL_PLATOS + "(" + ID_TBL_PLATOS + "))";
}
