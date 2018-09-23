package goal.design.system.lrucache;

public class LRUCacheTest {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.set(1, "Pankaj Kumar");
        cache.set(2, "Sushil Kumar");
        cache.set(3, "Neelam Kumari");
        cache.set(4, "Arun Kumar");

        System.out.println(cache.get(3));
        System.out.println(cache.get(1));

        cache.set(5, "Maa");
        System.out.println("LRU Cache working!!");
    }

}
