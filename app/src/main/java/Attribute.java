public class Attribute extends Trait{
    String shortName;

    // Constructors
    Attribute(String n, String sn) { // All Attributes must have an abbreviated name
        super(n);
        shortName = sn;
    }
}
