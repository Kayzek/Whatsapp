package com.kayzek.whatsapp.SQL;

public class UsuarioModel {
    //Variables
    String UserName;
    String Password;
    String Number;
    int id;

    public UsuarioModel (String userName, String password, String number, int id){
        this.UserName = userName;
        this.Password = password;
        this.Number = number;
        this.id = id;
    }

    public UsuarioModel(){}

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
