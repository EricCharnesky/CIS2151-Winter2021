
package exceptions;

public class CustomException extends Exception {
    
    // optional - if you want a customer string message on the error
    public CustomException(String message)
    {
        super(message);
    }
}
