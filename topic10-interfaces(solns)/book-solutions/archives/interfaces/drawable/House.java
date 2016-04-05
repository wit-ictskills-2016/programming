

public class House
{
    private Triangle roof;
    private RectangleBJ wall;
    private RectangleBJ window; 
  
    public House()
    {
        createWall("red");
        createWindow();
        createRoof();
    }
    
    public House(String color)
    {
        createWall(color);
        createWindow();
        createRoof();
    }
    
        private void createWall(String color) 
    {
        int xSideLength = 125;
        int ySideLength = 100;
        int xPosition = 25;
        int yPosition = 125;
  
        wall = new RectangleBJ();
        wall.setState(xSideLength, ySideLength, xPosition, yPosition, color);
        
    }
    
    private void createWindow() 
    {
        int xSideLength = 25;
        int ySideLength = 50;
        int xPosition = 45;
        int yPosition = 150;
        String color = "black";
        
        window = new RectangleBJ();
        window.setState(xSideLength, ySideLength, xPosition, yPosition, color);
    }
    
    private void createRoof() 
    {
        int height = 60;
        int width = 150;
        int xPosition = 87;
        int yPosition = 75;
        String color = "green";
        
        roof = new Triangle();
        roof.setState(height, width, xPosition, yPosition, color);
    }
}
