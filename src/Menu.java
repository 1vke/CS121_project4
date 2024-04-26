import java.util.Scanner;

public class Menu {
    static Bank bank = new Bank();
    static Scanner scnr = new Scanner(System.in);
    
    private void displayMenu() {
        boolean displayingMenu = true;
        
        while(displayingMenu) {
            System.out.println("\n********* MENU *********\n\nPlease make a selection:");
            System.out.println("1) Access Account\n2) Open a New Account\n3) Close All Accounts\n4) Exit");
            System.out.print(">> ");
            String input = scnr.nextLine();
            
            switch (input) {
                case "1" -> accessAccount();
                case "2" -> openNewAccount();
                case "3" -> closeAllAccounts();
                case "4" -> displayingMenu = false;
                default -> System.out.println("Please enter a valid option!");
            }
        }

        System.out.println("Thank you for using BSU Banking app.\nGoodbye!");
    }
    private void accessAccount() {
        System.out.println("Please enter your PIN:");
        String pin = scnr.nextLine();
        
        Customer customer = bank.getCustomer(pin);
        if (customer == null) {
            System.out.println("PIN is invalid");
            return;
        }

        if (customer.getAccountList().size() == 0) {
            System.out.println("No accounts to access!");
            return;
        }
        
        System.out.println(customer.getAllAccounts());

        System.out.print("Please enter the account number\nof the account you would like to access: ");
        int accountNum = Integer.parseInt(scnr.nextLine());
        
        Account account = customer.getAccount(accountNum);
        if (account == null) {
            System.out.println("Account number is invalid.");
            return;
        }
        
        System.out.println("Please make a selection:");
        boolean displayingAcc = true;
        while(displayingAcc) {
            double amount;
            
            System.out.println("1) Make a deposit\n2) Make a withdraw\n3) See account balance\n4) Close account\n5) Exit");
            System.out.print(">> ");
            
            String input = scnr.nextLine();
            switch (input) {
                case "1":
                    System.out.println("Enter the amount of deposit:");
                    amount = Double.parseDouble(scnr.nextLine());
                    account.deposit(amount);
                    break;
                case "2":
                    System.out.println("Enter the amount of withdrawal:");
                    amount = Double.parseDouble(scnr.nextLine());
                    account.withdraw(amount);
                    break;
                case "3":
                    System.out.printf("Balance: $%.2f\n", account.getBalance());
                    break;
                case "4":
                    customer.removeAccount(account);
                    displayingAcc = false;
                    break;
                case "5":
                    displayingAcc = false;
                    break;
                default:
                    System.out.println("Please enter a valid option!");
                    break;
            }
        }
    }
    private void openNewAccount() {
        Customer customer = null;
        String pin;
        Double depositAmount;
        
        boolean decidingNewCustomer = true;
        while (decidingNewCustomer) {
            System.out.println("Are you a new customer?\n1) Yes\n2) No");
            switch (scnr.nextLine()) {
                case "1":
                    customer = makeNewCustomer();
                    bank.addCustomer(customer);
                    decidingNewCustomer = false;
                    break;
                case "2":
                    decidingNewCustomer = false;
                    break;
                default:
                    System.out.println("Please choose a valid option\n");
            }
        }
        
        if (customer == null) {
            System.out.println("Please enter PIN: ");
            pin = scnr.nextLine();
            customer = bank.getCustomer(pin);
            
            if (customer==null) {
                System.out.println("PIN is invalid");
                return;
            }
        }

        System.out.println("Please enter deposit amount:");
        depositAmount = Double.parseDouble(scnr.nextLine());
        
        customer.addAccount(depositAmount);
    }
    private Customer makeNewCustomer() {
        String firstName, lastName, pin;
        
        System.out.println("Please enter your first name:");
        firstName = scnr.nextLine();
        
        System.out.println("Please enter your last name:");
        lastName = scnr.nextLine();

        System.out.println("Please enter a 4 digit pin:");
        pin = scnr.nextLine();
        
        return new Customer(firstName, lastName, pin);
    }
    private void closeAllAccounts() {
        Customer customer;
        String pin;
        
        System.out.println("Please enter a 4 digit pin:");
        pin = scnr.nextLine();
        
        customer = bank.getCustomer(pin);
        if (customer != null) {
            customer.getAccountList().removeAll(customer.getAccountList());
            System.out.println("All accounts closed!");
        } else System.out.println("PIN is invalid");
    }
    public void runMenu() {
        displayMenu();
    }
}
