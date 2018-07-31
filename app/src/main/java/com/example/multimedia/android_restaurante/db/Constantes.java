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
            ID_TBL_PLATOS + " INTEGER AUTO_INCREMENT, " +
            NOMBRE_TBL_PLATOS + " TEXT, " +
            DESC_TBL_PLATOS + " TEXT, " +
            PRECIO_TBL_PLATOS + " INTEGER, " +
            IMAGEN_TBL_PLATOS + " TEXT)";

    //Constantes para la tabla Pedido
    public static final String TBL_PEDIDO = "Pedido";
    public static final String ID_TBL_PEDIDO = "Id";
    public static final String ID_TBL_PLATOS_TBL_PEDIDO = "Plato_id";
    public static final String CANTIDAD_TBL_PEDIDO = "Cantidad";
    public static final String CREA_TBL_PEDIDO = "CREATE TABLE " + TBL_PEDIDO + " (" +
            ID_TBL_PEDIDO + " INTEGER AUTO_INCREMENT, " +
            ID_TBL_PLATOS_TBL_PEDIDO + " INTEGER, " +
            CANTIDAD_TBL_PEDIDO + " INTEGER)";
}
