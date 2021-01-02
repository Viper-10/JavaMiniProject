package Runner;
import CustomExceptions.NotCorrectBankException;
import CustomExceptions.NotEnoughBalanceException;
import Essentials.Account;
import Essentials.Card;

public class Check {
    public static String bankName, receiverBankName;
    public static long accNo, receiverAccountNo;

    /////////////////// Function to check credentials of user///////////////////////
    public static Card checkCardCredentials() throws NotCorrectBankException{
        System.out.print("\nEnter your Bank Name : ");
        bankName = Main.input.next();

        if(!bankName.equals("SBI") && !bankName.equals("ICIC")){
            throw new NotCorrectBankException();
        }

        System.out.print("\nEnter your Account Number : ");
        accNo = getAccNo();

        if(Main.listOfCards.containsKey(new Pair(bankName, accNo)) ){
            Card card = Main.listOfCards.get(new Pair(bankName, accNo));
            System.out.print("Enter the Pin Number : ");
            int pinNo = Main.input.nextInt();

            if(card.checkDetails(pinNo)) {
                card.accessGranted();
                return Main.listOfCards.getOrDefault(new Pair(bankName, accNo), null);
            }else{
                return null;
            }

        }else{
            System.out.println("The said Account Number doesn't exist!!!!");
            return null;
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static Account checkTransferAccountCredentials() throws NotCorrectBankException {
        System.out.print("\nEnter Bank Name of the receiver: ");
        receiverBankName = Main.input.next();

        System.out.print("\nEnter Account Number of the receiver: ");
        receiverAccountNo = Main.input.nextInt();

        return Main.listOfAccounts.getOrDefault(new Pair(receiverBankName, receiverAccountNo), null);
    }

    static long getAccNo(){
        return Main.input.nextLong();
    }
}
