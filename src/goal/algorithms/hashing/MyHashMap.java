package goal.algorithms.hashing;

/**
 * @author pankaj kumar
 *
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    // private static final float LOAD_FACTOR = 0.75f;
    private static int size;

    private Entry<K, V>[] table; // array of Entry

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }

    private int getHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int getIndex(int h) {
        return h & (DEFAULT_CAPACITY - 1);
    }

    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        int hash;

        Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Adds the <K, V> pair to MyHashMap.
     * 
     * @param key
     *            K to be added
     * @param value
     *            V associated with the Key
     */
    public void put(K key, V value) {
        if (key == null) {
            return;
        }

        int hash = key.hashCode();
        hash = getHash(hash);
        int index = getIndex(hash);

        // created a new entry
        Entry<K, V> entry = new Entry<K, V>(hash, key, value, null);

        if (table[index] == null) {
            table[index] = entry;
        } else {
            Entry<K, V> previous = null;
            for (Entry<K, V> e = table[index]; e != null; e = e.next) {
                previous = e;
                if (e.hash == hash && (e.key == key || e.key.equals(key))) {
                    e.value = value;
                    return;
                }
            }

            previous.next = entry;
        }
        size++;
    }

    /**
     * Gets the Value associated with the key, if it exists.
     * 
     * @param key
     *            Key for the value
     * 
     * @return Value V
     */
    public V get(K key) {
        if (key == null) {
            return null;
        }

        int hash = key.hashCode();
        hash = getHash(hash);
        int index = getIndex(hash);

        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (e.hash == hash && (e.key == key || e.key.equals(key))) {
                return e.value;
            }
        }

        return null;
    }

    /**
     * Removes the Value V associated with Key K.
     * 
     * @param key
     */
    public void remove(K key) {
        if (key == null) {
            return;
        }

        int hash = key.hashCode();
        hash = getHash(hash);
        int index = getIndex(hash);
        Entry<K, V> previous = null;
        Entry<K, V> current = table[index];

        while (current != null) {

            if (current.hash == hash && (current.key == key || current.key.equals(key))) {
                if (previous == null) {
                    table[index] = null;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }

            previous = current;
            current = current.next;
        }

    }

    /**
     * @return
     */
    public int size() {
        return size;
    }
}
