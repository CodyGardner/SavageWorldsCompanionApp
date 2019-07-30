package com.example.savageworldscompanionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.widget.ImageView;

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
        //Anything passed via intent?
    }
}
