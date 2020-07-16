package imlp;

import lombok.SneakyThrows;

// 饿汉
public class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry(); ;
    private SingletonHungry(){}

    public static SingletonHungry getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println(SingletonHungry.getInstance().hashCode());
                }
            });
            t.start();
        }
    }
}
