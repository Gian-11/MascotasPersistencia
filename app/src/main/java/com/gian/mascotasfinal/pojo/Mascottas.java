package com.gian.mascotasfinal.pojo;

public class Mascottas {
    private int id;
    private String nombre;
    private int foto;
    private int likes;

    public Mascottas(String nombre, int foto, int rating) {
        this.nombre = nombre;
        this.foto = foto;
        this.likes = rating;
    }

    public Mascottas() {
    }


    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
