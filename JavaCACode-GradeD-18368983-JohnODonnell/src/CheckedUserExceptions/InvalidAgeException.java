package CheckedUserExceptions;

public class InvalidAgeException extends RuntimeException{

    public InvalidAgeException(String S){
        super(S);
    }

}
