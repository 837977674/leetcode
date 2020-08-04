package topkfrequentelements.ztp2;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<Entry> queue = new PriorityQueue<>();

        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num)+1);
            } else {
                hashMap.put(num, 1);
            }
        }
        for (Integer i : hashMap.keySet()) {
            queue.add(new Entry(hashMap.get(i), i));
        }
        
        int res[] = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().value;
        }
        
        return res;
    }
}

class Entry implements Comparable {
    int cnt;
    int value;
    
    Entry(int cnt, int value) {
        this.cnt = cnt;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        return ((Entry) o).cnt - cnt;
    }
}
