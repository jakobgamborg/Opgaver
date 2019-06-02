import java.util.ArrayList;

public class Webshop {

    private int identifikationNumber;
    private int authenticationNumber;
    private ArrayList<Basket> baskets;
    private Catalog catalog;

    public void addProductToBasket (int produktID, int basketID, int amount) {
        Basket basket = getBasketByID(basketID);
        ProductDescription productDescription = catalog.findProductDescription(produktID);
        Product product = new Product(amount, productDescription);
        basket.addToCollection(product);
    }

    private Basket getBasketByID(int basketID) {
        for (Basket basket: baskets) {
            if (basket.getBasketID() == basketID) {
                return basket;
            }
        }
        return null;
    }
}
