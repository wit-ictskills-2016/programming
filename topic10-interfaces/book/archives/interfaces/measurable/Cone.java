public class Cone
{
    int height;
    int radius;

    public Cone(int height, int radius)
    {
        this.height = height; 
        this.radius = radius;
    }

    public double volume()
    {
        return areaBase()*height/3;
    }

    /**
     * Calculates the surface area of right circular cone (including base).
     * @return total surface area right circular cone (includes base)
     */
    public double surfaceArea()
    {
        double slantHeight  = Math.hypot(radius, height);
        double areaTop      = Math.PI*radius*slantHeight;
        return areaTop + areaBase();
    }

    private double areaBase()
    {
        return Math.PI*radius*radius;
    }
}
