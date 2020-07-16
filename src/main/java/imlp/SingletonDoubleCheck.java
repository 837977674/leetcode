package imlp;

import lombok.SneakyThrows;

// 双重检查
public class SingletonDoubleCheck {
    
    private static volatile SingletonDoubleCheck instance;
    /**
     * 为什么要 volatile
     * 1. 为 instance 分配内存空间;
     * 2. 调用该类的构造方法实例化对象;
     * 3. 返回堆内存的地址 及 将内存空间的地址赋值给对应的引用；
     * 
     * 由于但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2。
     * 指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。
     */
    private SingletonDoubleCheck(){}

    public static SingletonDoubleCheck getInstance() throws InterruptedException {
        if (instance == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (instance == null) {
                    // 模拟创建对象之前做的准备性工作
                    Thread.sleep(100);
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println(SingletonDoubleCheck.getInstance().hashCode());
                }
            });
            t.start();
        }
    }
}
