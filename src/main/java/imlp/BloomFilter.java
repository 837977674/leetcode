package imlp;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class BloomFilter {
    private static final int DEFAULT_SIZE = 2 << 11;
    private static final int[] seeds = new int[] { 5, 7, 11, 13, 31, 37, 61 };
    private BitSet bits = new BitSet(DEFAULT_SIZE);
    private SimpleHash[] func = new SimpleHash[seeds.length];

    public BloomFilter() {
        // 创建 7 个各不相同的 hash 函数
        for (int i = 0; i < seeds.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
    }

    public void add(String value) {
        for (SimpleHash f : func) {
            int h1 = value.hashCode();
            int h2 = f.hash(value);
            bits.set(f.hash(value), true);
        }
    }

    public boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (SimpleHash f : func) {
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }

    // 内部类，simpleHash
    public static class SimpleHash {
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(String value) {
            int h = 0;
            for (int i = 0; i < value.length(); i++) {
                h = h * seed + value.charAt(i);
            }
            int res = (cap - 1) & h;
            return res;
        }
    }

    public static void main(String[] args) {
        BloomFilter bf = new BloomFilter();
        List<String> strs = new ArrayList<String>();
        strs.add("123456");
        strs.add("hello word");
        strs.add("transDocId");
        strs.add("123456");
        strs.add("transDocId");
        strs.add("hello word");
        strs.add("test");
        for (int i=0;i<strs.size();i++) {
            String s = strs.get(i);
            boolean bl = bf.contains(s);
            if(bl){
                System.out.println(i + "," + s + " is exists");
            }else{
                bf.add(s);
            }
        }
    }
}
