package com.kayzek.whatsapp.SQL;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDHelper extends SQLiteOpenHelper {
    //Base de datos
    static final String DB_NAME = "WhatsappDB.db";
    static final String TB_NAME = "Usuarios";
    static final int DB_VERSION = 1;

    //Creamos la tabla
    public static final String CREATE_TB = "CREATE TABLE Usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " UserName TEXT NOT NULL, " + " Password TEXT NOT NULL, " + " Number TEXT NOT NULL);" ;

    public BDHelper (Context context){
        super(context, BDHelper.DB_NAME, null, BDHelper.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(BDHelper.CREATE_TB);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BDHelper.TB_NAME);
        onCreate(db);
    }
}
