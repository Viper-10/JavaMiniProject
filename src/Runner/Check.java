package Runner;
import Essentials.Account;
import Essentials.Card;

public class Check {
    public static String bankName, receiverBankName;
    public static long accNo, receiverAccountNo;

    /////////////////// Function to check credentials of user///////////////////////
    public static Card checkCardCredentials(){
        System.out.print("\nEnter your Bank Name : ");
        bankName = Main.input.next();

        System.out.print("\nEnter your Account Number : ");
        accNo = getAccNo();

        if(Main.listOfCards.containsKey(new Pair(bankName, accNo)) ){
            Card card = Main.listOfCards.get(new Pair(bankName, accNo));
            System.out.print("Enter the Pin Number : ");
            int pinNo = Main.input.nextInt();

            if(card.checkDetails(pinNo)) {
                card.accessGranted();
                return Main.listOfCards.get(new Pair(bankName, accNo));
            }else{
                return null;
            }

        }else{
            System.out.println("The said Account Number doesn't exist!!!!");
            return null;
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////


    public static Account checkTransferAccountCredentials(){
        System.out.print("\nEnter Bank Name of the receiver: ");
        receiverBankName = Main.input.next();

        System.out.print("\nEnter Account Number of the receiver: ");
        receiverAccountNo = getAccNo();

        if(Main.listOfAccounts.containsKey(new Pair(receiverBankName, receiverAccountNo)) ){
            return Main.listOfAccounts.get(new Pair(receiverBankName, receiverAccountNo));
        }
        else{
            return null;
        }
    }


    static long getAccNo(){
        return Main.input.nextLong();
    }
}
