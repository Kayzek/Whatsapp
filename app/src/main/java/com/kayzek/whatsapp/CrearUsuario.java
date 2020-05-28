package com.kayzek.whatsapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kayzek.whatsapp.SQL.BDAdapter;

public class CrearUsuario extends AppCompatActivity {
    //Variables
    EditText txtUsuario;
    EditText txtPassword;
    EditText txtNumber;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.CrearUsuario));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Enlazamos a la interfaz
        txtUsuario = (EditText) findViewById(R.id.editext_user);
        txtPassword = (EditText) findViewById(R.id.editext_password);
        txtNumber = (EditText) findViewById(R.id.editext_number);
    }

    //llamadas al adapter para agregar al usuario
    public void agregarUsuario (View v){
        try {
            String strUsuario = txtUsuario.getText().toString().trim();
            String strPassword = txtPassword.getText().toString().trim();
            String strNumber = txtNumber.getText().toString().trim();

            if(strUsuario.isEmpty() || strPassword.isEmpty()){
                Toast.makeText(this,"Debe ingresar un valor valido para el Usuario y Contraseña", Toast.LENGTH_SHORT).show();
            }else {
                BDAdapter BD = new BDAdapter(this);
                BD.openDB();
                if (BD.addUsuario(strUsuario, strPassword, strNumber)){
                    Toast.makeText(this, "el usuario se ha agregado", Toast.LENGTH_SHORT).show();
                    txtUsuario.setText("");
                    txtPassword.setText("");
                    txtNumber.setText("");
                }else {
                    Toast.makeText(this, "Error al agregar usuario", Toast.LENGTH_SHORT).show();
                }
                BD.closeDB();
            }
        }catch (Exception e){
            Log.e("Error", e.getMessage());
        }
    }

    public boolean onSupportNavigateU(){
        onBackPressed();
        return true;
    }
}
