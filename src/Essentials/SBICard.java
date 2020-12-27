package Essentials;
import java.io.Serializable;

public class SBICard implements Card, Serializable {
    private static final long serialVersionUID = -1572058113136644630L;
    private final String bankName;
    private int pinNo;
    private final long accNo;
    private static int s_pinNo;
    private static long s_accNo;

    public SBICard() {
        pinNo = ++s_pinNo;
        accNo = ++s_accNo;
        bankName = "SBI";
    }

    public SBICard(ICICCard copy){
        this.pinNo = copy.getPinNo();
        this.accNo = copy.getAccNo();
        this.bankName = copy.getBankName();
    }

    public void setPinNo(int pinNo) {
        this.pinNo = pinNo;
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
    public String getBankName() {
        return bankName;
    }

    @Override
    public void accessGranted(){
        System.out.println("ACCESS GRANTED");
    }


    @Override
    public boolean checkDetails(int pinNo){

        if(pinNo != this.pinNo) {
            System.out.println("ACCESS DENIED, WRONG PIN NUMBER!!!");
            return false;
        }

        return true;
    }

    public static void setS_pinNo(int s_pinNo) {
        SBICard.s_pinNo = s_pinNo;
    }

    public static void setS_accNo(long s_accNo) {
        SBICard.s_accNo = s_accNo;
    }


    @Override
    public void resetPin() {

    }

    @Override
    public Account getAcc() {
        return null;
    }
}
