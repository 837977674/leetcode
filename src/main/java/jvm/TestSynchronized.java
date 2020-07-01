package jvm;

public class TestSynchronized {
    public static void main(String[] args) {
        final SynObj sy = new SynObj();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                sy.showA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                sy.showB();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                sy.showC();
            }
        }).start();
    }
}

class SynObj {
    public synchronized void showA() {
        System.out.println("showA..");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void showB() {
        synchronized (this) {
            System.out.println("showB..");
        }
    }

    public void showC() {
        String s = "1";
        synchronized (s) {
            System.out.println("showC..");
        }
    }
}