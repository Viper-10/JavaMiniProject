package Essentials;

import java.io.Serializable;

public class ICICCard implements Card, Serializable {
    private static final long serialVersionUID = 6470249712448579374L;
    private int pinNo;
    private final long accNo;
    private final String bankName;

    private static int s_pinNo;
    private static long s_accNo;

    public ICICCard() {
        pinNo = ++s_pinNo;
        accNo = ++s_accNo;
        bankName = "ICIC";
    }

    public ICICCard(ICICCard copy){
        this.pinNo = copy.getPinNo();
        this.accNo = copy.getAccNo();
        this.bankName = copy.getBankName();
    }

    public void setPinNo(int pinNo) {
        this.pinNo = pinNo;
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

    public static void setS_pinNo(int s_pinNo) {
        ICICCard.s_pinNo = s_pinNo;
    }

    public static void setS_accNo(long s_accNo) {
        ICICCard.s_accNo = s_accNo;
    }
}
