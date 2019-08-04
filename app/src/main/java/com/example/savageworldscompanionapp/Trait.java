package com.example.savageworldscompanionapp;

import android.content.Intent;
import android.util.Log;

abstract class Trait {
    protected String name;
    protected int level;
    protected int modifier;

    // Constructor
    Trait(String n) { // Every Trait must have a name
        name = n;
        level = 0;
        modifier = 0;
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getModifier() { return modifier; }
    public void setModifier(int i) {modifier = i;}
    abstract boolean raiseLevel();
    abstract boolean lowerLevel();

    // Passes this item's level and modifier into an intent
    public void passThroughIntent(Intent intent){
        String slevel;

        switch(level){
            case 1:
                slevel = "D4";
                break;
            case 2:
                slevel = "D6";
                break;
            case 3:
                slevel = "D8";
                break;
            case 4:
                slevel = "D10";
                break;
            case 5:
                slevel = "D12";
                break;
            default:
                slevel = "UT";
                break;
        }
        intent.putExtra(name + "_level", slevel);
        Log.d("Debug", "Added " + name + " level!");
        intent.putExtra(name + "_modifier", modifier);
        Log.d("Debug", "Added " + name + " modifier!");

    }
}
