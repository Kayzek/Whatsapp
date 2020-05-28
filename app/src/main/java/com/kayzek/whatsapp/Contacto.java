package com.kayzek.whatsapp;

public class Contacto {
    //Declaracion de Variables
    private String Contacto;
    private String Hora;
    //---------------------------
    public Contacto(String Contacto, String Hora) {
        this.Contacto = Contacto;
        this.Hora = Hora;
    }
    public String getContacto() { return Contacto; }
    public String getHora() {
        return Hora;
    }
}

