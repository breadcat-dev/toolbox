package cat.breadcat.toolbox.exception;

public class NullArgumentException extends IllegalArgumentException
{
    public NullArgumentException(String argument)
    {
        super("Argument cannot be null: " + argument);
    }
    public NullArgumentException(String argument, Throwable cause)
    {
        super("Argument cannot be null: " + argument, cause);
    }
}