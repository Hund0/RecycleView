package com.example.samuele.recycleview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalHolder> {

    private ArrayList<Animal> animals = new ArrayList<>();

    public AnimalAdapter(ArrayList animals){
        this.animals = animals;
    }

    @NonNull
    @Override
    public AnimalHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view, viewGroup, false);
        return new AnimalHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalHolder animalHolder, int i) {
        Animal animal = animals.get(i);
        animalHolder.bind(animal);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }
}
