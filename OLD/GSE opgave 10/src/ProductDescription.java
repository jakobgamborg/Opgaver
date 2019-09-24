public class ProductDescription
{
    private int productID;
    private String description;
    private double price;
    private int standardAmount;
    private int stock;

    public ProductDescription(int productID, String description, double price, int standardAmount, int stock) {
        this.productID = productID;
        this.description = description;
        this.price = price;
        this.standardAmount = standardAmount;
        this.stock = stock;
    }

    public int getProductID() {
        return productID;
    }

    public double getPrice () {
        return price;
    }

    public int getAmount() {
        return standardAmount;
    }
}
