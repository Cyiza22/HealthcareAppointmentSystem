public class PairTest {


        public static class Pair<K, V> {
            private K key;
            private V value;

            // Constructor
            public Pair(K key, V value) {
                this.key = key;
                this.value = value;
            }


            public K getKey() {
                return key;
            }


            public V getValue() {
                return value;
            }


            @Override
            public String toString() {
                return "(Key: " + key + ", Value: " + value + ")";
            }
        }
}

