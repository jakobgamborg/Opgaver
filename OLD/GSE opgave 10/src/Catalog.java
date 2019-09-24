import java.util.ArrayList;


public class Catalog {

    public ArrayList<ProductDescription> getProducts() {
        return products;
    }

    private ArrayList<ProductDescription> products;

    public Catalog() {
        products = new ArrayList<>();
    }

    public ProductDescription findProductDescription(int produktID) {
        for (int i = 0; i > products.size(); i++) {
          if (products.get(i).getProductID() == produktID)
              return products.get(i);
        }
        return null;
    }

    public void addProductToList (ProductDescription productDescription){
        products.add(productDescription);
    }


}
