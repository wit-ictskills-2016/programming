public class TestString
{
    int value;
    
    public TestString(int value)
    {
        this.value = value;
    }
    
    public void test()
    {
        System.out.println("Integer.toString : " + display());
        System.out.println("\"\" + value : "+display2());
        System.out.println("value + \"\" : "+display3());
    }
    
    //NumberDisplay display method
    private String display()
    {
        //add a leading zero where necessary
        if(value < 10)
        {
            return "0" + value;
        }
        else
        {
            return Integer.toString(value);
        }
    }
    
    //Replace Integer.toString(value) with  "" + value
    private String display2()
    {
        //add a leading zero where necessary
        if(value < 10)
        {
            return "0" + value;
        }
        else
        {
            return ("" + value);
        }
    }
    //Replace Integer.toString(value) with value + ""
    private String display3()
    {
        //add a leading zero where necessary
        if(value < 10)
        {
            return "0" + value;
        }
        else
        {
            return (value+"");
        }
    }
}
