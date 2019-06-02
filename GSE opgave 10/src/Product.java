public class Product {
    private int amount;
    private ProductDescription description;


    public Product(int amount, ProductDescription description) {
        this.amount = amount;
        this.description = description;
    }

    public double calculatePrice (){

        return description.getPrice() * amount;
    }

    public ProductDescription getDescription() {
        return description;
    }
}
