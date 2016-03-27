 
public class Rectangle
{
	int length;
    int height;
    
    public Rectangle(int length, int height)
    {
    	this.length = length;
    	this.height = height;
    }
    
    public double area()
    {
	   return length*height;
    }
   
    public double perimeter()
    {
        return 2*(length + height);
    }
}
