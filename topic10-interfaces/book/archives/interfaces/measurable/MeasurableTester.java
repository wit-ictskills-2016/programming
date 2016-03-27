
public class MeasurableTester
{
   //choose arbitrary number of each shape
    private static int numberCones         = 10;
    private static int numberCircles       = 15;
    private static int numberRectangles    = 20;
    private static int numberPipes         = 5;
    private static int numberSpheres       = 25;
    
    private static Measurable[] cones       = new Cone[numberCones];
    private static Measurable[] circles     = new Circle[numberCircles];
    private static Measurable[] rectangles  = new Rectangle[numberRectangles];
    private static Measurable[] pipes       = new Pipe[numberPipes];
    private static Measurable[] spheres     = new Sphere[numberSpheres];
    
    static double maximum(Measurable[] objects)
    {
        double max = objects[0].getMeasure();
        for(Measurable object : objects)
        {
            double val = object.getMeasure();
            max = val > max ? val : max;
        }
        return max;
    }

    public static double maxConeSurfaceArea()
    {
        //create array of coness with aritrary parameters
        //signature is Cone(int height, int radius)
        for(int i = 0; i < cones.length; i += 1)
        {
            cones[i] = new Cone(100 + i, 200 + i);
        }
        return maximum(cones);
    }

    public static double maxCircleArea()
    {
        //create array of circless with aritrary parameters
        //signature is Circle(int radius)
        for(int i = 0; i < circles.length; i += 1)
        {
            circles[i] = new Circle(100 + i);
        }
        return maximum(circles);
    }

    public static double maxRectanglePerimeter()
    {
        //create array of rectangless with aritrary parameters
        //signature is Rectangle(int length, int height)
        for(int i = 0; i < rectangles.length; i += 1)
        {
            rectangles[i] = new Rectangle(200 + i, 300 + i);
        }
        return maximum(rectangles);
    }

    public static double maxSphericalSurfaceArea()
    {
        //create array of spheres with aritrary parameters
        //signature is Sphere(int radius)
        for(int i = 0; i < spheres.length; i += 1)
        {
            spheres[i] = new Sphere(40 + i);
        }
        return maximum(spheres);
    }

    public static double maxPipeMaterialVolume()
    {
        /*
         * create array of pipes with aritrary parameters
         * signature is public Pipe(int radiusOuter, int radiusInner, int height)
         * The radii of the pipess are defined as follows:
         * outer radii : 40 + 2*i 
         * inner radii : 35 + i
         * where i is a loop counter with range [0, numberPipes-1]
         * The height of the pipes is defined by (1+i)*100;
         */
        for(int i = 0; i < pipes.length; i += 1)
        {
            pipes[i] = new Pipe(40 + 2*i, 35 + i, (1+i)*100);
        }
        return maximum(pipes);
    }

}
