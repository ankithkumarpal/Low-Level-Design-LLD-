

abstract class shape {
     public abstract double Area();
 }
 
 class circle extends shape {
      private double radius ; 
      
      circle(double radius){
          this.radius = radius;
      }

      @Override
      public  double Area(){
          return (2*radius*radius);
      }

 }

 class square extends shape {
     private double sideLength ; 

     square(double sideLength) {
         this.sideLength = sideLength;
     }

     @Override
     public double Area() {
         return (sideLength*sideLength);
     }

 }

 class openclose {
    public static void main(String[] args) {
        
    }
}
