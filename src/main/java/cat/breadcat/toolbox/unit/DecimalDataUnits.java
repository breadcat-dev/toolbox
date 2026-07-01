package cat.breadcat.toolbox.unit;

/**
 * Decimal data size constants using base-10 (1000) units.
 *
 * <p>Used for memory sizes and binary file calculations.</p>
 */
public final class DecimalDataUnits
{
    private DecimalDataUnits() {}


    public static final long KB = 1000;
    public static final long MB = KB * 1000;
    public static final long GB = MB * 1000;
    public static final long TB = GB * 1000;
}
