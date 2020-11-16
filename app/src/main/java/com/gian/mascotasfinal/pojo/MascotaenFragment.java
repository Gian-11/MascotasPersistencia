package com.gian.mascotasfinal.pojo;

public class MascotaenFragment {
    private int foto;
    private int rating;


    public MascotaenFragment(int foto, int rating) {
        this.foto = foto;
        this.rating = rating;
    }


    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
