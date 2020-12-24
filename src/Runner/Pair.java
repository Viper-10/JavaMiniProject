package Runner;

public class Pair {
    String bankName;
    long accNo;

    Pair(){
        bankName = null;
        accNo = 0;
    }

    public Pair(String bankName, long accNo) {
        this.bankName = bankName;
        this.accNo = accNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public long getAccNo() {
        return accNo;
    }

    public void setAccNo(long accNo) {
        this.accNo = accNo;
    }
}
