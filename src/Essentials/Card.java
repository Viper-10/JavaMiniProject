package Essentials;
public interface Card{
    String[] bankName = new String[]{"SBI", "ICIC"};

    void accessGranted();
    boolean checkDetails(int PinNo);
    long getAccNo();
    int getPinNo();
    String getBankName();

    public void withDraw();
    public void deposit();
    public void transfer();
    public void resetPin();
    public Account getAcc();

}
