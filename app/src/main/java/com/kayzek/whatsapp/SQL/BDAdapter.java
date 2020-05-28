package com.kayzek.whatsapp.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class BDAdapter {

    //Columnas de la tabla
    static final String ROW_ID = "id";
    static final String USERNAME = "Username";
    static final String PASSWORD = "Password";
    static final String NUMBER = "Number";

    Context c;
    SQLiteDatabase db;
    BDHelper helper;

    public BDAdapter(Context c){
        this.c = c;
        helper = new BDHelper(c);
    }

    //Abrimos la BD
    public void openDB(){
        try {
            db=helper.getWritableDatabase();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Cerramos la BD
    public void closeDB(){
        try {
            helper.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Agregar Usuario
    public boolean addUsuario(String userName, String Password, String Number){
        try {
            ContentValues cv = new ContentValues();
            cv.put(BDAdapter.USERNAME, userName);
            cv.put(BDAdapter.PASSWORD, Password);
            cv.put(BDAdapter.NUMBER, Number);
            db.insert(BDHelper.TB_NAME, BDAdapter.ROW_ID, cv);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //Obtener todos los usuarios
    public Cursor getAllUsuarios(){
        Cursor c = null;
        String sql = "SELECT * FROM " + BDHelper.TB_NAME + ";";
        c = db.rawQuery(sql, null);
        return c;
    }

    //Eliminar usuario
    public long DeleteUsuario (int id){
        try {
            return db.delete(BDHelper.TB_NAME, BDAdapter.ROW_ID + " =?", new String[]{String.valueOf(id)});
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public void DeleteUsuarios(){
        try {
            String sql = "DELETE FROM " + BDHelper.TB_NAME + ";";
            db.execSQL(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Obtener usuarios
    public boolean getUsuario (String searchUsuario){
        Cursor c = null;
        boolean existe = false;

        if (searchUsuario.length() > 0){
            String sql = "SELECT * FROM " + BDHelper.TB_NAME + " WHERE " + BDAdapter.USERNAME + " LIKE '%" + searchUsuario + "%'" ;
            c =db.rawQuery(sql,null);
            if (c.getCount() > 0){
                existe = true;
            }
        }
        return existe;
    }

    //Obtener password
    public boolean getPassword (String searchPassword){
        Cursor c = null;
        boolean existe = false;

        if (searchPassword.length() > 0){
            String sql = "SELECT * FROM " + BDHelper.TB_NAME + " WHERE " + BDAdapter.PASSWORD + " LIKE '%" + searchPassword+ "%";
            c = db.rawQuery(sql,null);
            if (c.getCount() > 0){
                existe = true;
            }
        }
        return existe;
    }

}
