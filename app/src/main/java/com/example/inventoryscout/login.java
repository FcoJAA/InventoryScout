package com.example.inventoryscout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    public FirebaseAuth mAuth;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.et1login);
        password = findViewById(R.id.et2login);
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void login(View view){

        mAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user); futura implementacion
                            Toast.makeText(getApplicationContext(), "Autentificacion correcta.", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(),myprofile.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Fallo al intentar iniciar sesión.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void changeToResetPassword(View view){
        startActivity(new Intent(this,resetpassword.class));
    }

}