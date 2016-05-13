package goal.algorithms.hashing;

public class MyHashMapTest {

    public static void main(String[] args) {

        MyHashMap<String, String> map = new MyHashMap<String, String>();
        map.put("1a2b", "Pankaj Kumar");
        map.put("2b1a", "Sushil Kumar");
        map.put("1a2b", "Neelam Kumari");

        System.out.println("===" + map.size() + "===");
        System.out.println(map.get("1a2b"));

        map.remove("2b1a");
        System.out.println(map.size());
    }

}
