public class SeparateChainingHashTable<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        Entry(K k, V v, Entry<K, V> n) { key = k; value = v; next = n; }
    }

    private Entry<K, V>[] buckets;
    private int size;
    private static final int INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public SeparateChainingHashTable() {
        buckets = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(K key, V value) {
        int idx = getIndex(key);
        for (Entry<K, V> e = buckets[idx]; e != null; e = e.next) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
        }
        buckets[idx] = new Entry<>(key, value, buckets[idx]);
        size++;
    }

    public V get(K key) {
        int idx = getIndex(key);
        for (Entry<K, V> e = buckets[idx]; e != null; e = e.next) {
            if (e.key.equals(key)) return e.value;
        }
        return null;
    }

    public static void main(String[] args) {
        SeparateChainingHashTable<String, Integer> map = new SeparateChainingHashTable<>();
        map.put("apple", 10);
        map.put("banana", 20);
        System.out.println("apple: " + map.get("apple"));
        System.out.println("banana: " + map.get("banana"));
    }
}
