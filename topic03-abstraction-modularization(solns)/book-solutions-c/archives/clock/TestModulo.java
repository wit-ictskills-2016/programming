public class TestModulo
{
    int limit;
    int value;

    public void testIncrementValue(int limit, int value)
    {
        this.limit = limit;
        this.value = value;
        incrementValue();
        System.out.println("Limit: "+this.limit + "  Value: "+this.value);     
    }

    private void incrementValue()
    {
        value += 1;
        if(value >= limit)
        {
          //more general: value = value - (value/limit)*limit;
          value = 0;
        }     
    }
}