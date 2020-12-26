package Essentials;

import Runner.Check;
import Runner.Main;
import Runner.Pair;

import static Runner.Main.listOfAccounts;

public abstract class Bank{

    abstract void welcome();

    public static void withDraw() {
        Account accessedAccount = Check.checkCardCredentials();
        if (accessedAccount == null){
        }
        else{
            if (accessedAccount.getAccBalance() == 0){
                System.out.println("Your account balance is 0. You have to deposit first!");
            }
            else{
                boolean validAmount = false;
                System.out.println("Enter amount to withdraw:");
                while (!validAmount){
                    double withdrawAmount = Main.input.nextDouble();
                    if (withdrawAmount==0) {
                        System.out.println("Aborting withdraw process!!!");
                        break;
                    }
                    double currentBalance = accessedAccount.getAccBalance();
                    if (currentBalance>=withdrawAmount){
                        accessedAccount.setAccBalance(currentBalance - withdrawAmount);
                        listOfAccounts.replace(new Pair(Check.bankName, Check.accNo), accessedAccount);
                        System.out.println("Amount "+withdrawAmount+" successfully withdrawn!");
                        validAmount = true;
                    }
                    else{
                        System.out.println("Your account balance is lower than the entered amount.");
                        System.out.println("Enter an valid amount, or press 0 to exit:");
                    }
                }

            }
        }
    }

    public void transfer() {

    }

    public static void deposit() {

        Account accessedAccount2 = Check.checkCardCredentials();

        if (accessedAccount2 == null){
        }

        else{
            System.out.println("Enter amount to deposit:");
            double depositAmount = Main.input.nextDouble();
            double currentBalance = accessedAccount2.getAccBalance();
            accessedAccount2.setAccBalance(currentBalance + depositAmount);
            System.out.println("An amount of " + depositAmount + " Rs has been deposited successfully!!!");
            listOfAccounts.replace(new Pair(Check.bankName, Check.accNo), accessedAccount2);
        }

    }


}
