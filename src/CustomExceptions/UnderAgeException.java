package CustomExceptions;
public class UnderAgeException extends Exception{
    static String ourMessage;
    static{
        ourMessage = "Your age is under limit\nYou've to be 18 or above to create a bank Account";
    }
    public UnderAgeException(){
        super(ourMessage);
    }

    public UnderAgeException(String message){
        super(message);
    }
}
