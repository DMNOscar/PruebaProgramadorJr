package com.example.pruebaprogramadoryapp.Modelo;

public class Usuario  {

    /*
            Objeto Usuario
     */

    private  String nombre;
    private  String apellidos;
    private  String anioNacimiento;
    private  String animalFavorito;
    private  String urlImagen;


    public Usuario(String nombre, String apellidos, String fechaNacimiento, String animalFavorito, String urlImagen) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.anioNacimiento = fechaNacimiento;
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

    public String getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(String anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
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


}
