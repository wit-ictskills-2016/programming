import java.awt.*;

/**
 * A rectangle that can be manipulated and that draws itself on a canvas.
 * Based on Square class written by Michael Kolling and David J. Barnes
 * @version 1.0  (8 Feb 2014)
 * 
 *  @author  jfitzgerald
 */
public class RectangleBJ
{
    private int xSideLength;
    private int ySideLength;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Create a new rectangle with default attributes
     */
    public RectangleBJ()
    {
        isVisible = false;
        setState(60, 30, 60, 50, "red");
    }
 
    /**
     * Create a new rectangle with default attributes but user-defined color
     */
    public RectangleBJ(String color)
    {
        isVisible = false;
        setState(60, 30, 60, 50, color);
    }   
    /**
     * Overloaded constructor
     * 
     * @param xSideLen  length of side in x-direction
     * @param ySideLen  length of side in y-direction
     * @param xPos      x coordinate top-left corner rectangle
     * @param yPos      y coordinate top-left corner rectangle
     * @param colour    colour of rectangle body
     */
    public RectangleBJ(int xSideLen, int ySideLen, int xPos, int yPos,String colour)
    {
       isVisible = false;
       setState(xSideLen, ySideLen, xPos, yPos,colour);
    }    
  
    /**
     * Set the entire state of object
     * If the object has been created with default constructor, this constitutes initialization
     * 
     * @param xSideLen  length of side in x-direction
     * @param ySideLen  length of side in y-direction
     * @param xPos      x coordinate top-left corner rectangle
     * @param yPos      y coordinate top-left corner rectangle
     * @param colour    colour of rectangle body
     */
    public void setState(int xSideLen, int ySideLen, int xPos, int yPos,String colour)
    {
        xSideLength = xSideLen;
        ySideLength = ySideLen;
        xPosition = xPos;
        yPosition = yPos;
        color = colour;
    }
   
    /**
     * Move the rectangle such that its top-left corner's coordinates are actual parameters
     * @param x x-coordinate top left corner
     * @param y y-coordinate top left corner
     */
    public void moveTo(int x, int y)
    {
        xPosition = x;
        yPosition = y;
        makeVisible();
        draw();
    }
    
    /**
     * Make this rectangle visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Make this rectangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    /**
     * Move the rectangle 20 pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the rectangle a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the rectangle 20 pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the rectangle a 20 pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the rectangle horizontally.
     * @param distance  distance in pixels by which rectangle moved
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the rectangle vertically.
     * @param distance  distance in pixels by which rectangle moved 
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the rectangle horizontally
     * @param distance  distance in pixels by which rectangle moved
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the rectangle vertically.
     * @param distance  distance in pixels by which rectangle moved
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size of rectangle.
     * @param newXSideLength    the new length in x-direction
     * @param newYSideLength    the new length in y-direction
     */
    public void changeSize(int newXSideLength, int newYSideLength)
    {
        if(newXSideLength > 0 && newYSideLength > 0) 
        {
            erase();
            xSideLength = newXSideLength;
            ySideLength = newYSideLength;
            draw();
        }
        else
        {
            System.out.println("Enter positive dimensions");
        }
        
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     * @param newColor  the new colour which will painted on the rectangle
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    /*
     * Draw the rectangle with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
                    new Rectangle(xPosition, yPosition, xSideLength, ySideLength));
            canvas.wait(10);
        }
    }

    /*
     * Erase the rectangle on screen.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
