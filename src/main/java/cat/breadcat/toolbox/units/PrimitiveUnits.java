package cat.breadcat.toolbox.units;

public final class PrimitiveUnits
{
    private PrimitiveUnits() {}


    public static final int BYTE = DataUnits.BYTE;
    public static final int SHORT = 2 * DataUnits.BYTE;
    public static final int INT = 4 * DataUnits.BYTE;
    public static final int LONG = 8 * DataUnits.BYTE;

    public static final int FLOAT = 4 * DataUnits.BYTE;
    public static final int DOUBLE = 8 * DataUnits.BYTE;

    public static final int CHAR  = 2 * DataUnits.BYTE;
}
