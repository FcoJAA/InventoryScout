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
    //TODO ESTE INVENTARIO SERA COMUN PARA TODA LA GENTE QUE USE ESTA APLICACION
    final String colletionpath1 = "MainInventory";

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

        Map<String, Object> data1 = new HashMap<>();
        String item1 = etinsert1.getText().toString();
        data1.put("Cantidad", item1 );

        Map<String, Object> data2 = new HashMap<>();
        String item2 = etinsert2.getText().toString();
        data2.put("Cantidad", item2 );

        Map<String, Object> data3 = new HashMap<>();
        String item3 = etinsert3.getText().toString();
        data3.put("Cantidad", item3 );

        Map<String, Object> data4 = new HashMap<>();
        String item4 = etinsert4.getText().toString();
        data4.put("Tornillos B", item4 );

        Map<String, Object> data5 = new HashMap<>();
        String item5 = etinsert5.getText().toString();
        data5.put("Lijas", item5 );

        Map<String, Object> data6 = new HashMap<>();
        String item6 = etinsert6.getText().toString();
        data6.put("Estropajos", item6 );

        Map<String, Object> data7 = new HashMap<>();
        String item7 = etinsert7.getText().toString();
        data7.put("Destornillador de Estrella", item7 );

        Map<String, Object> data8 = new HashMap<>();
        String item8 = etinsert8.getText().toString();
        data8.put("Arandela", item8 );

        Map<String, Object> data9 = new HashMap<>();
        String item9 = etinsert9.getText().toString();
        data9.put("Cinta Americana", item9 );

        if(item1.equals("")){}else {
            db.collection(colletionpath1).document("Tornillos").set(data1)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) { Toast.makeText(insertItems.this, "Introducido Correctamente", Toast.LENGTH_SHORT).show(); }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) { Toast.makeText(insertItems.this, "ERROR", Toast.LENGTH_SHORT).show(); }
                    });
        }
        if(item2.equals("")){}else {
            db.collection(colletionpath1).document("Tuercas").set(data2)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) { Toast.makeText(insertItems.this, "Introducido Correctamente", Toast.LENGTH_SHORT).show(); }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) { Toast.makeText(insertItems.this, "ERROR", Toast.LENGTH_SHORT).show(); }
                    });
        }
        if(item3.equals("")){}else{
            db.collection(colletionpath1).document("Tuberias Acero").set(data3)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {  Toast.makeText(insertItems.this, "Introducido Correctamente", Toast.LENGTH_SHORT).show();  }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) { Toast.makeText(insertItems.this, "ERROR", Toast.LENGTH_SHORT).show();  }
                    });
        }
        if(item4.equals("")){}else{
            db.collection(colletionpath1).document("Tornillo B").set(data4)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {  Toast.makeText(insertItems.this, "Introducido Correctamente", Toast.LENGTH_SHORT).show();  }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) { Toast.makeText(insertItems.this, "ERROR", Toast.LENGTH_SHORT).show();  }
                    });
        }
        if(item5.equals("")){}else{
            db.collection(colletionpath1).document("Lija").set(data5)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {  Toast.makeText(insertItems.this, "Introducido Correctamente", Toast.LENGTH_SHORT).show();  }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) { Toast.makeText(insertItems.this, "ERROR", Toast.LENGTH_SHORT).show();  }
                    });
        }
        if(item6.equals("")){}else{
            db.collection(colletionpath1).document("Estropajo").set(data6)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {  Toast.makeText(insertItems.this, "Introducido Correctamente", Toast.LENGTH_SHORT).show();  }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) { Toast.makeText(insertItems.this, "ERROR", Toast.LENGTH_SHORT).show();  }
                    });
        }
        if(item7.equals("")){}else{
            db.collection(colletionpath1).document("Destornillador de Estrella").set(data7)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {  Toast.makeText(insertItems.this, "Introducido Correctamente", Toast.LENGTH_SHORT).show();  }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) { Toast.makeText(insertItems.this, "ERROR", Toast.LENGTH_SHORT).show();  }
                    });
        }
        if(item8.equals("")){}else{
            db.collection(colletionpath1).document("Arandela").set(data8)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {  Toast.makeText(insertItems.this, "Introducido Correctamente", Toast.LENGTH_SHORT).show();  }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) { Toast.makeText(insertItems.this, "ERROR", Toast.LENGTH_SHORT).show();  }
                    });
        }
        if(item9.equals("")){}else{
            db.collection(colletionpath1).document("Cinta Americana").set(data9)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {  Toast.makeText(insertItems.this, "Introducido Correctamente", Toast.LENGTH_SHORT).show();  }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) { Toast.makeText(insertItems.this, "ERROR", Toast.LENGTH_SHORT).show();  }
                    });
        }
    }

}