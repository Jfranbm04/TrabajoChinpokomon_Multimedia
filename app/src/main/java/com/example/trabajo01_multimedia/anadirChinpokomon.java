package com.example.trabajo01_multimedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabajo01_multimedia.modelos.Chinpokomon;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class anadirChinpokomon extends AppCompatActivity {

    TextView codigoView, nombreView, nivelView, tipoView, movimientoView;
    ImageView imageView;
    String codigo, nombre, nivel, tipo, movimiento;
    DatabaseReference mRootReference;
    // ---------------------------------------------------------------------------------
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/fireblog");
    // ---------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_chinpokomon);

        codigoView = findViewById(R.id.txtCod);
        nombreView = findViewById(R.id.txtNom);
        nivelView = findViewById(R.id.txtNvl);
        tipoView = findViewById(R.id.txtType);
        movimientoView = findViewById(R.id.txtMov);

        mRootReference = FirebaseDatabase.getInstance().getReference("Coleccion");

    }


    public void añadir(View view){
        codigo = codigoView.getText().toString();
        nombre = nombreView.getText().toString();
        nivel = nivelView.getText().toString();
        tipo = tipoView.getText().toString();
        movimiento = movimientoView.getText().toString();


        if(codigo.isEmpty() || nombre.isEmpty() || nivel.isEmpty() || tipo.isEmpty() || movimiento.isEmpty()){
            Toast.makeText(this, "Añade todos los datos.", Toast.LENGTH_SHORT).show();
        }else{
            DatabaseReference usersRef = ref.child("Coleccion");
            Map<String, Object> users = new HashMap<>();

            users.put("Chinpo 1", new Chinpokomon(codigo, nombre, nivel, tipo, movimiento));
            // users.put("Chinpo 1", new Chinpokomon(codigo, nombre, nivel, tipo, movimiento, R.drawable.imagen1));
            usersRef.setValue(users);

            // postChinpokomon(codigo, nombre, nivel, tipo, movimiento);
            Toast.makeText(this, "1 Chinpokomon añadido a la colección.", Toast.LENGTH_SHORT).show();
            finish();
        }



    }

    /*
        private void postChinpokomon(String codigo, String nombre, String nivel, String tipo, String movimiento) {

                Map<String, Object> map = new HashMap<>();
                map.put("codigo", codigo);
                map.put("nombre", nombre);
                map.put("nivel", nivel);
                map.put("tipo", tipo);
                map.put("movimiento", movimiento);

                map.put("imagen", R.drawable.imagen1);      // IMPORTANTE CAMBIAR ----------------------------------------------------------------------------------------------------------------------
                // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                mRootReference.child("Chinpokomon").push().setValue(map);
                Toast.makeText(this, "Chinpokomon añadido a la colección", Toast.LENGTH_SHORT).show();
                finish();


        }
    */


    public void modificar(View view){
        codigo = codigoView.getText().toString();
        nombre = nombreView.getText().toString();
        nivel = nivelView.getText().toString();
        tipo = tipoView.getText().toString();
        movimiento = movimientoView.getText().toString();

        if(codigo.isEmpty() || nombre.isEmpty() || nivel.isEmpty() || tipo.isEmpty() || movimiento.isEmpty()){
            Toast.makeText(this, "Añade todos los datos.", Toast.LENGTH_SHORT).show();
        }else{
            DatabaseReference usersRef = ref.child("Coleccion");
            Map<String, Object> users = new HashMap<>();

            users.put("Chinpo 1", new Chinpokomon(codigo, nombre, nivel, tipo, movimiento));
            usersRef.child("Coleccion").updateChildren(users);
            Toast.makeText(this, "1 Chinpokomon actualizado.", Toast.LENGTH_SHORT).show();
            finish();


        }
    }









    // Método para volver a la colección
    public void volver (View view){
        Intent anterior = new Intent(this, DatosUsuario.class);
        startActivity(anterior);

}


}