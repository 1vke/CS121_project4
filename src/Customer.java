import java.util.ArrayList;
import java.util.LinkedList;

public class Customer {
    private String firstName, lastName, pin;
    private LinkedList<Account> accountList = new LinkedList<>(); // Changed from array list to Linked List
    
    public LinkedList<Account> getAccountList() {return accountList;}
    
    public String getPin() {
        return pin;
    }

    public void addAccount(boolean isSavingsAccount, double initAmount) {
        Account acc;

        if (isSavingsAccount) {
            acc = new SavingsAccount(initAmount);
        } else {
            acc = new CheckingAccount(initAmount);
        }

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
