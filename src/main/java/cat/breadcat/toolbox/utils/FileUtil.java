package cat.breadcat.toolbox.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileUtil
{
    private FileUtil() {}


    public static void createDirectories(Path path)
    {
        try
        {
            Path parent = path.getParent();

            if(parent != null && !Files.exists(path.getParent()))
            {
                Files.createDirectories(path.getParent());
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException("Failed to create Directories: " + path, e);
        }
    }
}
