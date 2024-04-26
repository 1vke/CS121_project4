import java.util.ArrayList;

public class Customer {
    private String firstName, lastName, pin;
    private ArrayList<Account> accountList = new ArrayList<>();
    
    public ArrayList<Account> getAccountList() {return accountList;}
    
    public String getPin() {
        return pin;
    }

    public void addAccount(double initAmount) {
        Account acc = new Account(initAmount);
        accountList.add(acc);
        System.out.printf("Account %d added\n", acc.getAccountNum());
    }
    
    public void removeAccount(Account acc) {
        accountList.remove(acc);
        System.out.printf("Account %d closed\n", acc.getAccountNum());
    }
    
    public Account getAccount(int accountNum) {
        Account acc = null;
        for (Account e : accountList) {
            if (e.getAccountNum() == accountNum) acc = e;
        }
        return acc;
    }
    
    public String getAllAccounts() {
        String output = "***Active Accounts***\n";
        for (Account e : accountList) {
            output += e.toString();
        } 
        return String.format("%s\n", output);
    }
    
    public String toString() {
        return String.format("Name: %s %s, Pin: %s", firstName, lastName, pin);
    }
    
    public Customer(String firstName, String lastName, String pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
    }
}
