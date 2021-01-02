package Essentials;

import CustomExceptions.NotEnoughBalanceException;
import Runner.Check;
import Runner.Main;
import Runner.Pair;

import static Runner.Main.*;

public interface Card {
    String[] bankName = new String[]{"SBI", "ICIC"};

    void accessGranted();

    boolean checkDetails(int PinNo);

    long getAccNo();

    int getPinNo();

    String getBankName();

    void resetPin();

    Account getAcc();

    default void withDraw() throws NotEnoughBalanceException {
        synchronized (this) {
            Account accessedAccount = listOfAccounts.get(new Pair(getBankName(), getAccNo()));

            if (accessedAccount != null) {
                System.out.print("Enter amount to withdraw: ");

                double withdrawAmount = Main.input.nextDouble();
                double currentBalance = accessedAccount.getAccBalance();

                if (withdrawAmount == 0 || withdrawAmount > currentBalance) {
                    System.out.println("Your account balance is lower than the entered amount.");
                    System.out.println("Aborting withdraw process!!!");
                    throw new NotEnoughBalanceException();
                }

                accessedAccount.setAccBalance(currentBalance - withdrawAmount);
                listOfAccounts.replace(new Pair(Check.bankName, Check.accNo), accessedAccount);
                System.out.println("Amount " + withdrawAmount + " successfully withdrawn!");
            }
        }
    }

    default void deposit() {
        Account accessedAccount = listOfAccounts.get(new Pair(getBankName(), getAccNo()));
        if (accessedAccount != null) {
            System.out.println("Enter amount to deposit: ");
            double depositAmount = Main.input.nextDouble();
            double currentBalance = accessedAccount.getAccBalance();
            accessedAccount.setAccBalance(currentBalance + depositAmount);
            System.out.println("An amount of " + depositAmount + " Rs has been deposited successfully!!!");
        }
    }

    default void checkBalance(){
        Account accessedAccount = listOfAccounts.get(new Pair(getBankName(), getAccNo()));
        if (accessedAccount != null){
            double currentBalance = accessedAccount.getAccBalance();
            System.out.println("Your current balance is " + currentBalance + " Rs.");
        }
    }
    default void transfer (Account receiverAccount) throws NotEnoughBalanceException {
        synchronized (this) {
            Account accessedAccount = listOfAccounts.getOrDefault(new Pair(getBankName(), getAccNo()), null);

            if (accessedAccount != null && receiverAccount != null) {
                System.out.println("Enter amount to be transferred:");
                double transferAmount = Main.input.nextDouble();

                if (transferAmount == 0) {
                    System.out.println("Aborting withdraw process!!!");
                    return;
                }
                if (transferAmount > accessedAccount.getAccBalance()){
                    System.out.println("Aborting withdraw process!!!");
                    System.out.println("Your account balance is lower than the entered amount");
                    throw new NotEnoughBalanceException();
                }

                receiverAccount.setAccBalance(receiverAccount.getAccBalance() + transferAmount);
                accessedAccount.setAccBalance(accessedAccount.getAccBalance() - transferAmount);
                listOfAccounts.replace(new Pair(Check.bankName, Check.accNo), accessedAccount);
                listOfAccounts.replace(new Pair(Check.receiverBankName, Check.receiverAccountNo), receiverAccount);
                System.out.println("Amount of Rs. " + transferAmount + " successfully transferred!");
            }
        }
    }
}
