package Runner;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Pair implements Serializable {
    @Serial
    private static final long serialVersionUID = 2759876889545802481L;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return accNo == pair.accNo && pair.getBankName().equals(bankName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName) + Objects.hash(accNo);
    }
}
