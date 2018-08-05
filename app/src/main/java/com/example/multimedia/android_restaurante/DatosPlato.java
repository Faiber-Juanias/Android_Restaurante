package com.example.multimedia.android_restaurante;

public class DatosPlato {

    private int imagen;
    private String nombre;
    private int precio;

    public DatosPlato(int imagen, String nombre, int precio) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }
}
