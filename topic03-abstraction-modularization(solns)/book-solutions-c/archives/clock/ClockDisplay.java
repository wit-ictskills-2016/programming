
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayTime;

    public ClockDisplay()
    {
        hours   = new NumberDisplay(24);
        minutes = new NumberDisplay(60); 
        updateDisplay();
    }

    public void timeTick()
    {
        minutes.incrementValue();
        //when minutes value is zero it means time to increment hours
        if(minutes.getValue() == 0)
        {
            hours.incrementValue();
        }
        updateDisplay();
    }

    public void updateDisplay()
    {

        displayTime = hours.display() + ":" + minutes.display();
    }

    public String getTime()
    {
        return displayTime;
    }

}

