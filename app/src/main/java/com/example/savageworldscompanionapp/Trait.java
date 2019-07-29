package com.example.savageworldscompanionapp;

abstract class Trait {
    private String name;
    private int level;
    private int modifier;

    // Constructor
    Trait(String n) { // Every Train must have a name
        name = n;
        level = 0;
        modifier = 0;
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getModifier() { return modifier; }
    public void setModifier(int i) {modifier = i;}
    public boolean raiseLevel() {
        if (level < 5){
            ++level;
            return true;
        }
        return false;
    }
    public boolean lowerLevel() {
        if (level > 0){
            --level;
            return true;
        }
        return false;
    }
}
