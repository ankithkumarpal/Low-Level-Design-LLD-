// Read theory.txt file before this code 
// READ COMMENTS FOR BETTER UNDERSTANDING OF CODE 

// In this example, Ostrich violates the LSP because it changes the behavior
// of the eat method from its superclass Bird. Substituting an Ostrich object 
// for a Bird object could lead to unexpected behavior, as the eat method behaves 
// differently for an ostrich than for other birds.


class Bird {
    public void eat() {
        System.out.println("Eating like a bird");
    }
}

class Duck extends Bird {
    @Override
    public void eat() {
        System.out.println("Eating like a duck");
    }
}

class Ostrich extends Bird {
    @Override
    public void eat() {
        System.out.println("Eating like an ostrich");
    }
}


public class ruleViolationExmple1 {
    public static void main(String[] args) {
        
    }
}
