package com.example.savageworldscompanionapp;

public class Skill extends Trait{
    private Attribute associatedAttribute;

    // Constructor
    Skill(Attribute a, String n) { // Every com.example.savageworldscompanionapp.Skill must have an associated attribute
        super(n);
        associatedAttribute = a;
    }

    public Attribute getAssociatedAttribute() { return associatedAttribute; }

    public boolean raiseLevel(){
        return true;
    }

    public boolean lowerLevel(){
        return true;
    }
}
