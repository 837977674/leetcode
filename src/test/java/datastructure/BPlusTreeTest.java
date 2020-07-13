package datastructure;

import datastructure.pojo.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class BPlusTreeTest {

    @Test
    public void insertAndFind() {
        BPlusTree<Product, Integer> b = new BPlusTree<>(4);

        long time1 = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            Product p = new Product(i, "test", 1.0 * i);
            b.insert(p, p.getId());
        }

        long time2 = System.nanoTime();

        Product p1 = b.find(345);

        long time3 = System.nanoTime();

        System.out.println("插入耗时: " + (time2 - time1)/1000000.0 + "ms");
        System.out.println("查询耗时: " + (time3 - time2)/1000000.0 + "ms");
        // 查询耗时: 77948 纳秒 = 77.9 微秒 = 0.0779 毫秒
    }
}