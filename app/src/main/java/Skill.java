public class Skill extends Trait{
    Attribute associatedAttribute;

    // Constructor
    Skill(Attribute a, String n) { // Every Skill must have an associated attribute
        super(n);
        associatedAttribute = a;
    }
}
