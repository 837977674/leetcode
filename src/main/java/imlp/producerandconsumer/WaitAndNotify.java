package imlp.producerandconsumer;

public class WaitAndNotify {
    public static int count = 0;
    public static final Integer FULL = 10;
    public static final String LOCK = "lock";

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
}
