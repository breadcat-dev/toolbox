package cat.breadcat.toolbox.utils;

public final class PrimitiveUtil
{
    private PrimitiveUtil() {}


    public static int booleanToInt(boolean value)
    {
        return value ? 1 : 0;
    }

    public static boolean intToBoolean(int value)
    {
        return value == 1;
    }
}
