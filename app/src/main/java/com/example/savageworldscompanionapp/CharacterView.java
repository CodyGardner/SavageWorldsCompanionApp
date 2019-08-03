package com.example.savageworldscompanionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
    TextView edgeView;

    //Declare a SharedPreferences object
    Context context = CharacterView.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.charViewToolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.title_activity_character_view);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

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
        edgeView = findViewById(R.id.edgeVal);

        View v = findViewById(R.id.charViewToolbar);
        registerForContextMenu(v);


        //Receive intent
        Intent i;
        i = getIntent();
        Log.d("","Got intent data!");
        try {

            //Parse intent elements
            if (i.getStringExtra("Name") != null)
                charName.setText(i.getStringExtra("Name"));
            else
              charName.setText("Mr. T");
            Log.d("","Got name!");
            if (i.getStringExtra("Race") != null)
                charRace.setText(i.getStringExtra("Race"));
            else
                charName.setText("Night Elf Mohawk");
            Log.d("","Got race!");
            /*strView.setText(Integer.toString(i.getIntExtra("Strength", 0)));
            spiView.setText(Integer.toString(i.getIntExtra("Spirit", 0)));
            agiView.setText(Integer.toString(i.getIntExtra("Agility", 0)));
            smaView.setText(Integer.toString(i.getIntExtra("Smarts", 0)));
            vigView.setText(Integer.toString(i.getIntExtra("Vigor", 0)));
            pacView.setText(Integer.toString(i.getIntExtra("Pace", 0)));
            parView.setText(Integer.toString(i.getIntExtra("Parry", 0)));
            togView.setText(Integer.toString(i.getIntExtra("Toughness", 0)));*/
            majHindView.setText(Integer.toString(i.getIntExtra("MajorHindrances", 0)));
            Log.d("","Got Major Hindrances!");
            minHindView.setText(Integer.toString(i.getIntExtra("MinorHindrances", 0)));
            Log.d("","Got minor hindrances!");
            edgeView.setText(Integer.toString(i.getIntExtra("Edges",0)));
            Log.d("","Got edges!");

        }
        catch(Exception e) {
            Log.e("Exception!",e.toString());
            charName.setText(R.string.placeholder_name);
            charRace.setText(R.string.placeholder_race);
        }

        //Draw the image. This will eventually be replaced based on the race chosen.
        image=findViewById(R.id.imageView);
        image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.mohawk, null));



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

        //TODO: Menu bar to go back to character creation

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()) {
            case R.id.clearOption:
                finish();
                return true;
            default:
                return false;
        }
    }
}
