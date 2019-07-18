package com.example.savageworldscompanionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class CharacterCreation extends AppCompatActivity {

    private Attribute agility;
    private ScrollView scrollView;
    private EditAttributeComponent editAgility;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);

        agility = new Attribute("Agility", "Ag");
        scrollView = findViewById(R.id.character_creation_scroller);
        editAgility = new EditAttributeComponent(this, agility);

    }
}
