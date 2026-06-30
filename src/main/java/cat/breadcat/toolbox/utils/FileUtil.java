package cat.breadcat.toolbox.utils;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public final class FileUtil
{
    private FileUtil() {}


    public static void createDirectories(Path path) throws IOException
    {
        Path parent = path.getParent();

        if(parent != null)
        {
            Files.createDirectories(path.getParent());
        }
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

    public static String filename(Path path)
    {
        return path.getFileName().toString();
    }

    public static Stream<Path> list(Path path) throws IOException
    {
        return Files.list(path);
    }

    public static Stream<Path> walk(Path path) throws IOException
    {
        return Files.walk(path);
    }

    public static Stream<Path> files(Path path) throws IOException
    {
        return walk(path).filter(Files::isRegularFile);
    }

    public static Stream<Path> directories(Path path) throws IOException
    {
        return walk(path).filter(Files::isDirectory);
    }


    public static boolean exists(Path path)
    {
        return path != null && Files.exists(path);
    }

   public static boolean isFile(Path path)
    {
        return Files.isRegularFile(path);
    }

    public static boolean isDirectory(Path path)
    {
        return Files.isDirectory(path);
    }
}
