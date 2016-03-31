package goal.java.generics;

import java.util.Arrays;
import java.util.List;

public class BoundedGenericsTest {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        System.out.println("Integer Sum: " + sumInteger(intList) + ", Double Sum: " + sumDouble(intList));

        List<Double> doubleList = Arrays.asList(2.3, 4.5, 6.5);
        System.out.println("Integer Sum: " + sumInteger(doubleList) + ", Double Sum: " + sumDouble(doubleList));
    }

    public static double sumDouble(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static int sumInteger(List<? extends Number> list) {
        int sum = 0;
        for (Number n : list) {
            sum += n.intValue();
        }
        return sum;
    }
}
