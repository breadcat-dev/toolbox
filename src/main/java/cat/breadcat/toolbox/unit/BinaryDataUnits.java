package cat.breadcat.toolbox.unit;

/**
 * Binary data size constants using base-2 (1024) units.
 *
 * <p>Used for memory and storage size calculations</p>
 */
public final class BinaryDataUnits
{
    private BinaryDataUnits() {}


    public static final long BYTE = 1;
    public static final long BYTE_BITS = 8;

    public static final long KiB = 1024;
    public static final long MiB = KiB * 1024;
    public static final long GiB = MiB * 1024;
    public static final long TiB = GiB * 1024;
}
