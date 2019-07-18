package com.example.savageworldscompanionapp;

public class Attribute extends Trait{
    private String shortName;

    // Constructors
    public Attribute(String n, String sn) { // All Attributes must have an abbreviated name
        super(n);
        shortName = sn;
    }

    public String getShortName() { return shortName; }
}
