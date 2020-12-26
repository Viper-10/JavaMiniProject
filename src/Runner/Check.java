package Runner;
import Essentials.Card;
import Essentials.Account;
import Runner.Main.*;

public class Check {
    static Account checkCardCredentials(){
        System.out.print("\nEnter your Bank Name : ");
        String bankName = Main.input.next();

        System.out.print("\nEnter your Account Number : ");
        long accNo = getAccNo();

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
