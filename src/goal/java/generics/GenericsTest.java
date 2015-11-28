package goal.java.generics;

public class GenericsTest {

	public static void main(String[] args) {
		TypeConverter<String, Integer> converter = new StringIntegerConverter();
		String str = "45";
		Integer integer = converter.convert(str);
		System.out.println("Integer value of " + str + " incremented by 1 = " + ( integer + 1 ));
		String string = converter.restore(integer);
		System.out.println("Original String restored = " + string);
	}

}
