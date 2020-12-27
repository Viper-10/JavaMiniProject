package Essentials;

import Runner.Check;
import Runner.Main;
import Runner.Pair;
import static Runner.Main.listOfAccounts;

public abstract class Bank{
    public static String bankName, receiverBankName;
    public static long accNo, receiverAccountNo;

    static long getAccNo(){
        return Main.input.nextLong();
    }

    public static Account checkTransferAccountCredentials(){
        System.out.print("\nEnter Bank Name of the receiver: ");
        receiverBankName = Main.input.next();

        System.out.print("\nEnter Account Number of the receiver: ");
        receiverAccountNo = getAccNo();

        return Main.listOfAccounts.getOrDefault(new Pair(receiverBankName, receiverAccountNo), null);
    }
    public static Account checkCardCredentials(){
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
                return listOfAccounts.get(new Pair(bankName, accNo));
            }else{
                return null;
            }

        }else{
            System.out.println("The said Account Number doesn't exist!!!!");
            return null;
        }
    }

        /////////////////// Function to withdraw amount from bank///////////////////////
    public static void withDraw() {
        Account accessedAccount = checkCardCredentials();

        if(accessedAccount != null){
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
    ///////////////////////////////////////////////////////////////////////////////////////////


    /////////////////// Function to deposit amount to bank///////////////////////
    public static void deposit() {
        Account accessedAccount = checkCardCredentials();

        if(accessedAccount != null){
            System.out.println("Enter amount to deposit:");
            double depositAmount = Main.input.nextDouble();
            double currentBalance = accessedAccount.getAccBalance();
            accessedAccount.setAccBalance(currentBalance + depositAmount);
            System.out.println("An amount of " + depositAmount + " Rs has been deposited successfully!!!");
            listOfAccounts.replace(new Pair(Check.bankName, Check.accNo), accessedAccount);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////




    /////////////////// Function to check current balance///////////////////////
    public static void checkBalance() {
        Account accessedAccount = checkCardCredentials();
        if (accessedAccount != null){
            double currentBalance = accessedAccount.getAccBalance();
            System.out.println("Your current balance is " + currentBalance + " Rs.");
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////




    /////////////////// Function to transfer amount to another account///////////////////////
    public static void transfer(){
        Account accessedAccount = checkCardCredentials();

        if (accessedAccount != null){
            Account receiverAccount = checkTransferAccountCredentials();

            if (receiverAccount != null){
                boolean validAmount = false;
                System.out.println("Enter amount to be transferred:");

                while (!validAmount) {
                    double transferAmount = Main.input.nextDouble();

                    if (transferAmount==0) {
                        System.out.println("Aborting withdraw process!!!");
                        break;
                    }

                    double currentBalance = accessedAccount.getAccBalance();
                    double currentReceiverBalance = receiverAccount.getAccBalance();

                    if (currentBalance>=transferAmount){
                        receiverAccount.setAccBalance(currentReceiverBalance + transferAmount);
                        accessedAccount.setAccBalance(currentBalance - transferAmount);
                        listOfAccounts.replace(new Pair(Check.bankName, Check.accNo), accessedAccount);
                        listOfAccounts.replace(new Pair(Check.receiverBankName, Check.receiverAccountNo), receiverAccount);
                        System.out.println("Amount of Rs. "+transferAmount+" successfully transferred!");
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
    ///////////////////////////////////////////////////////////////////////////////////////////
}
