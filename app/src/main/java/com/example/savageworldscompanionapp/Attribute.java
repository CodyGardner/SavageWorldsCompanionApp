package com.example.savageworldscompanionapp;

import java.io.Serializable;

public class Attribute extends Trait implements Serializable {
    private String shortName;

    // Constructors
    public Attribute(String n, String sn) { // All Attributes must have an abbreviated name
        super(n);
        shortName = sn;
        level = 1;
    }

    public String getShortName() { return shortName; }
    public boolean raiseLevel(){
        if (level < 5){
            ++level;
            return true;
        }
        return false;
    }

    public boolean lowerLevel() {
        if (level > 1){
            --level;
            return true;
        }
        return false;
    }
}
