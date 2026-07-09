package cat.breadcat.toolbox.util;

import java.nio.file.Path;

public final class PathUtils
{
    private PathUtils() {}

    public static String filename(Path path)
    {
        return path.getFileName().toString();
    }
    public static String basename(Path path)
    {
        String filename = filename(path);
        int index = filename.lastIndexOf('.');

        if(index == -1 || index == filename.length() - 1)
            return filename;
        else
            return filename.substring(0, index);
    }
    public static String extension(Path path)
    {
        String filename = filename(path);
        int index = filename.lastIndexOf('.');

        if(index == -1 || index == filename.length() - 1)
            return "";
        else
            return filename.substring(index + 1);
    }
}
