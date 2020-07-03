package jvm;

import java.util.LinkedList;

public class TestAtomic {
    static Integer cnt = 0;

    public static synchronized void increase() {
        cnt++;
    }

    public static void main(String[] args) throws InterruptedException {
        LinkedList<Thread> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            ThreadA threadA=new ThreadA();
            threadA.start();
            list.add(threadA);
        }
        for (Thread t : list) {
            t.join();
        }
        System.out.println(cnt);
    }

    static class ThreadA extends Thread {
        public void run() {
            for (int i = 0; i < 10000; i++) {
                // TestAtomic.increase();
                synchronized (cnt) {
                    cnt++;
                }
            }
        }
    }
}
