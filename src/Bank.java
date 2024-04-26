import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customerList = new ArrayList<>();
    public void addCustomer(Customer customer) { customerList.add(customer); }
    public void removeCustomer(Customer customer) { customerList.remove(customer);}
    public Customer getCustomer(String pin) {
        Customer customer = null;
        for (Customer e : customerList) {
            if (e.getPin().equals(pin)) customer = e;
        }
        return customer;
    }
    public String getAllCustomers() {
        String output = "*** Customers ***\n";
        for (Customer e : customerList) {
            output+=e.toString();
        }
        return output;
    }
}
