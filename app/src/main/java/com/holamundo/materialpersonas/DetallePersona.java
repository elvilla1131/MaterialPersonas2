package com.holamundo.materialpersonas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePersona extends AppCompatActivity {
    private TextView txtCedulaDetalle;
    private TextView txtNombreDetalle;
    private TextView txtApellidoDetalle;
    private TextView txtSexoDetalle;
    private String[] sex;
    private ImageView fot;
    private String id,cedula, nombre,apellido;
    private int foto,sexo;
    private Intent i;
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_persona);
        txtCedulaDetalle = findViewById(R.id.txtCedulaDetalle);
        txtNombreDetalle = findViewById(R.id.txtNombreDetalle);
        txtApellidoDetalle = findViewById(R.id.txtApellidoDetalle);
        txtSexoDetalle = findViewById(R.id.txtSexoDetalle);
        fot = findViewById(R.id.foto);
        sex = getResources().getStringArray(R.array.sexo);

        i = getIntent();
        bundle = i.getBundleExtra("datos");
        id = bundle.getString("id");
        cedula = bundle.getString("cedula");
        nombre = bundle.getString("nombre");
        apellido = bundle.getString("apellido");
        sexo = bundle.getInt("sexo");
        foto = bundle.getInt("foto");


        txtCedulaDetalle.setText(cedula);
        txtNombreDetalle.setText(nombre);
        txtApellidoDetalle.setText(apellido);
        txtSexoDetalle.setText(sex[sexo]);
        fot.setImageResource(foto);
    }

    public void eliminar (View v){
        String positivo,negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.pregunta_eliminacion));
        positivo = getResources().getString(R.string.positivo);
        negativo = getResources().getString(R.string.negativo);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               Persona p = new Persona(id);
               p.eliminar();
               onBackPressed();
            }
        });
        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(DetallePersona.this,Principal.class);
        startActivity(i);
    }
}
