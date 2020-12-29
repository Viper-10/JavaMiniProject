package CustomExceptions;
public class UnderAgeException extends Exception{
    static String ourMessage;
    static{
        ourMessage = "Your age is under limit\nYou've to be 18 or above to create a bank Account";
    }
    UnderAgeException(){
        super(ourMessage);
    }

    UnderAgeException(String message){
        super(message);
    }
}
