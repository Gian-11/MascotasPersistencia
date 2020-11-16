package com.gian.mascotasfinal;

import android.content.ContentValues;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.gian.mascotasfinal.R;
import com.gian.mascotasfinal.database.ConstantsDB;
import com.gian.mascotasfinal.database.Database;
import com.gian.mascotasfinal.pojo.Mascottas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class PetsConstructor {

    private static final int LIKE = 1;
    private Context context;
    private ArrayList<Mascottas> pets;


    public PetsConstructor(Context context) {
        this.context = context;
    }

    public ArrayList<Mascottas> getPetsData() {
        Database db = new Database(context);
        pets = db.getAllPets();

        if (pets.size() == 0) {
            insertPets(db);
            return db.getAllPets();

        } else {
            return pets;
        }

    }

    public void insertPets(Database db) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantsDB.TABLE_PETS_NAME, "Franklin");
        contentValues.put(ConstantsDB.TABLE_PETS_PHOTO, R.drawable.mascota1);

        db.insertPet(contentValues);

        contentValues.put(ConstantsDB.TABLE_PETS_NAME, "Fito");
        contentValues.put(ConstantsDB.TABLE_PETS_PHOTO, R.drawable.mascota2);

        db.insertPet(contentValues);


        contentValues.put(ConstantsDB.TABLE_PETS_NAME, "Pluto");
        contentValues.put(ConstantsDB.TABLE_PETS_PHOTO, R.drawable.mascota3);

        db.insertPet(contentValues);

        contentValues.put(ConstantsDB.TABLE_PETS_NAME, "Michi");
        contentValues.put(ConstantsDB.TABLE_PETS_PHOTO, R.drawable.mascota4);

        db.insertPet(contentValues);


        contentValues.put(ConstantsDB.TABLE_PETS_NAME, "Jordan");
        contentValues.put(ConstantsDB.TABLE_PETS_PHOTO, R.drawable.mascota5);

        db.insertPet(contentValues);


    }

    public void giveLike(Mascottas pet) {
        Database db = new Database(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantsDB.TABLE_PETS_LIKES_PET_ID, pet.getId());
        contentValues.put(ConstantsDB.TABLE_PETS_LIKES_COUNT, LIKE);
        db.insertLikesPet(contentValues);
    }


    public int obLikesPet(Mascottas pet) {
        Database db = new Database(context);
        return db.getLikesPet(pet);

    }


    public ArrayList<Mascottas> get5Fav () {
        Database db = new Database(context);
        pets = db.getLikedPets();
        Collections.sort(pets, new Comparator<Mascottas>() {
            @Override
            public int compare(Mascottas o1, Mascottas o2) {
                return o1.getLikes() > o2.getLikes() ? - 1 :(o1.getLikes() < o2.getLikes()) ? 1 :0;
            }
        });
        return pets;

    }

}







