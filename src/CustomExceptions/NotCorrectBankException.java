package CustomExceptions;

public class NotCorrectBankException extends Exception{
    public NotCorrectBankException(){
        super("Service available only for SBI and ICIC bank");
    }

    public NotCorrectBankException(String message){
        super(message);
    }
}
