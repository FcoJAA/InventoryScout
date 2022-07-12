package com.example.inventoryscout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class insertItems extends AppCompatActivity {

    EditText etinsert1,etinsert2,etinsert3,etinsert4,etinsert5,etinsert6,etinsert7,etinsert8,etinsert9;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String colletionpath1 = "MainInventory";
    String colletionName = "Inventory";

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

    public void insertItem1(View view){

        String item1 = etinsert1.getText().toString();

        Map<String, Object> data = new HashMap<>();
        data.put("Tornillo", item1 );

        db.collection(colletionpath1).document(colletionName).set(data)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(insertItems.this, "Introducido Correctamente", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(insertItems.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}