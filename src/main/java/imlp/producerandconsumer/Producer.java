package imlp.producerandconsumer;

import static imlp.producerandconsumer.WaitAndNotify.*;

class Producer implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (LOCK) {
                while (count == FULL) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "生产者生产，满了");
                        LOCK.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                LOCK.notifyAll();
            }
        }
    }
}