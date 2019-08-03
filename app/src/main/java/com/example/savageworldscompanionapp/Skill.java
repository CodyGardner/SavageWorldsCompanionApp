package com.example.savageworldscompanionapp;

import java.io.Serializable;

public class Skill extends Trait implements Serializable {
    private Attribute associatedAttribute;

    // Constructor
    Skill(Attribute a, String n) { // Every com.example.savageworldscompanionapp.Skill must have an associated attribute
        super(n);
        associatedAttribute = a;
    }

    public Attribute getAssociatedAttribute() { return associatedAttribute; }

    public boolean raiseLevel(){
        if (level < 5){
            ++level;
            return true;
        }
        return false;
    }

    public boolean lowerLevel(){
        if (level > 0){
            --level;
            return true;
        }
        return false;
    }
}
