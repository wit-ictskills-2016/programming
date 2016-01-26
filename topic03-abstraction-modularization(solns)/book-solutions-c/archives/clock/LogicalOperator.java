
public class LogicalOperator
{
    public boolean a()
    {
       return 8 < 9;
    }

    public boolean b()
    {
        return  9 < 8;
    }
 
    public boolean c()
    {
        return !(8 < 9);
    }
    
    public boolean d()
    {
        return !true;
    }
    
    public boolean e()
    {
        return !false;
    }
    
    //Note the internal method call to method a()
    public boolean f()
    {
        return (a() == true);
    }
    
    public boolean g()
    {
        return (a() && b()) == true;
    }  
    
    public boolean h()
    {
        return ((a() || b()) == true);
    }
    
    public boolean j()
    {
        return ((!a() && !b()) == false);
    }
    
    public boolean k()
    {
        return ((!a() || !b()) == false);
    }
    
}
