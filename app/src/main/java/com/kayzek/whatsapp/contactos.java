package com.kayzek.whatsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class contactos extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contactos, container, false);

        RecyclerView contactosRecycler = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        contactosRecycler.setLayoutManager(linearLayoutManager);
        ContactoAdapter contactoAdapterRecyclerView = new ContactoAdapter(CargarContactos(), R.layout.contacto_row, getActivity());
        contactosRecycler.setAdapter(contactoAdapterRecyclerView);

        //Agregar linea de división
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(contactosRecycler.getContext(),
                ((LinearLayoutManager) contactosRecycler.getLayoutManager()).getOrientation());
        contactosRecycler.addItemDecoration(dividerItemDecoration);
        return view;
    }

    public ArrayList<Contacto> CargarContactos(){

        ArrayList<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto("Glenda Barrios Aguirre", "12:00"));
        contactos.add(new Contacto("María Esther Medrano", "16:00"));
        contactos.add(new Contacto("Lorenzo Daniel Quinto", "23:00"));
        contactos.add(new Contacto("Jason Antonio Espinales", "08:00"));
        contactos.add(new Contacto("Jefferson Josué Mejía", "09:00"));
        contactos.add(new Contacto("Robin Alexander Silva", "12:00"));
        contactos.add(new Contacto("Juan Ramón Centeno Ríos", "13:00"));
        contactos.add(new Contacto("Isaac Ignacio Dávila", "17:00"));
        return contactos;
    }
}


