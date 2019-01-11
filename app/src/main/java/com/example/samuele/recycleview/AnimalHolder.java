package com.example.samuele.recycleview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalHolder extends RecyclerView.ViewHolder {

    TextView nomeAnimale;
    ImageView imgAnimale;
    Animal animal;

    public AnimalHolder(@NonNull View itemView) {
        super(itemView);
        nomeAnimale = itemView.findViewById(R.id.tipoAnimale);
        imgAnimale = itemView.findViewById(R.id.imgAnimale);
    }

    public void bind(Animal animal){
        this.animal = animal;
        nomeAnimale.setText(this.animal.getName());
        if(this.animal.getUriImg() != null){
            imgAnimale.setImageURI(this.animal.getUriImg());
        }
    }


}
