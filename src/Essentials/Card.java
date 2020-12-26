package Essentials;
public interface Card{
    String[] bankName = new String[]{"SBI", "ICIC"};

    void accessGranted();
    boolean checkDetails(int PinNo);
    long getAccNo();
    int getPinNo();
    String getBankName();

    public void resetPin();
    public Account getAcc();

}
