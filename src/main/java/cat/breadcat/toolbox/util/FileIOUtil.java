package cat.breadcat.toolbox.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public final class FileIOUtil
{
    private FileIOUtil() {}


    public static void createDirectories(Path path) throws IOException
    {
        Path parent = path.getParent();

        if(parent != null)
            Files.createDirectories(path.getParent());
    }

    public static void copy(Path src, Path dst) throws IOException
    {
        Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
    }

    public static void move(Path src, Path dst) throws IOException
    {
        Files.move(src, dst, StandardCopyOption.COPY_ATTRIBUTES);
    }

    public static void delete(Path path) throws IOException
    {
        Files.delete(path);
    }
}
