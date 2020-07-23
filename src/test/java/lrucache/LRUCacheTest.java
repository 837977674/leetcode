package lrucache;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void all() {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        
        int res;
        cache.put(1, 1);
        cache.put(2, 2);
        res = cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        res = cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        res = cache.get(1);       // 返回 -1 (未找到)
        res = cache.get(3);       // 返回  3
        res = cache.get(4);       // 返回  4
        System.out.println(res);
    }
}