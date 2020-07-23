package topkfrequentelements.ztp;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    int[] res;
    HashMap<Integer, Item> map;
    
    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        int idx = 0;
        res = new int[nums.length];
        for (int i : nums) {
            if (map.containsKey(i)) {
                Item item = map.get(i);
                item.cnt++;
                findAndCompare(i, item);
            } else {
                map.put(i, new Item(idx, 1));
                res[idx++] = i;
            }
        }
        return Arrays.copyOf(res, k);
    }

    private void findAndCompare(int i, Item target) {
        if (target.idx == 0) {
            return;
        }
        int currentIdx = target.idx;
        while (currentIdx > 0) {
            Item currentNode = map.get(res[currentIdx]);
            Item previousNode = map.get(res[currentIdx - 1]);
            if (currentNode.cnt > previousNode.cnt) {
                int t = res[currentIdx - 1];
                res[currentIdx - 1] = res[currentIdx];
                res[currentIdx] = t;
                currentNode.idx--;
                previousNode.idx++;
            } else {
                return;
            }
            currentIdx--;
        }
    }

    class Item {
        int idx;
        int cnt;
        public Item(int key, int cnt) {
            this.idx = key;
            this.cnt = cnt;
        }
    }
}
