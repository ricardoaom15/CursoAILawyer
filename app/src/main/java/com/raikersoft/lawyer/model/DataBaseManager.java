package com.raikersoft.lawyer.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by RicardoAndrés on 27/05/2017.
 */

public class DataBaseManager {

    SQLiteDatabase sqLiteDatabase;
    DataBaseHelper dataBaseHelper;

    public DataBaseManager(Context context){
        dataBaseHelper = new DataBaseHelper(context);
    }

    private void openWritableDatabase(){
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
    }

    private void openReadableDatabase(){
        sqLiteDatabase = dataBaseHelper.getReadableDatabase();
    }

    private void closeDatabase(){
        if(sqLiteDatabase!=null){
            sqLiteDatabase.close();
        }
    }

    public boolean insertLawyer(Lawyer lawyer){
        openWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.COLUMN_NAME, lawyer.getName());
        contentValues.put(Constant.COLUMN_PHONE, lawyer.getPhone());
        contentValues.put(Constant.COLUMN_SPECIALITY, lawyer.getSpeciality());
        contentValues.put(Constant.COLUMN_BIOGRAPHY, lawyer.getBiography());
        long id = sqLiteDatabase.insert(Constant.TABLE_NAME, null, contentValues);
        closeDatabase();
        if(id>0){
            lawyer.setId(id);
            return true;
        }else{
            return false;
        }
    }

}
