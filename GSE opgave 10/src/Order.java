public class Order {

    private String delieveryAdress;
    private double destributionPrice;
    private double charges;
    private double memberDiscount;
    private double totalPrice;
    private double pointEarned;
    private String status;

    public Order(String delieveryAdress, double destributionPrice, double charges, double memberDiscount, double totalPrice, double pointEarned, String status) {
        this.delieveryAdress = delieveryAdress;
        this.destributionPrice = destributionPrice;
        this.charges = charges;
        this.memberDiscount = memberDiscount;
        this.totalPrice = totalPrice;
        this.pointEarned = pointEarned;
        this.status = status;
    }
}
