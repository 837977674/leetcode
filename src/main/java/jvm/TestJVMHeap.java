package jvm;

import java.util.ArrayList;
import java.util.List;

// -Xms20M -Xmx50M -XX:NativeMemoryTracking=summary
// java -Xmx50M -XX:+PrintFlagsFinal -version | grep -iE 'heapsize|permsize|threadstacksize'
// java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:InitialRAMFraction=75 -XX:MaxRAMFraction=75 -XX:MinRAMFraction=75 -XX:+PrintFlagsFinal -version -version | grep -iE 'heapsize|permsize|threadstacksize'
public class TestJVMHeap {
    public static void main(String[] args) {
        List<TestJVMHeap> list = new ArrayList<>();
        int count = 0;
        try {
            while (true) {
                count++;
                list.add(new TestJVMHeap());   //不断创建对象
            }
        } catch (Throwable e) {
            System.out.println("创建实例个数：" + count);
            e.printStackTrace();
        }
    }
}

/**
 * Native Memory Tracking:
 *
 * Total: reserved=1396493KB, committed=97525KB
 * -                 Java Heap (reserved=51200KB, committed=51200KB)
 *                             (mmap: reserved=51200KB, committed=51200KB) 
 *
 * -                     Class (reserved=1062054KB, committed=10150KB)
 *                             (classes #504)
 *                             (malloc=5286KB #247) 
 *                             (mmap: reserved=1056768KB, committed=4864KB) 
 *
 * -                    Thread (reserved=18510KB, committed=18510KB)
 *                             (thread #19)
 *                             (stack: reserved=18432KB, committed=18432KB)
 *                             (malloc=56KB #96) 
 *                             (arena=22KB #37)
 *
 * -                      Code (reserved=249636KB, committed=2572KB)
 *                             (malloc=36KB #325) 
 *                             (mmap: reserved=249600KB, committed=2536KB) 
 *
 * -                        GC (reserved=7648KB, committed=7648KB)
 *                             (malloc=5772KB #119) 
 *                             (mmap: reserved=1876KB, committed=1876KB) 
 *
 * -                  Compiler (reserved=132KB, committed=132KB)
 *                             (malloc=2KB #24) 
 *                             (arena=131KB #3)
 *
 * -                  Internal (reserved=5514KB, committed=5514KB)
 *                             (malloc=5482KB #3739) 
 *                             (mmap: reserved=32KB, committed=32KB) 
 *
 * -                    Symbol (reserved=1497KB, committed=1497KB)
 *                             (malloc=977KB #562) 
 *                             (arena=520KB #1)
 *
 * -    Native Memory Tracking (reserved=85KB, committed=85KB)
 *                             (malloc=4KB #43) 
 *                             (tracking overhead=82KB)
 *
 * -               Arena Chunk (reserved=217KB, committed=217KB)
 *                             (malloc=217KB) 
 */