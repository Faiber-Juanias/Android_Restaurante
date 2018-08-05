package com.example.multimedia.android_restaurante;

public class DatosPedido {

    private int idPedido;
    private String nombre;
    private int cantidad;
    private int precio;

    public DatosPedido(int idPedido, String nombre, int cantidad, int precio) {
        this.idPedido = idPedido;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getIdPedido(){
        return idPedido;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }
}
