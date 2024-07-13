package facebook;

import java.util.ArrayList;
import java.util.List;

public class ProductOfLastKNumbers {
    public static void main(String[] args) {
        ProductOfNumbers obj = new ProductOfNumbers();
        obj.add(3);
        obj.add(0);
        obj.add(2);
        obj.add(5);
        obj.add(4);

        System.out.println(obj.getProduct(2));
        System.out.println(obj.getProduct(3));
        System.out.println(obj.getProduct(4));

        obj.add(8);
        System.out.println(obj.getProduct(2));
    }
}


class ProductOfNumbers {

    private List<Integer> products = new ArrayList<>();
    private int prod = 1;

    public ProductOfNumbers() {

    }

    public void add(int num) {
        if (num > 0) {
            prod *= num;
            products.add(prod);
        } else {
            prod = 1;
            products = new ArrayList<>();
        }
    }

    public int getProduct(int k) {
        int n = products.size();
        if (n < k) return 0;
        if (n == k) return products.get(n - 1);
        return products.get(n - 1) / products.get(n - k - 1);
    }
}
