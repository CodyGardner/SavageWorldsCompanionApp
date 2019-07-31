package com.example.savageworldscompanionapp;

import java.util.ArrayList;

public class Character {
    // Data files
    private String imageFilePath;
    private String initFilePath;

    // com.example.savageworldscompanionapp.Character info
    private String characterName;
    private String characterRace;
    //private String characterRank;

    // Edge and Hindrance features to be more appropriately implemented in the future
    // For now, a count of each will suffice for implementing their roles in character creation
    private int majorHindrances;
    private int minorHindrances;
    private int edges;


    // Statistics
    private int charisma;
    private int pace;
    private int parry;
    private int toughness;

    // Attributes and Skills
    private ArrayList<Attribute> attributes;
    private ArrayList<Skill> skills;

    // Getters
    public String getImageFilePath() { return imageFilePath; }
    public String getInitFilePath() { return initFilePath; }
    public String getCharacterName() { return characterName; }
    public String getCharacterRace() { return characterRace; }
    //public String getCharacterRank() { return characterRank; }
    public int getMajorHindrances() { return majorHindrances; }
    public int getMinorHindrances() { return minorHindrances; }
    public int getEdges() { return edges; }
    public int getCharisma() { return charisma; }
    public int getPace() { return pace; }
    public int getParry() { return parry; }
    public int getToughness() { return toughness; }
    public ArrayList<Attribute> getAttributes() { return attributes; }
    public ArrayList<Skill> getSkills() { return skills; }

    // Modifiers
    public void setImageFilePath(String str) { imageFilePath = str; }
    public void setInitFilePath(String str) { initFilePath = str; }
    public void setCharacterName(String str) { characterName = str; }
    public void setCharacterRace(String str) { characterRace = str; }
    //public void setCharacterRank(String str) { characterRank = str; }
    public void setMajorHindrances(int i) { majorHindrances = i; }
    public void setMinorHindrances(int i) { minorHindrances = i; }
    public void setEdges(int i) { edges = i; }
    public void setCharisma(int i) { charisma = i; }
    public void setPace(int i) { pace = i; }
    public void setParry(int i) { parry = i; }
    public void setToughness(int i) { toughness = i; }
    public void addAttribute(Attribute a) { attributes.add(a); }
    public void addSkill(Skill s) { skills.add(s); }

    // Constructors
    public Character() {
        attributes = new ArrayList<>();
        skills = new ArrayList<>();

        attributes.add(new Attribute("Agility", "Ag"));
        attributes.add(new Attribute("Smarts", "Sm"));
        attributes.add(new Attribute("Spirit", "Sp"));
        attributes.add(new Attribute("Strength", "St"));
        attributes.add(new Attribute("Vigor", "Vi"));

        skills.add(new Skill(attributes.get(3), "Climbing"));
        skills.add(new Skill(attributes.get(0), "Fighting"));
        skills.add(new Skill(attributes.get(1), "Healing"));
        skills.add(new Skill(attributes.get(1), "Investigation"));
        skills.add(new Skill(attributes.get(0), "Lockpicking"));
        skills.add(new Skill(attributes.get(1), "Notice"));
        skills.add(new Skill(attributes.get(2), "Persuasion"));
        skills.add(new Skill(attributes.get(0), "Shooting"));
        skills.add(new Skill(attributes.get(0), "Stealth"));
        skills.add(new Skill(attributes.get(1), "Streetwise"));
    }

    // Functions
    public void saveCharacter() { } // Save character to init file
    public void loadFromFile(String fileName) { } // Use when selecting character to load data from file
}
