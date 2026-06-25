package cat.breadcat.toolbox.utils;

public final class StringUtil
{
    private StringUtil() {}


    public static boolean isEmpty(String text)
    {
        return text == null || text.isBlank();
    }

    public static String join(Object... args)
    {
        if (ArgsUtil.isEmpty(args))
            return "";

        StringBuilder builder = new StringBuilder();

        for (Object arg : args)
        {
            if (!builder.isEmpty())
                builder.append(' ');

            builder.append((arg == null) ? "(null)" : arg);
        }

        return builder.toString();
    }
}
