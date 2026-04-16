

public class MyHashMap<K, V> {

    private Node<K, V>[] table;

    private static class Node<K, V> {
        final int hash;
        K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        table = new Node[16];
    }

    private int hash(Object key) {
        int h = (key == null) ? 0 : key.hashCode();
        return h ^ (h >>> 16);
    }

    private int index(int hash) {
        return hash % 16;
    }

    public V put(K key, V value) {
        int h = hash(key);
        int i = index(h);

        Node<K, V> node = table[i];

        if (node == null) {
            table[i] = new Node<>(h, key, value, null);
            return null;
        }

        Node<K, V> node2 = node;

        while (node2 != null) {

            if (key.equals(node2.key)) {
                V oldvalue = node2.value;
                node2.value = value;
                return oldvalue;
            }

            if (node2.next == null) {
                node2.next = new Node<>(h, key, value, null);
                return null;
            }

            node2 = node2.next;
        }

        return null;
    }

    public V get(Object key) {
        int h = hash(key);
        int indx = index(h);
        Node<K, V> node = table[indx];
        Node<K, V> node2 = node;
        while (node2 != null) {
            if (key.equals(node2.key)) {
                return node2.value;
            }
            node2 = node2.next;
        }
        return null;
    }

    public V remove(Object key) {
        int h = hash(key);
        int indx = index(h);
        Node<K, V> node = table[indx];
        Node<K, V> node2 = node;
        Node<K, V> pred = null;
        while (node2 != null) {
            if (key.equals(node2.key)) {
                V value = node2.value;

                if (pred == null) {
                    table[indx] = node2.next;
                } else {
                    pred.next = node2.next;
                }

                return value;
            }

            pred = node2;
            node2 = node2.next;
        }

        return null;
    }
}
