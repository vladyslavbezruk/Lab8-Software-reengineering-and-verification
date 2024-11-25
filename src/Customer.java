public class Customer {

    private String name;
    private String surname;
    private String email;
    private CustomerType customerType;
    private Account account;
    private double companyOverdraftDiscount;

    public Customer(String name, String surname, String email, CustomerType customerType, Account account) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.customerType = customerType;
        this.account = account;
        this.companyOverdraftDiscount = 1; // default value
    }

    // Constructor for companies
    public Customer(String name, String email, Account account, double companyOverdraftDiscount) {
        this(name, "", email, CustomerType.COMPANY, account);
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Account getAccount() {
        return account;
    }

    public double getCompanyOverdraftDiscount() {
        return companyOverdraftDiscount;
    }
}
