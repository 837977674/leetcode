package imlp;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyLRU extends LinkedHashMap<Integer, String> {
    private final int MAX_CACHE_SIZE;

    public MyLRU() {
        super(16, 0.75f, true);
        MAX_CACHE_SIZE = 0;
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
        if (size() > 3) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        MyLRU linkedHashMap = new MyLRU();
        linkedHashMap.put(1, "a");
        linkedHashMap.put(2, "b");
        linkedHashMap.put(3, "c");
        linkedHashMap.put(4, "d");
        linkedHashMap.put(5, "e");
        
        print(linkedHashMap);
        
        linkedHashMap.get(3);
        
        print(linkedHashMap);
    }

    private static void print(LinkedHashMap<Integer, String> linkedHashMap) {
        for (Map.Entry<Integer, String> entry: linkedHashMap.entrySet()) {
            System.out.print(entry.getKey() + " -> " + entry.getValue() + "\n");
        }
        System.out.println();
    }
}
