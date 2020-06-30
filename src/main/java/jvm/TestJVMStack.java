package jvm;

public class TestJVMStack {
    private static int count = 0;

    public static void main(String[] args) {
        TestJVMStack test = new TestJVMStack();
        test.test();
    }

    /**
     * 递归调用
     */
    private void test() {
        try {
            count++;
            test();
        } catch (Throwable e) {     //Exception已经捕获不了JVM抛出的StackOverflowError
            System.out.println("递归调用次数" + count);
            e.printStackTrace();
        }
    }
}
