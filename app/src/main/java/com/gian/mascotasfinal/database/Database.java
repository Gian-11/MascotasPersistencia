package com.gian.mascotasfinal.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.gian.mascotasfinal.pojo.Mascottas;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private Context context;


    public Database(@Nullable Context context) {
        super(context, ConstantsDB.DATABASE_NAME, null, ConstantsDB.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCreateTABLE_PETS = "CREATE TABLE " +
                ConstantsDB.TABLE_PETS + "(" +
                ConstantsDB.TABLE_PETS_ID + " INTEGER PRIMARY KEY, " +
                ConstantsDB.TABLE_PETS_PHOTO + " INTEGER, " +
                ConstantsDB.TABLE_PETS_NAME + " TEXT" + ")";

        String queryCreateTABLE_PETS_LIKES = "CREATE TABLE " +
                ConstantsDB.TABLE_PETS_LIKES + "(" +
                ConstantsDB.TABLE_PETS_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantsDB.TABLE_PETS_LIKES_PET_ID + " INTEGER, " +
                ConstantsDB.TABLE_PETS_LIKES_COUNT + " INTEGER, " +
                "FOREIGN KEY (" + ConstantsDB.TABLE_PETS_LIKES_PET_ID + ") " +
                "REFERENCES " + ConstantsDB.TABLE_PETS + "(" + ConstantsDB.TABLE_PETS_ID + ")" +
                ")";

        db.execSQL(queryCreateTABLE_PETS);
        db.execSQL(queryCreateTABLE_PETS_LIKES);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.TABLE_PETS_LIKES);
        onCreate(db);
    }

    public ArrayList<Mascottas> getAllPets() {
        ArrayList<Mascottas> ARpets = new ArrayList<>();


        String query = "SELECT * FROM " + ConstantsDB.TABLE_PETS;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);


        while (cursor.moveToNext()) {
            Mascottas pet = new Mascottas();
            pet.setId(cursor.getInt(0));
            pet.setFoto(cursor.getInt(1));
            pet.setNombre(cursor.getString(2));


            String queryLikes =
                    "SELECT COUNT(" + ConstantsDB.TABLE_PETS_LIKES_COUNT + ") as likes " +
                            " FROM " + ConstantsDB.TABLE_PETS_LIKES +
                            " WHERE " +
                            ConstantsDB.TABLE_PETS_LIKES_PET_ID + "=" + pet.getId();


            Cursor cursor1 = db.rawQuery(queryLikes, null);

            if (cursor1.moveToNext()) {
                pet.setLikes(cursor1.getInt(0));
            } else {
                pet.setLikes(0);
            }

            ARpets.add(pet);
        }

        db.close();


        return ARpets;
    }


    public void insertPet(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantsDB.TABLE_PETS, null, contentValues);
        db.close();
    }


    public void insertLikesPet(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantsDB.TABLE_PETS_LIKES, null, contentValues);
        db.close();
    }


    public int getLikesPet(Mascottas pet) {
        int likes = 0;

        String query =
                "SELECT COUNT(" + ConstantsDB.TABLE_PETS_LIKES_COUNT + ")" +
                        " FROM " +
                        ConstantsDB.TABLE_PETS_LIKES + " WHERE " + ConstantsDB.TABLE_PETS_LIKES_PET_ID +
                        "=" + pet.getId();



        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToNext()) {
            likes = cursor.getInt(0);

        }

        db.close();

        return likes;
    }

    public ArrayList<Mascottas> getLikedPets() {

        ArrayList<Mascottas> pets = new ArrayList<Mascottas>();

        String query = "SELECT * FROM " + ConstantsDB.TABLE_PETS_LIKES + " INNER JOIN " + ConstantsDB.TABLE_PETS +
                " ORDER BY " + ConstantsDB.TABLE_PETS_LIKES_COUNT + " DESC LIMIT 5";




        SQLiteDatabase db = this.getWritableDatabase();

        Database database = new Database(context);

        Cursor cursor = db.rawQuery(query, null);



        while (cursor.moveToNext()) {
            Mascottas pet = new Mascottas();
            pet.setId(cursor.getInt(cursor.getColumnIndex(ConstantsDB.TABLE_PETS_ID)));
            pet.setNombre(cursor.getString(cursor.getColumnIndex(ConstantsDB.TABLE_PETS_NAME)));
            pet.setFoto(cursor.getInt(cursor.getColumnIndex(ConstantsDB.TABLE_PETS_PHOTO)));
            pet.setLikes(database.getLikesPet(pet));
            pets.add(pet);

        }

        db.close();
        return pets;

    }


}