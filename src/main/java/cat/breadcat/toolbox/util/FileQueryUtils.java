package cat.breadcat.toolbox.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public final class FileQueryUtils
{
    private FileQueryUtils() {}

    private static Stream<Path> walkStream(Path path) throws IOException
    {
        return Files.walk(path);
    }

    public static Stream<Path> list(Path path) throws IOException
    {
        return Files.list(path);
    }
    public static List<Path> walk(Path path) throws IOException
    {
        try(Stream<Path> stream = walkStream(path))
        {
            return stream.toList();
        }
    }
    public static List<Path> files(Path path) throws IOException
    {
        try(Stream<Path> stream = walkStream(path))
        {
            return stream.filter(Files::isRegularFile).toList();
        }
    }
    public static List<Path> directories(Path path) throws IOException
    {
        try(Stream<Path> stream = walkStream(path))
        {
            return stream.filter(Files::isDirectory).toList();
        }
    }
    public static List<Path> resolveFiles(Collection<Path> paths) throws IOException
    {
        Set<Path> result = new LinkedHashSet<>();

        for (Path path : paths)
        {
            if (!exists(path))
                throw new NoSuchFileException(path.toString());

            if(isFile(path))
                result.add(path);
            else if(isDirectory(path))
                result.addAll(files(path));
        }

        return new ArrayList<>(result);
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
