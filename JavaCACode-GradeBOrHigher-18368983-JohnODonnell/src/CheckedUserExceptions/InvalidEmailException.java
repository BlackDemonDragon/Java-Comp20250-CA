package CheckedUserExceptions;

public class InvalidEmailException extends RuntimeException{

    public InvalidEmailException(String S){
        super(S);
    }

}
