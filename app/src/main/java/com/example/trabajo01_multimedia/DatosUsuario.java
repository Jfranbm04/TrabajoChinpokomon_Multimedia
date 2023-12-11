package com.example.trabajo01_multimedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabajo01_multimedia.modelos.Chinpokomon;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class DatosUsuario extends AppCompatActivity {

    DatabaseReference ref;
    TextView textBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<Chinpokomon> listaChinpokomon = new ArrayList<Chinpokomon>();
        listaChinpokomon.add(new Chinpokomon("4", "Chorizo", "2", "Fantasma", "Cambiar de color", R.drawable.imagen4));
        listaChinpokomon.add(new Chinpokomon("5", "Sombrilla", "67", "Dinosaurio", "Gritar flojo", R.drawable.imagen5));
        listaChinpokomon.add(new Chinpokomon("6", "Carlos", "25", "Mexicano", "Comer guacamole", R.drawable.imagen6));
        listaChinpokomon.add(new Chinpokomon("7", "Zapato", "10", "Fuego", "Andar", R.drawable.imagen7));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new listaChinpoAdapter(getApplicationContext(),listaChinpokomon));

        textBorrar = findViewById(R.id.txtBorrar);
        String codigoBorrar = textBorrar.toString();

    }




    // Método para volver al main
    public void volver (View view){
        Intent anterior = new Intent(this, Coleccion.class);
        startActivity(anterior);

    }

    // Método para añadir chinpokomon
    public void anadir (View view){
        Intent anadir = new Intent(this, anadirChinpokomon.class);
        startActivity(anadir);

    }

    // Métodos para borrar chinpokomom
    public void borrar(View view){
        String codigoBorrar = textBorrar.toString();
        if(codigoBorrar.isEmpty()){
            Toast.makeText(this, "Escribe un código.", Toast.LENGTH_SHORT).show();
        }else{
            borrarChinpokomon(codigoBorrar);
        }

    }
    public void borrarChinpokomon(String codigo) {
        // Obtiene la referencia al nodo específico que deseas borrar

        DatabaseReference chinpokomonRef = ref.child("Chinpokomones").child(codigo);

        // Elimina el nodo
        chinpokomonRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(DatosUsuario.this, "Chinpokomon borrado exitosamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DatosUsuario.this, "Error al borrar Chinpokomon", Toast.LENGTH_SHORT).show();
                    Log.e("Firebase", "Error: " + task.getException().getMessage());
                }
            }
        });
    }





}