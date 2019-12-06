package com.example.pruebaprogramadoryapp.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {

    /*
            Objeto Usuario
     */

    private  String nombre;
    private  String apellidos;
    private  String fechaNacimiento;
    private  String animalFavorito;
    private  String urlImagen;


    public Usuario(String nombre, String apellidos, String fechaNacimiento, String animalFavorito, String urlImagen) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.animalFavorito = animalFavorito;
        this.urlImagen = urlImagen;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getAnimalFavorito() {
        return animalFavorito;
    }

    public void setAnimalFavorito(String animalFavorito) {
        this.animalFavorito = animalFavorito;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(nombre);
        parcel.writeString(apellidos);
        parcel.writeString(fechaNacimiento);
        parcel.writeString(animalFavorito);
        parcel.writeString(urlImagen);

    }
}
