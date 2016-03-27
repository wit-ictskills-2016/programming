public class MeasureTester
{
    //choose arbitrary number of each shape
    private static int numberCones         = 10;
    private static int numberCircles       = 15;
    private static int numberRectangles    = 20;
    private static int numberPipes         = 5;
    private static int numberSpheres       = 25;
    
    private static Cone[] cones             = new Cone[numberCones];
    private static Circle[] circles         = new Circle[numberCircles];
    private static Rectangle[] rectangles   = new Rectangle[numberRectangles];
    
    public static double maxConeSurfaceArea()
    {
        //create array of coness with aritrary parameters
        //signature is Cone(int height, int radius)
        for(int i = 0; i < cones.length; i += 1)
        {
            cones[i] = new Cone(100 + i, 200 + i);
        }
        return Measure.maximum(cones);
    }
    
    public static double maxCircleArea()
    {
        //create array of circless with aritrary parameters
        //signature is Circle(int radius)
        for(int i = 0; i < circles.length; i += 1)
        {
            circles[i] = new Circle(100 + i);
        }
        return Measure.maximum(circles);
    }
    
    public static double maxRectanglePerimeter()
    {
       //create array of rectangless with aritrary parameters
        //signature is Rectangle(int length, int height)
        for(int i = 0; i < rectangles.length; i += 1)
        {
            rectangles[i] = new Rectangle(200 + i, 300 + i);
        }
        return Measure.maximum(rectangles);
    }
}
