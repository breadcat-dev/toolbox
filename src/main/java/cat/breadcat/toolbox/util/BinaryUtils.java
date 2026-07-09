package cat.breadcat.toolbox.util;

public final class BinaryUtils
{
    private BinaryUtils() {}

    public static long setBit(long bits, int bit)
    {
        return bits | (1L << bit);
    }
    public static long clearBit(long bits, int bit)
    {
        return bits & ~(1L << bit);
    }
    public static boolean getBit(long bits, int bit)
    {
        return (bits & (1L << bit)) != 0;
    }
}
