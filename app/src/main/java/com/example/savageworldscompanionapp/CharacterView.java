package com.example.savageworldscompanionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CharacterView extends AppCompatActivity {

    ImageView image;
    TextView charName;
    TextView charRace;
    TextView strView;
    TextView spiView;
    TextView agiView;
    TextView smaView;
    TextView vigView;
    TextView pacView;
    TextView parView;
    TextView togView;
    TextView majHindView;
    TextView minHindView;

    //Declare a SharedPreferences object
    Context context = CharacterView.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_view);

        //Assign TextViews to views
        charName = findViewById(R.id.characterName);
        charRace = findViewById(R.id.characterRace);
        strView = findViewById(R.id.strVal);
        spiView = findViewById(R.id.spiVal);
        agiView = findViewById(R.id.agiVal);
        smaView = findViewById(R.id.smaVal);
        vigView = findViewById(R.id.vigVal);
        pacView = findViewById(R.id.pacVal);
        parView = findViewById(R.id.parVal);
        togView = findViewById(R.id.togVal);
        majHindView = findViewById(R.id.majHindVal);
        minHindView = findViewById(R.id.minHindVal);

        //Receive intent
        Intent i = getIntent();

        //Parse intent elements
        if(i.getStringExtra("Name") != null)
            charName.setText(i.getStringExtra("Name"));
        else
            charName.setText("Mr. T");
        if(i.getStringExtra("Race") != null)
            charName.setText(i.getStringExtra("Race"));
        else
            charName.setText("Night Elf Mohawk");
        strView.setText(i.getIntExtra("Strength",0));
        spiView.setText(i.getIntExtra("Spirit",0));
        agiView.setText(i.getIntExtra("Agility",0));
        smaView.setText(i.getIntExtra("Smarts",0));
        vigView.setText(i.getIntExtra("Vigor",0));
        pacView.setText(i.getIntExtra("Pace",0));
        parView.setText(i.getIntExtra("Parry",0));
        togView.setText(i.getIntExtra("Toughness",0));
        majHindView.setText(i.getIntExtra("Major Hindrances",0));
        minHindView.setText(i.getIntExtra("Minor Hindrances",0));


        //Draw the image. This will eventually be replaced based on the race chosen.
        image=findViewById(R.id.imageView);
        image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.mohawk, null));

        //Get the IDs for the stat values
        //charName.setText()

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
