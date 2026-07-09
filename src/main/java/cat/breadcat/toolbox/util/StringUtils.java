package cat.breadcat.toolbox.util;

import cat.breadcat.toolbox.exception.NullArgumentException;

public final class StringUtils
{
    private StringUtils() {}


    public static boolean isEmpty(String text)
    {
        return text == null || text.isBlank();
    }

    public static String join(String delimiter, Object... args)
    {
        int estimatedSize = 0;
        for(int i = 0; i < args.length; i++)
        {
            if(args[i] == null)
                throw new NullArgumentException("args[" + i + "]");

            estimatedSize += args[i].toString().length();
        }

        estimatedSize += Math.max(0, args.length - 1) * delimiter.length();


        StringBuilder builder = new StringBuilder(estimatedSize);
        boolean first = true;
        for(Object arg : args)
        {
            if (!first)
                builder.append(delimiter);
            else
                first = false;

            builder.append(arg);
        }

        return builder.toString();
    }
}
