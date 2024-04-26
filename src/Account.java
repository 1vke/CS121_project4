public class Account {
    static private int numOfAccounts = 1000;
    private double balance;
    private int accountNum;
    
    public double getBalance() {
        return balance;
    }

    public int getAccountNum() {
        return accountNum;
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.printf("Amount Deposited: $%.2f\nTotal: $%.2f\n", amount, balance);
    }

    public void withdraw(double amount) {
        if (balance-amount >= 0) {
            balance -= amount;
            System.out.printf("Amount Withdrawn: $%.2f\nTotal: $%.2f\n", amount, balance);
        } else System.out.println("Insufficient funds! No withdrawal has taken place");
    }
    
    public String toString() {
        return String.format("Account Number: %d\nBalance: $%.2f\n", accountNum, balance);
    }
    
    public Account(double initBalance) {
        numOfAccounts += 1;
        this.accountNum = numOfAccounts;
        this.balance = initBalance;
    }
}
