public class CheckingAccount extends Account {
    private final double interestRate = 1.01;

    public CheckingAccount(double initBalance) {
        super(initBalance);
    }

    @Override
    public String toString() {
        return String.format("Checking %s", super.toString());
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Due to the account being a checking account,\n the bank has given 1% interest.");
        super.withdraw(amount * interestRate);
    }
}