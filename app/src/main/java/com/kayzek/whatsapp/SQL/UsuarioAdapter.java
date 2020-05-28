package com.kayzek.whatsapp.SQL;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kayzek.whatsapp.R;

import java.util.ArrayList;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioHolder> {
    //Declaramos las variables
    ArrayList<UsuarioModel> Usuarios;
    private int resource;
    private Activity activity;

    public UsuarioAdapter (ArrayList<UsuarioModel> Usuarios, int resource, Activity activity){
        this.Usuarios = Usuarios;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public UsuarioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new UsuarioHolder(view);
    }

    @Override
    public void onBindViewHolder(final UsuarioHolder holder, int position) {
        UsuarioModel Usuario = Usuarios.get(position);
        holder.txtUserName.setText(Usuario.getUserName());
        holder.txtPassword.setText(Usuario.getPassword());
        holder.txtNumber.setText(Usuario.getNumber());
    }

    @Override
    public int getItemCount() {
        return Usuarios.size();
    }

    //Holder de la clase usuario
    public class UsuarioHolder extends RecyclerView.ViewHolder {
        //Variables
        TextView txtUserName;
        TextView txtPassword;
        TextView txtNumber;

        public UsuarioHolder (View itemView) {
            super(itemView);

            this.txtUserName = (TextView) itemView.findViewById(R.id.txtUsuario);
            this.txtPassword = (TextView) itemView.findViewById(R.id.txtPassword);
            this.txtNumber = (TextView) itemView.findViewById(R.id.txtNumber);
            }
        }
}

