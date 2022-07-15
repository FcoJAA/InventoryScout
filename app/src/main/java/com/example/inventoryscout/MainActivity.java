package com.example.inventoryscout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    public FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth =FirebaseAuth.getInstance();
    }

    public void changeToLogin(View view){
        startActivity(new Intent(this,login.class));
    }

    public void changeToSignUp(View view){
        startActivity(new Intent(this,signup.class));
    }

    public void changeToProfile(View view){
        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(this, myprofile.class));
        }else {
            Toast.makeText(this, "Debe iniciar sesion primero", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, login.class));
        }
    }

    //MenuBar
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menubar1,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.option1){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            mAuth.signOut();
        }
        return super.onOptionsItemSelected(item);
    }
}