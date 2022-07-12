package com.example.inventoryscout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class insertItems extends AppCompatActivity {

    EditText etinsert1,etinsert2,etinsert3,etinsert4,etinsert5,etinsert6,etinsert7,etinsert8,etinsert9;
    Button btnInsert1,btnInsert2,btnInsert3,btnInsert4,btnInsert5,btnInsert6,btnInsert7,btnInsert8,btnInsert9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_items);

        etinsert1 =findViewById(R.id.etinsert1);
        etinsert2 =findViewById(R.id.etinsert2);
        etinsert3 =findViewById(R.id.etinsert3);
        etinsert4 =findViewById(R.id.etinsert4);
        etinsert5 =findViewById(R.id.etinsert5);
        etinsert6 =findViewById(R.id.etinsert6);
        etinsert7 =findViewById(R.id.etinsert7);
        etinsert8 =findViewById(R.id.etinsert8);
        etinsert9 =findViewById(R.id.etinsert9);

    }

    public void insertTornillo(){

    }
}