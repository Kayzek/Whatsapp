package com.kayzek.whatsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class llamadas extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_llamadas, container, false);

        GridLayoutManager lmGrid = new GridLayoutManager(getContext(),2);
        RecyclerView llamadasRecycler = (RecyclerView) view.findViewById(R.id.rvllamadas);
        llamadasRecycler.setLayoutManager(lmGrid);
        llamadasRecycler.setHasFixedSize(true);

        ContactoAdapter contactoAdapterRecyclerView = new ContactoAdapter(cargarllamadas(), R.layout.cardview_llamadas, getActivity());
        llamadasRecycler.setAdapter(contactoAdapterRecyclerView);
        return view;
    }

    public ArrayList<Contacto> cargarllamadas(){

        ArrayList<Contacto> llamadas = new ArrayList<>();
        llamadas.add(new Contacto("Glenda Barrios Aguirre", "12:00"));
        llamadas.add(new Contacto("María Esther Medrano", "16:00"));
        llamadas.add(new Contacto("Lorenzo Daniel Quinto", "23:00"));
        llamadas.add(new Contacto("Jason Antonio Espinales", "08:00"));
        llamadas.add(new Contacto("Jefferson Josué Mejía", "09:00"));
        llamadas.add(new Contacto("Robin Alexander Silva", "12:00"));
        llamadas.add(new Contacto("Juan Ramón Centeno Ríos", "13:00"));
        llamadas.add(new Contacto("Isaac Ignacio Dávila", "17:00"));
        llamadas.add(new Contacto("Glenda Barrios Aguirre", "12:00"));
        llamadas.add(new Contacto("María Esther Medrano", "16:00"));
        llamadas.add(new Contacto("Lorenzo Daniel Quinto", "23:00"));
        llamadas.add(new Contacto("Jason Antonio Espinales", "08:00"));
        llamadas.add(new Contacto("Jefferson Josué Mejía", "09:00"));
        llamadas.add(new Contacto("Robin Alexander Silva", "12:00"));
        llamadas.add(new Contacto("Juan Ramón Centeno Ríos", "13:00"));
        llamadas.add(new Contacto("Isaac Ignacio Dávila", "17:00"));
        return llamadas;
    }
}

