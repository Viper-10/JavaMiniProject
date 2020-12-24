package Essentials;

public class SBICard implements Card{
    private final String bankName;
    private final int pinNo;
    private long accNo;
    private static int s_pinNo;
    private static long s_accNo;

    public SBICard() {
        pinNo = ++s_pinNo;
        accNo = ++s_accNo;
<<<<<<< HEAD
        bankName = "SBI";
=======
>>>>>>> 37c94c7664d96e83cf6514e22fdfd499c9282c0b
    }

    @Override
    public int getPinNo() {
        return pinNo;
    }

    @Override
    public long getAccNo() {
        return accNo;
    }

    @Override
<<<<<<< HEAD
    public String getBankName() {
        return bankName;
    }

    @Override
    public void accessGranted(){
        System.out.println("ACCESS GRANTED");
    }
=======
    public void accessGranted(){
        System.out.println("ACCESS GRANTED");
    }

>>>>>>> 37c94c7664d96e83cf6514e22fdfd499c9282c0b


    @Override
    public boolean checkDetails(int pinNo){

        if(pinNo != this.pinNo) {
            System.out.println("ACCESS DENIED, WRONG PIN NUMBER!!!");
            return false;
        }

<<<<<<< HEAD
        return true;
=======

>>>>>>> 37c94c7664d96e83cf6514e22fdfd499c9282c0b
    }
}
