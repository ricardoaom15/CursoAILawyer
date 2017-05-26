package com.raikersoft.lawyer.model;

/**
 * Created by RicardoAndrés on 26/05/2017.
 */

public class Constant {

    public static final String DATABASE_NAME = "lawyer.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "lawyer";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_SPECIALITY = "speciality";
    public static final String COLUMN_BIOGRAPHY = "biography";

    public static final String CREATE_TABLE_LAWYER = "CREATE TABLE "+TABLE_NAME+" (" +
            COLUMN_ID + " VARCHAR PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " VARCHAR, " +
            COLUMN_PHONE + " VARCHAR, " +
            COLUMN_SPECIALITY + " VARCHAR, " +
            COLUMN_BIOGRAPHY + " VARCHAR)";

}

