package cat.breadcat.toolbox.exception;

public class DivisionByZeroException extends ArithmeticException
{
    public DivisionByZeroException()
    {
        super("Cannot divide by zero");
    }
    public DivisionByZeroException(String context)
    {
        super("Cannot divide by zero (" + context + ")");
    }
}
