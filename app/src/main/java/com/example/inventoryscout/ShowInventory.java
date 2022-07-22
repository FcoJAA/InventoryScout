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
    public EditText et2delete, et1delete,et3delete,et4delete,et5delete,et6delete,et7delete,et8delete,et9delete;
    final String[] oldValue1 = {""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_inventory);

        et1delete = (EditText) findViewById(R.id.et1delete);
        et2delete = (EditText) findViewById(R.id.et2delete);
        et3delete = (EditText) findViewById(R.id.et3delete);
        et4delete = (EditText) findViewById(R.id.et4delete);
        et5delete = (EditText) findViewById(R.id.et5delete);
        et6delete = (EditText) findViewById(R.id.et6delete);
        et7delete = (EditText) findViewById(R.id.et7delete);
        et8delete = (EditText) findViewById(R.id.et8delete);
        et9delete = (EditText) findViewById(R.id.et9delete);
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

    //TODO REFACTORIZAR CODIGO
    public void modify(View view){

            DocumentReference docRef = db.collection(colletionpath1).document((items[0]));
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    if (task.isSuccessful()) {
                        oldValue1[0] = document.get("Unidades").toString();
                        Map<String, Object> data1 = new HashMap<>();
                        String item1 = oldValue1[0] + et1delete.getText().toString();
                        int num1 = Integer.parseInt(oldValue1[0]);
                        String recuperado = et1delete.getText().toString();
                        if (recuperado.equals("")) { recuperado = "0";}
                        int num2 = Integer.parseInt(recuperado);
                        int resultado = operacion(num1, num2);
                        data1.put("Unidades", resultado);
                        db.collection(colletionpath1).document("Tornillos").set(data1);
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
                        Map<String, Object> data = new HashMap<>();
                        String item1 = oldValue1[0] + et2delete.getText().toString();
                        int num1 = Integer.parseInt(oldValue1[0]);
                        String recuperado = et2delete.getText().toString();
                        if (recuperado.equals("")) { recuperado = "0";}
                        int num2 = Integer.parseInt(recuperado);
                        int resultado = operacion(num1, num2);
                        data.put("Unidades", resultado);
                        db.collection(colletionpath1).document("Tuercas").set(data);
                    }
                }
            });
            DocumentReference docRef3 = db.collection(colletionpath1).document((items[2]));
            docRef3.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    if (task.isSuccessful()) {
                        oldValue1[0] = document.get("Unidades").toString();
                        Map<String, Object> data = new HashMap<>();
                        String item1 = oldValue1[0] + et3delete.getText().toString();
                        int num1 = Integer.parseInt(oldValue1[0]);
                        String recuperado = et3delete.getText().toString();
                        if (recuperado.equals("")) { recuperado = "0";}
                        int num2 = Integer.parseInt(recuperado);
                        int resultado = operacion(num1, num2);
                        data.put("Unidades", resultado);
                        db.collection(colletionpath1).document("Tuberias Acero").set(data);
                    }
                }
            });
        DocumentReference docRef4 = db.collection(colletionpath1).document((items[3]));
        docRef4.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (task.isSuccessful()) {
                    oldValue1[0] = document.get("Unidades").toString();
                    Map<String, Object> data = new HashMap<>();
                    String item1 = oldValue1[0] + et4delete.getText().toString();
                    int num1 = Integer.parseInt(oldValue1[0]);
                    String recuperado = et4delete.getText().toString();
                    if (recuperado.equals("")) { recuperado = "0";}
                    int num2 = Integer.parseInt(recuperado);
                    int resultado = operacion(num1, num2);
                    data.put("Unidades", resultado);
                    db.collection(colletionpath1).document("Tornillo B").set(data);
                }
            }
        });
        DocumentReference docRef5 = db.collection(colletionpath1).document((items[4]));
        docRef5.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (task.isSuccessful()) {
                    oldValue1[0] = document.get("Unidades").toString();
                    Map<String, Object> data = new HashMap<>();
                    String item1 = oldValue1[0] + et5delete.getText().toString();
                    int num1 = Integer.parseInt(oldValue1[0]);
                    String recuperado = et5delete.getText().toString();
                    if (recuperado.equals("")) { recuperado = "0";}
                    int num2 = Integer.parseInt(recuperado);
                    int resultado = operacion(num1, num2);
                    data.put("Unidades", resultado);
                    db.collection(colletionpath1).document("Lija").set(data);
                }
            }
        });
        DocumentReference docRef6 = db.collection(colletionpath1).document((items[5]));
        docRef6.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (task.isSuccessful()) {
                    oldValue1[0] = document.get("Unidades").toString();
                    Map<String, Object> data = new HashMap<>();
                    String item1 = oldValue1[0] + et6delete.getText().toString();
                    int num1 = Integer.parseInt(oldValue1[0]);
                    String recuperado = et6delete.getText().toString();
                    if (recuperado.equals("")) { recuperado = "0";}
                    int num2 = Integer.parseInt(recuperado);
                    int resultado = operacion(num1, num2);
                    data.put("Unidades", resultado);
                   db.collection(colletionpath1).document("Estropajo").set(data);
                }
            }
        });
        DocumentReference docRef7 = db.collection(colletionpath1).document((items[6]));
        docRef7.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (task.isSuccessful()) {
                    oldValue1[0] = document.get("Unidades").toString();
                    Map<String, Object> data = new HashMap<>();
                    String item1 = oldValue1[0] + et7delete.getText().toString();
                    int num1 = Integer.parseInt(oldValue1[0]);
                    String recuperado = et7delete.getText().toString();
                    if (recuperado.equals("")) { recuperado = "0";}
                    int num2 = Integer.parseInt(recuperado);
                    int resultado = operacion(num1, num2);
                    data.put("Unidades", resultado);
                    db.collection(colletionpath1).document("Destornillador de Estrella").set(data);
                }
            }
        });
        DocumentReference docRef8 = db.collection(colletionpath1).document((items[7]));
        docRef8.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (task.isSuccessful()) {
                    oldValue1[0] = document.get("Unidades").toString();
                    Map<String, Object> data = new HashMap<>();
                    String item1 = oldValue1[0] + et8delete.getText().toString();
                    int num1 = Integer.parseInt(oldValue1[0]);
                    String recuperado = et8delete.getText().toString();
                    if (recuperado.equals("")) { recuperado = "0";}
                    int num2 = Integer.parseInt(recuperado);
                    int resultado = operacion(num1, num2);
                    data.put("Unidades", resultado);
                    db.collection(colletionpath1).document("Arandela").set(data);
                }
            }
        });
        DocumentReference docRef9 = db.collection(colletionpath1).document((items[8]));
        docRef9.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (task.isSuccessful()) {
                    oldValue1[0] = document.get("Unidades").toString();
                    Map<String, Object> data = new HashMap<>();
                    String item1 = oldValue1[0] + et9delete.getText().toString();
                    int num1 = Integer.parseInt(oldValue1[0]);
                    String recuperado = et9delete.getText().toString();
                    if (recuperado.equals("")) { recuperado = "0";}
                    int num2 = Integer.parseInt(recuperado);
                    int resultado = operacion(num1, num2);
                    data.put("Unidades", resultado);
                    db.collection(colletionpath1).document("Cinta Americana").set(data);
                }
            }
        });
            new android.os.Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public void run() {
                            for (int i = 0; i < 9; i++) {
                                mostrar(items[i]);
                            }
                            clearEditText();
                        }
                    },
                    300);
    }

    public int operacion(int a , int b){
        int resultado;
        return resultado = a + b;
    }
    public void clearEditText(){
        et1delete.setText(""); et2delete.setText(""); et3delete.setText("");
        et4delete.setText(""); et5delete.setText(""); et6delete.setText("");
        et7delete.setText(""); et8delete.setText(""); et9delete.setText("");
    }
}