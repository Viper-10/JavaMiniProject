package Runner;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;
=======
>>>>>>> 37c94c7664d96e83cf6514e22fdfd499c9282c0b
import java.util.Scanner;
import Essentials.*;

public class Main {
    public static Scanner input = new Scanner(System.in);
<<<<<<< HEAD
    public static Map<Pair, Account> listOfAccounts = new HashMap<>();
    public static Map<Pair, Card> listOfCards = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("Enter option 1 to create a customer account");
        System.out.println("Enter option 2 to withdraw money from account");
        System.out.println("Enter option 3 to deposit money from account");
        System.out.println("Enter option 4 to Transfer money from one account to another");
=======
    public static void main(String[] args) {

        System.out.println("Enter option 1 to create a customer account");
>>>>>>> 37c94c7664d96e83cf6514e22fdfd499c9282c0b

        while(true){

            int option = input.nextInt();

            switch(option){
                case 1 : {
                    System.out.print("Enter customer name : ");
                    System.out.print("Enter customer age : ");

                    // initialising just to avoid "tempC might not be initialized error". depending on the user's option it will hold a SBI or ICIC object.

                    Card tempC = new SBICard();

                    boolean correctOption = false;

                    while (!correctOption) {
                        System.out.print("\nWhich bank account would you like to create, 1 for SBI, 2 for ICIC : ");
                        int secondOption = input.nextInt();

                        switch (secondOption) {
<<<<<<< HEAD
                            case 1 -> {
                                tempC = new SBICard();
                                correctOption = true;
                            }
                            case 2 -> {
                                tempC = new ICICCard();
                                correctOption = true;
                            }
                            default ->
                                System.out.println("\nENTER PROPER NUMBERS PLEASE!!!!!!");

=======
                            case 1: {
                                tempC = new SBICard();
                                correctOption = true;
                            }

                            case 2: {
                                tempC = new ICICCard();
                                correctOption = true;
                            }

                            default: {
                                System.out.println("\nENTER PROPER NUMBERS PLEASE!!!!!!");
                            }
>>>>>>> 37c94c7664d96e83cf6514e22fdfd499c9282c0b
                        }
                    }

                    System.out.println("Your Account Number is : " + tempC.getAccNo());
                    System.out.println("Your Pin Number is : " + tempC.getPinNo());
<<<<<<< HEAD

                    listOfCards.put(new Pair(tempC.getBankName(), tempC.getAccNo()), tempC);

                    System.out.println("Would you like to put any balance in the account right now ? Answer in binary");

                    option = input.nextInt();

                    Account acc = new Account(tempC.getAccNo());

                    if(option == 1) {
                        System.out.print("Enter the initial balance amount : ");
                        acc.setAccBalance(input.nextInt());
                    }

                    listOfAccounts.put(new Pair(tempC.getBankName(), tempC.getAccNo()), acc);

                }

                case 2 :{
                    Check.checkCardCredentials();
=======
                }

                case 2 :{

>>>>>>> 37c94c7664d96e83cf6514e22fdfd499c9282c0b
                    break;
                }

                case 3 :{
<<<<<<< HEAD
                    Check.checkCardCredentials();
                    break;
                }

                case 4 :{
                    Check.checkCardCredentials();
=======

>>>>>>> 37c94c7664d96e83cf6514e22fdfd499c9282c0b
                    break;
                }

            }
        }
    }
}
