package jvm;

public class TestVolatile {
    public static Boolean stop = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run(){
                int i = 1;
                while(!stop){
                    System.out.println(System.currentTimeMillis() + " 删了这行就死循环，你信不信？");
                    i++;
                }
                System.out.println("Thread stop i="+ i);
            }
        };
        t1.start();
        Thread.sleep(2000);
        stop = true;
        System.out.println(System.currentTimeMillis() + ", in main thread stop is: " + stop);
        t1.join();
    }
}