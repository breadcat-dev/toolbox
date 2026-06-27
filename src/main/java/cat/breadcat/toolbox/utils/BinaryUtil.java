package cat.breadcat.toolbox.utils;

public final class BinaryUtil
{
    private BinaryUtil() {}


    public static void setBit(long bits, int bit)
    {
        bits = bits | (1L << bit);
    }

    public static void clearBit(long bits, int bit)
    {
        bits = bits & ~(1L << bit);
    }

    public static boolean getBit(long bits, int bit)
    {
        return (bits & (1L << bit)) != 0;
    }
}
