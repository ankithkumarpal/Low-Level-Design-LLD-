// READ COMMENTS FOR BETTER UNDERSTANDING OF PRINCIPLE AND CODE 
// BEFORE READING THIS READ THEORY.TXT FILE 


// In this example, Square violates the LSP because it changes the behavior of the
//  Rectangle class. While a Square is a type of rectangle where all sides are equal, 
//  it changes the behavior of the Rectangle class by enforcing this constraint, which 
//  is not true for a general rectangle.


class Shape {
    public void draw() {
        System.out.println("Drawing shape");
    }
}

class Rectangle extends Shape {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}


public class ruleViolationExmpl2 {
    public static void main(String[] args) {
        
    }
}
