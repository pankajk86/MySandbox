package goal.java.generics;

public interface TypeConverter<T1, T2> {

    public T2 convert(T1 t);

    public T1 restore(T2 t);
}
