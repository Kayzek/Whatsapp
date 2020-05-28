package com.kayzek.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.kayzek.whatsapp.SQL.BDAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Llamada a la pantalla Crear Uusuario
    public void addUsuario(View view)
    {
        Intent intent = new Intent(this, CrearUsuario.class);
        startActivity(intent);
    }


    //Llamada a la pantalla principal
    public void goWhatsapp(View view)
    {
        TextInputEditText txtUsuario;
        TextInputEditText txtPassword;

        try {
            txtUsuario = (TextInputEditText) findViewById(R.id.username);
            txtPassword = (TextInputEditText) findViewById(R.id.password);
            String strUsuario = txtUsuario.getText().toString().trim();
            String strPassword = txtPassword.getText().toString().trim();
            if (strUsuario.isEmpty() || strPassword.isEmpty()){
                Toast.makeText(this, "Debe ingresar un usuario", Toast.LENGTH_SHORT).show();
            }else {
                BDAdapter BD = new BDAdapter(this);
                BD.openDB();
                if (BD.getUsuario(strUsuario)){
                    txtUsuario.setText("");
                    txtPassword.setText("");
                    Intent intent = new Intent(MainActivity.this, whatsapp.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
                    txtUsuario.setText("");
                    txtPassword.setText("");
                }
                BD.closeDB();
            }
        }catch (Exception e){
            Log.e("Error", e.getMessage());
        }
    }

}
