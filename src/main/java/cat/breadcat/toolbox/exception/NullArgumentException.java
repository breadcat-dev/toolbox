package cat.breadcat.toolbox.exception;

public class NullArgumentException extends IllegalArgumentException
{
    public NullArgumentException(String message)
    {
        super(message);
    }

    public NullArgumentException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
