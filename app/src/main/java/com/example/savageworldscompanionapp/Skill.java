package com.example.savageworldscompanionapp;

public class Skill extends Trait{
    Attribute associatedAttribute;

    // Constructor
    Skill(Attribute a, String n) { // Every com.example.savageworldscompanionapp.Skill must have an associated attribute
        super(n);
        associatedAttribute = a;
    }
}
