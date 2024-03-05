// READ COMMENTS FOR BETTER UNDERSTANDING OF PRINCIPLE AND CODE 
// READ THEROY.TXT AND RULE VIOLATIONEXAMPLES BEFORE THIS FILE.


public class Shape
{
    public double Area()
    {
        return 0;
    }
}

public class Rectangle extends Shape
{
    public double Width ;
    public double Height ;

    @Override
    public  double Area()
    {
        return Width * Height;
    }
}

public class Square extends Shape
{
    public double SideLength ; 

    @Override
    public  double Area()
    {
        return SideLength * SideLength;
    }
}


// we have a method that takes a Shape object and calculates the area. 
// We can substitute a Rectangle or a Square object without any issues, because both
//  Rectangle and Square inherit from Shape and implement the Area method:


public class AreaCalculator
{
    public double CalculateArea(Shape shape)
    {
        return shape.Area();
    }
}

// we can use Rectangle and Square objects interchangeably with Shape objects 
// without affecting the correctness of the program.



public class LiskovSubstitution {
    public static void main(String[] args) {
        
    }
}
