package page.objects;

/**
 * Created by Pithas on 23/08/2017.
 */
public class WrongPageException extends RuntimeException {
    public WrongPageException(String message){
        super(message);
    }
}
