package com.example.inventoryscout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ShowInventory extends AppCompatActivity {

    static FirebaseFirestore db = FirebaseFirestore.getInstance();
    final String colletionpath1 = "MainInventory";
    public TextView tvshow1, tvshow2,tvshow3;
    public String[] items = new String[]{"Tornillos", "Tuercas", "Tornillo B"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_inventory);

        tvshow1 = (TextView) findViewById(R.id.tvShow1);
        tvshow2 = (TextView) findViewById(R.id.tvShow2);
        tvshow3 = (TextView) findViewById(R.id.tvShow3);

        for (int i = 0; i <3;i++) {
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
                        if(value.equals("Tornillo B")){tvshow3.setText(document.get("Unidades").toString());}

                    } else {
                        Toast.makeText(ShowInventory.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ShowInventory.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}