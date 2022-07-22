package com.example.inventoryscout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ShowInventory extends AppCompatActivity {

    static FirebaseFirestore db = FirebaseFirestore.getInstance();
    final String colletionpath1 = "MainInventory";
    public TextView tvshow1, tvshow2,tvshow3,tvshow4,tvshow5,tvshow6,tvshow7,tvshow8,tvshow9;
    public String[] items = new String[]{"Tornillos", "Tuercas","Tuberias Acero","Tornillo B","Lija","Estropajo","Destornillador de Estrella","Arandela","Cinta Americana"};
    public EditText et2delete, et1delete;
    final String[] oldValue1 = {""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_inventory);

        et1delete = (EditText) findViewById(R.id.et1delete);
        et2delete = (EditText) findViewById(R.id.et2delete);
        tvshow1 = (TextView) findViewById(R.id.tvShow1);
        tvshow2 = (TextView) findViewById(R.id.tvShow2);
        tvshow3 = (TextView) findViewById(R.id.tvShow3);
        tvshow4 = (TextView) findViewById(R.id.tvShow4);
        tvshow5 = (TextView) findViewById(R.id.tvShow5);
        tvshow6 = (TextView) findViewById(R.id.tvShow6);
        tvshow7 = (TextView) findViewById(R.id.tvShow7);
        tvshow8 = (TextView) findViewById(R.id.tvShow8);
        tvshow9 = (TextView) findViewById(R.id.tvShow9);

       for (int i = 0; i <9;i++) {
            mostrar(items[i]);
        }
    }

    public void mostrar(String value) {

        DocumentReference docRef = db.collection(colletionpath1).document(value);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        if(value.equals("Tornillos")){tvshow1.setText(document.get("Unidades").toString());}
                        if(value.equals("Tuercas")){tvshow2.setText(document.get("Unidades").toString());}
                        if(value.equals("Tuberias Acero")){tvshow3.setText(document.get("Unidades").toString());}
                        if(value.equals("Tornillo B")){tvshow4.setText(document.get("Unidades").toString());}
                        if(value.equals("Lija")){tvshow5.setText(document.get("Unidades").toString());}
                        if(value.equals("Estropajo")){tvshow6.setText(document.get("Unidades").toString());}
                        if(value.equals("Destornillador de Estrella")){tvshow7.setText(document.get("Unidades").toString());}
                        if(value.equals("Arandela")){tvshow8.setText(document.get("Unidades").toString());}
                        if(value.equals("Cinta Americana")){tvshow9.setText(document.get("Unidades").toString());}
                    } else {
                        Toast.makeText(ShowInventory.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ShowInventory.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void modify(View view){

            DocumentReference docRef = db.collection(colletionpath1).document((items[0]));
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    if (task.isSuccessful()) {
                        oldValue1[0] = document.get("Unidades").toString();
                        Toast.makeText(getApplicationContext(), oldValue1[0], Toast.LENGTH_LONG).show();
                        Map<String, Object> data1 = new HashMap<>();
                        String item1 = oldValue1[0] + et1delete.getText().toString();
                        int num1 = Integer.parseInt(oldValue1[0]);
                        int num2 = Integer.parseInt(et1delete.getText().toString());
                        int resultado = operacion(num1, num2);
                        data1.put("Unidades", resultado);
                        if (item1.equals("")) {
                        } else {
                            db.collection(colletionpath1).document("Tornillos").set(data1);
                        }
                    }
                }
            });
            DocumentReference docRef2 = db.collection(colletionpath1).document((items[1]));
            docRef2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    if (task.isSuccessful()) {
                        oldValue1[0] = document.get("Unidades").toString();
                        Toast.makeText(getApplicationContext(), oldValue1[0], Toast.LENGTH_LONG).show();
                        Map<String, Object> data = new HashMap<>();
                        String item1 = oldValue1[0] + et2delete.getText().toString();
                        int num1 = Integer.parseInt(oldValue1[0]);
                        int num2 = Integer.parseInt(et2delete.getText().toString());
                        int resultado = operacion(num1, num2);
                        data.put("Unidades", resultado);
                        if (item1.equals("")) {
                        } else {
                            db.collection(colletionpath1).document("Tuercas").set(data);
                        }
                    }
                }
            });




            new android.os.Handler(Looper.getMainLooper()).postDelayed(
                    new Runnable() {
                        public void run() {
                            for (int i = 0; i < 9; i++) {
                                mostrar(items[i]);
                            }
                        }
                    },
                    300);
    }

    public int operacion(int a , int b){
        int resultado;
        return resultado = a + b;
    }
}