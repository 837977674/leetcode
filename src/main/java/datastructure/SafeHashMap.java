package datastructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SafeHashMap {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            SafeHashMapThread t = new SafeHashMapThread();
            
            list.add(t);
            
            t.start();
        }
        
        for (Thread t : list) {
            t.join();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class SafeHashMapThread extends Thread {
    private static AtomicInteger ai = new AtomicInteger();
    private static Map<Integer, String> map = new ConcurrentHashMap<>();

    @Override
    public void run() {
        while (ai.get() < 5000000) {
            map.put(ai.get(), String.valueOf(ai.get()));
            ai.incrementAndGet();
        }
    }
}