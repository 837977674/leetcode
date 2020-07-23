package lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    MyLRU<Integer, Integer> myLRU;
    
    public LRUCache(int capacity) {
        myLRU = new MyLRU(capacity);    
    }

    public int get(int key) {
        Object o = myLRU.get(key);
        if (o == null) {
            return -1;
        }
        return (int) o;
    }

    public void put(int key, int value) {
        myLRU.put(key, value);
    }
    
    class MyLRU<K,V> extends LinkedHashMap {
        int capacity;
        public MyLRU(int capacity) {
            super(16, 0.75f, true);
            this.capacity = capacity;
        }
        
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            if (this.size() > capacity) {
                return true;
            }
            return false;
        }
    }
}
