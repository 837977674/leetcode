package jvm.data.area;

/**
 * 操作数栈（OS） 用于在方法运算过程存储其中间的运算结果、方法入参和返回结果，
 * 它是一个后进先出（Last-In-First-Out，LIFO）的队列。
 * JVM提供了对OS出栈和入栈的指令，如load指令属于入栈指令、store指令属于出栈指令。
 */
// ![image_name](https://templezhou-1257998808.cos.ap-shanghai.myqcloud.com/img/20200701140106.png)
public class JVMStackOS {
    public int showOS(int a, int b) {
        int c = a + b;
        return c;
    }

    public static void main(String[] args) {
        System.out.println("a");
    }
}
