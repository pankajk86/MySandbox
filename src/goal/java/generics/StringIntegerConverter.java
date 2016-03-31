package goal.java.generics;

public class StringIntegerConverter implements TypeConverter<String, Integer> {

    @Override
    public Integer convert(String string) {
        return Integer.parseInt(string);
    }

    @Override
    public String restore(Integer integer) {
        return integer.toString();
    }

}
