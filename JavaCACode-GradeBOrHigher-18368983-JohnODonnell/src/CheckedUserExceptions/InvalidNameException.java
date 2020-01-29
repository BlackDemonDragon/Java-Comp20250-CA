package CheckedUserExceptions;

public class InvalidNameException extends RuntimeException{

    public InvalidNameException(String S){
        super(S);
    }

}
