package Products;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListProduct {
    Scanner scanner=new Scanner(System.in);
    public ArrayList<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(int index) {
        productList.remove(index);
    }

    public Product getProduct(int index) {
        return productList.get(index);
    }

    public int getSize() {
        return productList.size();
    }

}

