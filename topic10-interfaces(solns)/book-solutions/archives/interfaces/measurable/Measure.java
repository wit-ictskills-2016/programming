public class Measure
{

    /**
     * @return largest surface area from the array of cones
     */
    public static double maximum(Cone[] cone)
    {
        double maxSurfaceArea = cone[0].surfaceArea();
        for(int i = 0; i < cone.length; i += 1)
        {
            double surfArea = cone[i].surfaceArea();
            maxSurfaceArea = surfArea > maxSurfaceArea ? surfArea : maxSurfaceArea;
        }
        return maxSurfaceArea;
    }
    
    /**
     * @return  the area of the largest circle in the array
     */
    public static double maximum(Circle[] circle)
    {
        double maxArea = circle[0].area();
        for(int i = 0; i < circle.length; i += 1)
        {
            double circArea = circle[i].area();
            maxArea = circArea > maxArea ? circArea : maxArea;
        }   
        return maxArea;
    }
    
    /**
     * @return the longest perimeter from the array of rectangles
     */
    public static double maximum(Rectangle[] rectangle)
    {
        double maximumPerimeter = rectangle[0].perimeter();
        for(int i = 0; i < rectangle.length; i += 1)
        {
            double perimeter = rectangle[i].perimeter();
            maximumPerimeter = perimeter > maximumPerimeter ? perimeter : maximumPerimeter;
        }   
        return maximumPerimeter;
    }
}