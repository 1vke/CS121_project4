public class SavingsAccount extends Account {
    private final double interestRate = 1.25;

    public SavingsAccount(double initBalance) {
        super(initBalance);
    }

    @Override
    public String toString() {
        return String.format("Savings %s", super.toString());
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Due to the account being a savings account,\n the bank has taken 25% interest.");
        super.withdraw(amount * interestRate);
    }
}