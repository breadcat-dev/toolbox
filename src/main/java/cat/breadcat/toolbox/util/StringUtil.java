package cat.breadcat.toolbox.util;

import cat.breadcat.toolbox.exception.NullArgumentException;

/**
 * String utility functions.
 *
 * <p>Includes safe joining and basic checks.</p>
 */
public final class StringUtil
{
    private StringUtil() {}


    public static boolean isEmpty(String text)
    {
        return text == null || text.isBlank();
    }

    public static String join(String delimiter, Object... args)
    {
        int estimatedSize = 0;

        for(Object arg : args)
        {
            if(arg == null)
                throw new NullArgumentException("Argument cannot be null");

            estimatedSize += arg.toString().length();
        }

        estimatedSize += Math.max(0, args.length - 1) * delimiter.length();


        StringBuilder builder = new StringBuilder(estimatedSize);

        boolean first = true;

        for (Object arg : args)
        {
            if (!first)
                builder.append(delimiter);
            else
                first = false;

            builder.append(arg);
        }


        return builder.toString();
    }

    public static String join(String delimiter, String[] args)
    {
        int estimatedSize = 0;

        for(String arg : args)
        {
            if(arg == null)
                throw new NullArgumentException("Argument cannot be null");

            estimatedSize += arg.length();
        }

        estimatedSize += Math.max(0, args.length - 1) * delimiter.length();


        StringBuilder builder = new StringBuilder(estimatedSize);

        boolean first = true;

        for (String arg : args)
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
