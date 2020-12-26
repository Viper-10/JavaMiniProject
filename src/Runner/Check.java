package Runner;
import Essentials.Account;
import Essentials.Card;

public class Check {
    public static String bankName;
    public static long accNo;
    public static Account checkCardCredentials(){
        System.out.print("\nEnter your Bank Name : ");
        bankName = Main.input.next();

        System.out.print("\nEnter your Account Number : ");
        accNo = getAccNo();

        if(Main.listOfCards.containsKey(new Pair(bankName, accNo)) ){
            Card c = Main.listOfCards.get(new Pair(bankName, accNo));
            System.out.print("Enter the Pin Number : ");
            int pinNo = Main.input.nextInt();

            if(c.checkDetails(pinNo)) {
                c.accessGranted();
                return Main.listOfAccounts.get(new Pair(bankName, accNo));
            }else{

                return null;
            }

        }else{
            System.out.println("The said Account Number doesn't exist!!!!");
            return null;
        }
    }

    static long getAccNo(){
        return Main.input.nextLong();
    }
}
