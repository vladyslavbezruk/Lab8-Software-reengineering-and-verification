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

    public Customer(String name, String email, Account account, double companyOverdraftDiscount) {
        this(name, "", email, CustomerType.COMPANY, account);
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public Account getAccount() {
        return account;
    }

    public double getCompanyOverdraftDiscount() {
        return companyOverdraftDiscount;
    }
}
