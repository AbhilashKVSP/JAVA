package MyBank;

public class Account extends MyBank{
    public String holderName;
    public void printInfo(){
        System.out.println(this.holderName);
        this.accDetails = "Adding Details";
        this.bankDetails = "BankDetails added";
    }
}
