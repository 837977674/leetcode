package imlp.producerandconsumer;

import static imlp.producerandconsumer.WaitAndNotify.*;

class Consumer implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LOCK) {
                while (count == 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "消费者消费，空了");
                        LOCK.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                count--;
                System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                LOCK.notifyAll();
            }
        }
    }
}