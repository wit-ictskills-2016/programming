public class NumberDisplay
{
    private int limit;
    private int value;
    
    public NumberDisplay(int limit)
    {
        this.limit = limit;
        value = 0;
    }
    
    public int getValue()
    {
        return value;
    }
   
    /**
     * Use modular arithmetic to increment value 
     * thus ensuring it always within legal range
     */
    public void incrementValue()
    {
        value = (value + 1) % limit;
    }
    
    public String display()
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
}


    /**
     * We check parameter value is in range
     * If not in range, do nothing
     * @param value is the new value
     */
//     public void setValue(int value)
//     {
//     
//         if(value >= 0 && value < this.limit)
//         {
//             this.value = value;
//         }
//     }