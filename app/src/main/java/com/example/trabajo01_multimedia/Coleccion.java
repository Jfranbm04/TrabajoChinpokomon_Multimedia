package com.example.trabajo01_multimedia;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Coleccion extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText txtEmail;
    private EditText txtContraseña;
    Button buttonReg;
    private static final String TAG = "EmailPasswordActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coleccion);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        txtEmail = findViewById(R.id.txtEmail);
        txtContraseña = findViewById(R.id.txtContraseña);
        buttonReg = findViewById(R.id.btRegistrar);

        /*
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, contraseña;
                email = String.valueOf(txtEmail.getText());
                contraseña = String.valueOf(txtContraseña.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Coleccion.this, "Añade un correo.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(contraseña)){
                    Toast.makeText(Coleccion.this, "Añade una contraseña.", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, contraseña)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Coleccion.this, "Cuenta creada.",
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Coleccion.this, "Fallo en la autenticación.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

         */

    }

    public void iniciarSesion(View view){
        String email, contraseña;
        email = String.valueOf(txtEmail.getText());
        contraseña = String.valueOf(txtContraseña.getText());
        if(TextUtils.isEmpty(email)){
            Toast.makeText(Coleccion.this, "Escribe tu correo.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(contraseña)){
            Toast.makeText(Coleccion.this, "Escribe tu contraseña.", Toast.LENGTH_SHORT).show();
            return;
        }


        mAuth.signInWithEmailAndPassword(email, contraseña)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        try {
                            if (task.isSuccessful()) {
                                Toast.makeText(Coleccion.this, "Sesión iniciada.",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), DatosUsuario.class);
                                startActivity(intent);
                                finish();
                            } else {
                                throw task.getException(); // Lanza la excepción para ser capturada por el catch
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(Coleccion.this, e.getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void crearUsuario(View view){
        String email, contraseña;
        email = String.valueOf(txtEmail.getText());
        contraseña = String.valueOf(txtContraseña.getText());

        if(TextUtils.isEmpty(email)){
            Toast.makeText(Coleccion.this, "Añade un correo.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(contraseña)){
            Toast.makeText(Coleccion.this, "Añade una contraseña.", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, contraseña)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        try {
                            if (task.isSuccessful()) {
                                Toast.makeText(Coleccion.this, "Cuenta creada.",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                throw task.getException(); // Lanza la excepción para ser capturada por el catch
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(Coleccion.this, e.getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });



    }

    // Método para volver al main
    public void volver (View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);

    }


}