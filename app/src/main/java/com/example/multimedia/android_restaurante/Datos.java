package com.example.multimedia.android_restaurante;

public class Datos {

    private int imagen;
    private String nombre;
    private int precio;

    public Datos(int imagen, String nombre, int precio) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
