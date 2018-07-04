package goal.arrays;

public class RightBitManipulation {

    /**
     * To turn off the rightmost 1-bit in a word (passed as a {@code String}). <br/>
     * 
     * btoi & (btoi - 1), where
     * 
     * btoi = Integer.parseInt(word, 2)
     * 
     * @param bString
     *            A word string
     */
    public static void turnOffRightOneBit(String bString) {
        int btoi = Integer.parseInt(bString, 2);
        System.out.println("Binary: " + bString + ", integer: " + btoi);
        int number = btoi & (btoi - 1);
        System.out.println("Binary: " + Integer.toBinaryString(number) + ", integer: " + number);
        int number2 = number & (number - 1);
        System.out.println("Binary: " + Integer.toBinaryString(number2) + ", integer: " + number2);
        int number3 = number2 & (number2 - 1);
        System.out.println("Binary: " + Integer.toBinaryString(number3) + ", integer: " + number3);
        int number4 = number3 & (number3 - 1);
        System.out.println("Binary: " + Integer.toBinaryString(number4) + ", integer: " + number4);
    }

}
