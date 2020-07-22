package datastructure;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockFair {
    private static final Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        new Thread(new ThreadDemo(),"线程A").start();
        new Thread(new ThreadDemo(),"线程B").start();
        new Thread(new ThreadDemo(),"线程C").start();
        new Thread(new ThreadDemo(),"线程D").start();
        new Thread(new ThreadDemo(),"线程E").start();
    }
    
    static class ThreadDemo implements Runnable {

        @Override
        public void run() {
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
}
