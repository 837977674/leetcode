package imlp;

import lombok.SneakyThrows;

// 懒汉
public class SingletonLazy {
    private static SingletonLazy instance;
    private SingletonLazy (){}

    public static SingletonLazy getInstance() throws InterruptedException {
        if (instance == null) {
            // 模拟创建对象之前做的准备性工作
            Thread.sleep(100);
            
            instance = new SingletonLazy();
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println(SingletonLazy.getInstance().hashCode());
                }
            });
            t.start();
        }
    }
}
