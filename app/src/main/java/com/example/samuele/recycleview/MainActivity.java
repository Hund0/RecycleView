package com.example.samuele.recycleview;

import android.content.Intent;
import android.net.Uri;
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
    private Button selectImg;
    private EditText addAnimalText;
    private AnimalAdapter adapter;
    private Uri imgUri = null;
    private static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAnimals("cane", "gatto");

        recyclerView = findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        addButton = findViewById(R.id.addButton);
        selectImg = findViewById(R.id.selectImg);
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

        selectImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == PICK_IMAGE){
            imgUri = data.getData();
        }
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
        if(imgUri != null){
            nuovo.setUriImg(imgUri);
        }
        animali.add(nuovo);
        adapter.notifyDataSetChanged();
    }
}
