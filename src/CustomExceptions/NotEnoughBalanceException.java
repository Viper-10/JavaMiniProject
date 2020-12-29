package CustomExceptions;

public class NotEnoughBalanceException extends Exception{
    static String ourMessage;

    static{
        ourMessage  = "Not enough Balance";
    }

    public NotEnoughBalanceException(){
        super(ourMessage);
    }

    public NotEnoughBalanceException(String Message){
        super(Message);
    }
}
