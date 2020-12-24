package Essentials;
public interface Card {
    String[] bankName = new String[]{"SBI", "ICIC"};

<<<<<<< HEAD
    void accessGranted();
    boolean checkDetails(int PinNo);
    long getAccNo();
    int getPinNo();
    String getBankName();
=======
    public abstract void accessGranted();
    public abstract void checkDetails();
    public abstract long getAccNo();
    public abstract int getPinNo();
>>>>>>> 37c94c7664d96e83cf6514e22fdfd499c9282c0b


}
