
public class Tree
{
    private Triangle treeBase;
    private Triangle treeMiddle;
    private Triangle treeTop;
    private RectangleBJ treeTrunk;


    public Tree() 
    {
       setTree(1);
    }

    public Tree(int factor) 
    {
        setTree(factor);
    }
  
    private void setTree(int factor)
    {
      createTreeBase(factor);
      createTreeMiddle(factor);
      createTreeTop(factor);
      createTreeTrunk(factor);
    }
    
    public void createTreeBase(int factor)
    {
        int height = 30*factor;
        int width = 50*factor;
        int xPosition = 100*factor;
        int yPosition = 70*factor;
        String color = "green";
        
        treeBase = new Triangle();
        treeBase.setState(height, width, xPosition, yPosition, color);
    }
    
   public void createTreeMiddle(int factor)
    {
        int height = 30*factor;
        int width = 45*factor;
        int xPosition = 100*factor;
        int yPosition = 55*factor;
        String color = "green";
        
        treeMiddle = new Triangle();
        treeMiddle.setState(height, width, xPosition, yPosition, color);
    }
    
   public void createTreeTop(int factor)
    {
        int height = 30*factor;
        int width = 40*factor;
        int xPosition = 100*factor;
        int yPosition = 40*factor;
        String color = "green";
        
        treeTop = new Triangle();
        treeTop.setState(height, width, xPosition, yPosition, color);
    }
     
    public void createTreeTrunk(int factor)
    {
        int xSideLen = 3*factor;
        int ySideLen = 30*factor;
        int xPosition = 100*factor;
        int yPosition = 100*factor;
        String color = "black";
        
        treeTrunk = new RectangleBJ();
        treeTrunk.setState(xSideLen, ySideLen, xPosition, yPosition, color);
    }
    
    /**
     * Refer to Figure 1, step 9, lab session 3
     */
    public void moveTo(int x, int y)
    {
     //we require the heights of each triangle to calculate 
     //the coordinate of each apex following move
     int heightBase = treeBase.getHeight();
     int heightMiddle = treeMiddle.getHeight();
     int heightTop = treeTop.getHeight();
     //these are the y coordinates of each tree segment relative to 
     //the coordinates of the tree trunk
     //note the coordinates of the tree trunk refer to the top of the trunk
     int yBase = y - heightBase;
     int yMiddle = yBase - heightBase/2;
     int yTop = yMiddle - heightMiddle/2;
    
     treeTrunk.moveTo(x, y);
     treeBase.moveTo(x, yBase);
     treeMiddle.moveTo(x, yMiddle);
     treeTop.moveTo(x, yTop);
       
    }
    
    public void display(boolean show)
    {
        if(show)
        {
            treeBase.makeVisible();
            treeMiddle.makeVisible();
            treeTop.makeVisible();
            treeTrunk.makeVisible();
        }
        else
        {
            treeBase.makeInvisible();
            treeMiddle.makeInvisible();
            treeTop.makeInvisible();
            treeTrunk.makeInvisible();
        }
    }
}
