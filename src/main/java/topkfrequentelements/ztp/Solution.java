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
        Item currentNode = map.get(res[target.idx]);
        Item previousNode = map.get(res[target.idx-1]);
        if (currentNode.cnt > previousNode.cnt) {
            int t = res[target.idx-1];
            res[target.idx-1] = res[target.idx];
            res[target.idx] = t;
            currentNode.idx--;
            previousNode.idx++;
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
