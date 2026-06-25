package cat.breadcat.toolbox.utils;

public final class ArgsUtil
{
    private ArgsUtil() {}

    public static boolean isEmpty(Object... args)
    {
        return args == null || args.length == 0;
    }
}
