package com.example.inventoryscout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class myprofile extends AppCompatActivity {

    public FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);

        mAuth =FirebaseAuth.getInstance();
    }

    public void insertItem(View view){
        Intent i = new Intent(this,insertItems.class);
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