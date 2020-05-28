package com.kayzek.whatsapp;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kayzek.whatsapp.SQL.BDAdapter;
import com.kayzek.whatsapp.SQL.UsuarioAdapter;
import com.kayzek.whatsapp.SQL.UsuarioModel;

import java.util.ArrayList;


public class chats extends Fragment {

    static RecyclerView UsuarioRecycler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_chats, container, false);

        UsuarioRecycler = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        UsuarioRecycler.setLayoutManager(linearLayoutManager);

        UsuarioAdapter UsuarioAdapterRecyclerView = new UsuarioAdapter(CargarUsuario(), R.layout.usuario_row, getActivity());
        UsuarioRecycler.setAdapter(UsuarioAdapterRecyclerView);

        //Linea de division
        final DividerItemDecoration dividerItemDecoration = new
                DividerItemDecoration(UsuarioRecycler.getContext(),
                ((LinearLayoutManager) UsuarioRecycler.getLayoutManager()).getOrientation());
        UsuarioRecycler.addItemDecoration(dividerItemDecoration);

        Button btnLimpiarBD = (Button) view.findViewById(R.id.btnLimpiarUsuarios);
        btnLimpiarBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BDAdapter BD = new BDAdapter(getContext());
                BD.openDB();
                BD.DeleteUsuarios();
                Toast.makeText(getContext(), "La base de datos ha sido limpiada", Toast.LENGTH_SHORT).show();
                BD.closeDB();
                //Actualizamos la BD
                UsuarioAdapter UsuarioAdapterRecyclerView = new UsuarioAdapter(CargarUsuario(), R.layout.usuario_row, getActivity());
                UsuarioRecycler.setAdapter(UsuarioAdapterRecyclerView);

                //Linea de division
                DividerItemDecoration dividerItemDecoration1 = new
                        DividerItemDecoration(UsuarioRecycler.getContext(), ((LinearLayoutManager) UsuarioRecycler.getLayoutManager())
                .getOrientation());
                UsuarioRecycler.addItemDecoration(dividerItemDecoration);
            }
        });
        return view;
    }

    private ArrayList<UsuarioModel> CargarUsuario(){
        ArrayList<UsuarioModel> Usuarios = new ArrayList<>();
        BDAdapter db = new BDAdapter(getContext());
        db.openDB();

        try {
            UsuarioModel p = null;
            Cursor c = db.getAllUsuarios();

            while (c.moveToNext()){
                int id = c.getInt(0);
                String UserName = c.getString(1);
                String Password = c.getString(2);
                String Number = c.getString(1);

                p = new UsuarioModel();
                p.setId(id);
                p.setUserName(UserName.trim());
                p.setPassword(Password.trim());
                p.setNumber(Number.trim());
                Usuarios.add(p);
            }
            db.closeDB();
            return Usuarios;
        }catch (Exception e){
            Log.e("Error", e.getMessage());
            return Usuarios;
        }
    }
}
