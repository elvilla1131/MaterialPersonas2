package com.holamundo.materialpersonas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {
    private RecyclerView lstOpciones;
    private Intent i;
    private ArrayList<Persona> personas;
    private AdaptadorPersona adapter;
    private LinearLayoutManager llm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstOpciones = findViewById(R.id.lstOpciones);
        personas = Datos.obtener();


        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AdaptadorPersona(personas);

        lstOpciones.setLayoutManager(llm);
        lstOpciones.setAdapter(adapter);
    }

    public void crearPersonas(View v){
        i = new Intent(Principal.this,CrearPersonas.class);
        startActivity(i);


        //Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
          //      .setAction("Action", null).show();
    }


}
