package jvm;

public class TestAtomic {
    static Integer cnt = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            ThreadA threadA=new ThreadA();
            threadA.start();
        }
        Thread.sleep(2000);
        System.out.println(cnt);
    }

    static class ThreadA extends Thread {
        public void run(){
            for (int i = 0; i < 1000; i++) {
                cnt++;
            }
        }
    }
}
