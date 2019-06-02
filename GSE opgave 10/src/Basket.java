import java.util.ArrayList;

public class Basket
{
    private ArrayList<Product> productsInBasket;

    private int basketID;

    public Basket() {
        productsInBasket = new ArrayList<>();
    }

    public void addToCollection(Product product){
        productsInBasket.add(product);
    }


    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : productsInBasket) {
            totalPrice += product.getDescription().getPrice();
        }
        return totalPrice;
    }

    public int getBasketID() {
        return basketID;
    }
}
