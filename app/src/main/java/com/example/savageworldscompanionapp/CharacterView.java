package com.example.savageworldscompanionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CharacterView extends AppCompatActivity {

    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_view);

        //Draw the image. This will eventually be replaced based on the race chosen.
        image=findViewById(R.id.imageView);
        image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.mohawk, null));

        //Get the IDs for the stat values

        //Set stat values based on the stats from SharedResources
        //Or maybe the Character object, if we choose to build one first

        //Define the button and its action
        FloatingActionButton fab = findViewById(R.id.dieButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CharacterView.this, DiceRoller.class));
            }
        });
        //Anything passed via intent?
    }
}
