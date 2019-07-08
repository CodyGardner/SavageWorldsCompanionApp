abstract class Trait {
    String name;
    int level;
    int modifier;

    // Constructor
    Trait(String n) { // Every Train must have a name
        name = n;
        level = 0;
        modifier = 0;
    }
}
