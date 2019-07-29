package com.example.savageworldscompanionapp;

import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class CharacterCreation extends AppCompatActivity implements CharacterCreationAttribute.OnFragmentInteractionListener,
                                                                    CharacterCreationHindrance.OnFragmentInteractionListener,
                                                                    CharacterCreationSkill.OnFragmentInteractionListener{

    private Attribute agility;
    private ScrollView scrollView;
    //private EditAttributeComponent editAgility;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);

        agility = new Attribute("Agility", "Ag");
        //scrollView = findViewById(R.id.character_creation_scroller);
        //editAgility = new EditAttributeComponent(this, agility);

        ViewPager viewPager = findViewById(R.id.view_pager);
        CharacterCreationPagerAdpater characterCreationPagerAdapter = new
                CharacterCreationPagerAdpater(getSupportFragmentManager(), getApplicationContext());
        viewPager.setAdapter(characterCreationPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        //Method to check active tab
        //Does each need onCreate(), onResume(), onPause(), etc.?

        /*
            ****Potential plan of action*****
         * onCreate() of CharacterCreation class starts a new "Character" object.
         * As each tab on the activity is cycled through, the information in that fragment is saved to that object.
         * "Save" button saves the values to a CSV that can be referenced with the app's onResume() function.
         * Do we want a "confirmation" dialog? Depending on how complex attributes/skills/hindrances get.
         * "Cancel" button discards the changes and doesn't save anything.
         *
         */


    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //Intentionally empty
    }
}