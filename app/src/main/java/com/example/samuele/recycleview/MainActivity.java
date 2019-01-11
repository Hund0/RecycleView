package com.example.samuele.recycleview;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Animal> animali;
    private RecyclerView recyclerView;
    private Button addButton;
    private EditText addAnimalText;
    private AnimalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAnimals("cane", "gatto");

        recyclerView = findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        addButton = findViewById(R.id.addButton);
        addAnimalText = findViewById(R.id.addTextAnimal);
        adapter = new AnimalAdapter(animali);
        recyclerView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newAnimal = addAnimalText.getText().toString();
                addNewAnimal(newAnimal);
            }
        });
    }

    public void createAnimals(String cane, String gatto) {
        animali = new ArrayList<>();

        Animal caneObj = new Animal();
        caneObj.setName(cane);

        Animal gattoObj = new Animal();
        gattoObj.setName(gatto);

        animali.add(caneObj);
        animali.add(gattoObj);
    }

    public void addNewAnimal(String newAnimal) {
        Animal nuovo = new Animal();
        nuovo.setName(newAnimal);
        animali.add(nuovo);
        adapter.notifyDataSetChanged();
    }
}
