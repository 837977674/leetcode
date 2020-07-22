package datastructure;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockFair {
    private static final Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        new Thread(() -> test(),"线程A").start();
        new Thread(() -> test(),"线程B").start();
        new Thread(() -> test(),"线程C").start();
        new Thread(() -> test(),"线程D").start();
        new Thread(() -> test(),"线程E").start();
    }
    public static void  test()  {
        for(int i=0;i<2;i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获取了锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
