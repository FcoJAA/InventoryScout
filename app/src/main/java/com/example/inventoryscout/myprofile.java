package com.example.inventoryscout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public  class myprofile extends AppCompatActivity {

    public FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);

        mAuth =FirebaseAuth.getInstance();
    }


    public void showInventory(View view){
        startActivity(new Intent(this,ShowInventory.class));
    }
    public void changeToResetPassword(View view){
        startActivity(new Intent(this,resetpassword.class));
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