package cat.breadcat.toolbox.exception;

public class InvalidRangeException extends IllegalArgumentException
{
    public InvalidRangeException()
    {
        super("Invalid range");
    }
    public InvalidRangeException(String context)
    {
        super("Invalid range (" + context + ")");
    }
}
