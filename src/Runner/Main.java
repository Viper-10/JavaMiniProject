package Runner;

import Essentials.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import static Runner.Colors.*;


public class Main {
    public static Scanner input = new Scanner(System.in);
    public static Map<Pair, Account> listOfAccounts = new HashMap<>();
    public static Map<Pair, Card> listOfCards = new HashMap<>();
    public static HashSet<Customer> allCustomers = new HashSet<>();

    public static void main(String[] args) {

        FileSystem.RetriveDataFromFile();
        //setting up fresh account number to generate
        long newNum = 1;
        for(Pair p:listOfAccounts.keySet()){
            newNum = Math.max(newNum,listOfAccounts.get(p).getAccNo());
        }
        ICICCard.setS_accNo(newNum);
        SBICard.setS_accNo(newNum);

        while(true){

            try{
                Thread.sleep(2000);
            } catch(InterruptedException ie){
                System.out.println(ie);
            }

            System.out.println(TEXT_RED + "\n\nALREADY EXISTING ACCOUNTS\n");
            for(Pair p:listOfAccounts.keySet())
                System.out.println(TEXT_YELLOW + "Bank Name: " + TEXT_WHITE + p.bankName + " " + TEXT_YELLOW + " \tAccount Number : " + TEXT_WHITE + listOfAccounts.get(p).getAccNo());

            System.out.println("\n");

            for(Customer c:allCustomers){
                System.out.println(TEXT_YELLOW + "Customer Name  : " + TEXT_WHITE + c.getName() + TEXT_YELLOW + " \t--> Account Number: " + TEXT_WHITE + c.getAcc().getAccNo());
            }

            System.out.println("\n");
            System.out.println("******************************************************************\n\n");


            System.out.println(TEXT_PURPLE + "Select an option: ");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Check balance");
            System.out.println("5. Transfer");
            System.out.println("6. Reset Pin");
            System.out.println("7. Exit\n" + TEXT_RESET);

            int option = input.nextInt();
            System.out.println();

            if(option == 7) {
                FileSystem.StoreDataToFile();
                break;
            }

            switch(option){
                case 1 :
                    System.out.print(TEXT_CYAN + "Enter customer name : ");
                    input.nextLine();
                    String name = input.nextLine();
                    System.out.print("\nEnter customer age : ");
                    int age = input.nextInt();

                    Card tempC = null;
                    boolean correctOption = false;

                    while (!correctOption) {
                        System.out.println(TEXT_BLUE + "\nChoose Bank \n1 for SBI\n2 for ICIC ");
                        System.out.println();

                        int secondOption = input.nextInt();

                        switch (secondOption) {
                            case 1 -> {
                                tempC = new SBICard();
                                correctOption = true;
                            }
                            case 2 -> {
                                tempC = new ICICCard();
                                correctOption = true;
                            }
                            default ->
                                System.out.println(TEXT_RESET + "\nSelect an Appropriate Option!");
                        }
                    }

                    System.out.println(TEXT_RESET + "\n\nAccount Created successfully... ");
                    System.out.print("Your Account Number is : " + tempC.getAccNo());
                    System.out.println("\nYour Pin Number is : " + tempC.getPinNo());

                    // Creating account and customer

                    Account acc = new Account(tempC.getAccNo());
                    Customer customer = new Customer(name,age,tempC,acc);

                    allCustomers.add(customer);
                    listOfAccounts.put(new Pair(tempC.getBankName(), tempC.getAccNo()), acc);
                    listOfCards.put(new Pair(tempC.getBankName(), tempC.getAccNo()), tempC);

                    FileSystem.StoreDataToFile();

                    break;

                case 2:
                    Bank.withDraw();

                    FileSystem.StoreDataToFile();
                    break;

                case 3 :
                    Bank.deposit();

                    FileSystem.StoreDataToFile();

                    break;

                case 4 :
                    Bank.checkBalance();
                    break;

                case 5 :
                    Bank.transfer();
                    FileSystem.StoreDataToFile();
                    break;

                default:
                    System.out.println("Enter a valid option!");

            }
        }
    }
}
