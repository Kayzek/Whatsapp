package com.kayzek.whatsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>{

    //Declaracion de Variables
    private ArrayList<Contacto> Contactos;
    private int resource;
    private Activity activity;
    //---------------------------//

    public ContactoAdapter(ArrayList<Contacto> Contactos, int resource, Activity activity){
        this.Contactos = Contactos;
        this.resource = resource;
        this.activity=activity;
    }
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new ContactoViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto Contacto = Contactos.get(position);
        holder.ContactoName.setText(Contacto.getContacto());
        holder.ContactoHora.setText(Contacto.getHora());
    }
    @Override
    public int getItemCount() {
        return Contactos.size();
    }
    public class ContactoViewHolder extends RecyclerView.ViewHolder{

        private TextView ContactoName;
        private TextView ContactoHora;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            ContactoName = (TextView) itemView.findViewById(R.id.txtContacto);
            ContactoHora = (TextView) itemView.findViewById(R.id.txthora);
        }
    }
}

