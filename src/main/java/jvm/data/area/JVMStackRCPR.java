package jvm.data.area;


/**
 * 运行时常量池引用（Runtime Constant Pool Reference）
 * 每个栈帧内都包含一个指向当前方法所属类的运行时常量池引用，也称为符号引用（Symbolic Reference）
 * 用于在类加载阶段对代码进行动态链接。
 * 动态链接所做的就是根据符号引用所表示名字，转换成对方法或变量的实际引用，从而实现运行时绑定（Late Binding）。
 */
public class JVMStackRCPR {
    private int a1 = 0;
    private int a2 = 0;
    private int a3 = 0;
    
    public void f1() {}
    public void f2() {
        int b = a1;
        f1();
    }

    public static void main(String[] args) {
        System.out.println("a");
    }
}
