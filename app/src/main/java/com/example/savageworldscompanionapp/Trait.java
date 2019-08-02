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
        intent.putExtra(name + "_level", level);
        Log.d("Debug", "Added " + name + " level!");
        intent.putExtra(name + "_modifier", modifier);
        Log.d("Debug", "Added " + name + " modifier!");
    }
}
