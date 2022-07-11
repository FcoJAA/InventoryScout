package com.example.inventoryscout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class resetpassword extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;
    public EditText etemail;
    public Button btnReset;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);

        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);
        etemail = (EditText) findViewById(R.id.et1reset);
        btnReset = (Button) findViewById(R.id.btnReset);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = etemail.getText().toString();
                if(!email.isEmpty()){
                    mDialog.setMessage("Esperando...");
                    mDialog.setCanceledOnTouchOutside(false);
                    mDialog.show();
                    resetPassword();
                }else{
                    Toast.makeText(resetpassword.this, "No ha ingresado su email.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void resetPassword() {

        mAuth.setLanguageCode("es");
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(resetpassword.this, "Correo enviado.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(resetpassword.this, "No se pudo enviar el correo pra restablecver la contraseña.", Toast.LENGTH_SHORT).show();
                }
                mDialog.dismiss();
            }
        });
    }
}