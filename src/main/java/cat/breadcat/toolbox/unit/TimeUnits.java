package cat.breadcat.toolbox.unit;

/**
 * Time constants up to a day.
 */
public final class TimeUnits
{
    private TimeUnits() {}


    public static final int SECOND = 1;
    public static final int MINUTE = SECOND * 60;
    public static final int HOUR = MINUTE * 60;
    public static final int DAY = HOUR * 24;
}
