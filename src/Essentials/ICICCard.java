package Essentials;

public class ICICCard implements Card{
    private final int pinNo;
    private long accNo;
    private final String bankName;

    private static int s_pinNo;
    private static long s_accNo;

    public ICICCard() {
        pinNo = ++s_pinNo;
        accNo = ++s_accNo;
        bankName = "ICIC";
    }

    @Override
    public void accessGranted() {
        System.out.println("ACCESS GRANTED");
    }

    @Override
    public boolean checkDetails(int pinNo) {
        if(pinNo != this.pinNo) {
            System.out.println("ACCESS DENIED, WRONG PIN NUMBER!!!");
            return false;
        }

        return true;
    }

    @Override
    public String getBankName() {
        return bankName;
    }

    @Override
    public int getPinNo() {
        return pinNo;
    }

    @Override
    public long getAccNo() {
        return accNo;
    }
}
