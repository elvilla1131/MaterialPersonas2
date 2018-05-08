package com.holamundo.materialpersonas;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearPersonas extends AppCompatActivity {
    private EditText txtCedula;
    private EditText txtNombre;
    private EditText txtApellido;
    private Spinner cmbSexo;
    private ArrayAdapter<String> adapter;
    private String opc[];
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_personas);


        txtCedula = findViewById(R.id.txtCedula);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        cmbSexo = findViewById(R.id.cmbSexo);

        opc = this.getResources().getStringArray(R.array.sexo);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
        cmbSexo.setAdapter(adapter);

        fotos = new ArrayList<Integer>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);

    }

    public void  guardar (View v){
        String ced,nomb,apelli;
        int sexo,foto;

        foto = Datos.fotoAleatoria(fotos);
        ced = txtCedula.getText().toString();
        nomb = txtNombre.getText().toString();
        apelli = txtApellido.getText().toString();
        sexo = cmbSexo.getSelectedItemPosition();


        Persona p = new Persona (foto,ced,nomb,apelli,sexo);
        p.guardar();

        Snackbar.make(v, getResources().getString(R.string.Mensaje_guardado_exitoso), Snackbar.LENGTH_LONG).setAction("Action", null).show();



    }

    public void limpiar (View v){
        limpiar();
    }


    public void limpiar(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        cmbSexo.setSelection(0);
        txtCedula.requestFocus();


    }

    public void onBackPressed(){
        finish();
        Intent i = new  Intent(CrearPersonas.this,Principal.class);
        startActivity(i);
    }


}
