package com.example.savageworldscompanionapp;

public class EditAttributeListItem {
    private String attributeName;
    private Attribute attribute;
    private int modifier;
    private String dieType;

    public EditAttributeListItem(String attrName, Attribute attr, int mod, String dt){
        attributeName = attrName;
        attribute = attr;
        modifier = mod;
        dieType = dt;
    }

    //Getters
    public String getAttributeName() { return attributeName; }
    public Attribute getAttribute() { return attribute; }
    public int getModifier() { return modifier; }
    public String getDieType() { return dieType; }

    //Setters
    public void setAttributeName(String attributeName) { this.attributeName = attributeName; }
    public void setAttribute(Attribute attribute) { this.attribute = attribute; }
    public void setModifier(int modifier) { this.modifier = modifier; }
    public void setDieType(String dieType) { this.dieType = dieType; }
}
