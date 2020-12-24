package Essentials;

public class ICICCard implements Card{
    private final int pinNo;
    private long accNo;
<<<<<<< HEAD
    private final String bankName;

    private static int s_pinNo;
    private static long s_accNo;

    public ICICCard() {
        pinNo = ++s_pinNo;
        accNo = ++s_accNo;
        bankName = "ICIC";
=======


    private static int s_pinNo;
    private static long s_accNo;

    public ICICCard() {
        pinNo = ++s_pinNo;
        accNo = ++s_accNo;
>>>>>>> 37c94c7664d96e83cf6514e22fdfd499c9282c0b
    }

    @Override
    public void accessGranted() {
<<<<<<< HEAD
        System.out.println("ACCESS GRANTED");
=======
>>>>>>> 37c94c7664d96e83cf6514e22fdfd499c9282c0b
    }

    @Override
    public boolean checkDetails(int pinNo) {
        if(pinNo != this.pinNo) {
            System.out.println("ACCESS DENIED, WRONG PIN NUMBER!!!");
            return false;
        }

        return true;
    }
<<<<<<< HEAD

    @Override
    public String getBankName() {
        return bankName;
    }

=======
>>>>>>> 37c94c7664d96e83cf6514e22fdfd499c9282c0b
    @Override
    public int getPinNo() {
        return pinNo;
    }

    @Override
    public long getAccNo() {
        return accNo;
    }
}
