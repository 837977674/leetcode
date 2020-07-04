package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapLoopForever {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            HashMapThread t = new HashMapThread();
            t.start();
        }
    }
}

class HashMapThread extends Thread {
    private static AtomicInteger ai = new AtomicInteger();
    private static Map<Integer, Integer> map = new HashMap<>();

    @Override
    public void run() {
        while (ai.get() < 5000000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
    }
}