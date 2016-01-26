
public class TestStrings
{
    String s0;
    String s1;

    public TestStrings()
    {
        s0 = new String("ICTSkills Group");
        s1 = new String("ICTSkills group");
    }

    /*
     * Check if s0 and s1 are equal
     * @return true if s0 and s1 equal else false
     */
    public boolean equals()
    {
            return s0.equals(s1);
    }

    /*
     * Check if s0 and s1 equal ignoring case
     * @return true if s0 and s1 equal else false
     */
    public boolean equalsIgnoreCase()
    {
            return s0.equalsIgnoreCase(s1);
    }

    /*
     * Return concatenation of s0, s1 and s
     * @param s string to be concatenated with instance variable strings
     * @return the composite string
     */
    public String stringConcat(String s)
    {
        return s0.concat(s1).concat(s);
        //alternatively: return s0 + s1 + s;
    }

    /*
     * @param sDouble is String representation of a primitive double e.g. "100.345"
     * @return param converted to double
     */
    public double convertToDouble(String sDouble)
    {
        return Double.parseDouble(sDouble);
    }

    /*
     * @param sInteger is String representation of a primitive int e.g. "100"
     * @return param converted to int
     */
    public int  convertToInteger(String sInteger)
    {
        return Integer.parseInt(sInteger);
    }

    /*
     * @param number to be converted to a String
     * @return param converted to String
     */
    public String convertToString(int number)
    {
        return Integer.toString(number);
        //alternatively: return String.valueOf(number);
        //alternatively: return "" + number;
    }
}