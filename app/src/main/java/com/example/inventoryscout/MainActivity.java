package com.example.inventoryscout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    public FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeToLogin(View view){
        Intent i = new Intent(this,login.class);
        startActivity(i);
    }

    public void changeToSignUp(View view){
        Intent i = new Intent(this,signup.class);
        startActivity(i);
    }

    public void changeToProfile(View view){
        //TODO DETECTAR SI ESTA LOGEADO Y ENVIAR AL LOGIN
        Intent i = new Intent(this,myprofile.class);
        startActivity(i);
    }

    //MenuBar
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menubar1,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.option1){
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            mAuth.signOut();
        }
        return super.onOptionsItemSelected(item);
    }
}