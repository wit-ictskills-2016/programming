public class MeasureTester
{
    //choose arbitrary number of each shape
    private static int numberCones         = 10;
    private static int numberCircles       = 15;
    private static int numberRectangles    = 20;
    
    private static Cone[] cone             = new Cone[numberCones];
    private static Circle[] circle         = new Circle[numberCircles];
    private static Rectangle[] rectangle   = new Rectangle[numberRectangles];
    
    public static double maxConeSurfaceArea()
    {
        //create array of cones with aritrary parameters
        //signature is Cone(int height, int radius)
        for(int i = 0; i < cone.length; i += 1)
        {
            cone[i] = new Cone(100 + i, 200 + i);
        }
        return Measure.maximum(cone);
    }
    
    public static double maxCircleArea()
    {
        //create array of circles with aritrary parameters
        //signature is Circle(int radius)
        for(int i = 0; i < circle.length; i += 1)
        {
            circle[i] = new Circle(100 + i);
        }
        return Measure.maximum(circle);
    }
    public static double maxRectanglePerimeter()
    {
       //create array of rectangles with aritrary parameters
        //signature is Rectangle(int length, int height)
        for(int i = 0; i < rectangle.length; i += 1)
        {
            rectangle[i] = new Rectangle(200 + i, 300 + i);
        }
        return Measure.maximum(rectangle);
    }
}
