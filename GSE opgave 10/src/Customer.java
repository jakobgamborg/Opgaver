public class Customer {

    private String name;
    private String adress;
    private String email;
    private Membership membership;

    public Customer(String name, String adress, String email) {
        this.name = name;
        this.adress = adress;
        this.email = email;
        membership = new Membership();
    }

}
