
public class Sphere
{
    int radius;

    public Sphere(int radius)
    {
        this.radius = radius;
    }
    
   public double volume()
   {
       return Math.PI*Math.pow(radius, 3)*4/3;
   }
   
   public double surfaceArea()
   {
       return 4*Math.PI*radius*radius;
   }
}
