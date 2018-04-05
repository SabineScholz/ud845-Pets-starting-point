package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PetsDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = PetsDbHelper.class.getSimpleName();

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shelter.db";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PetContract.PetEntry.TABLE_NAME;

    private static final String SQL_CREATE_PETS_TABLE =
            "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + " (" +
                    PetContract.PetEntry._ID + "  INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PetContract.PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, " +
                    PetContract.PetEntry.COLUMN_PET_BREED + " TEXT ," +
                    PetContract.PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, " +
                    PetContract.PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";


    public PetsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
