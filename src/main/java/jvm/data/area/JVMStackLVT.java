package jvm.data.area;

/**
 * LVT 本地变量表的特点：
 * 1. 第0个Slot（槽位）固定存储指向方法所属对象的this指针。
 * 2. 除了long和double占用了连续2个Slot之外，其他类型都只占用了1个Slot。
 * 3. LVT按照变量的声明顺序进行存储。
 */
// ![image_name](https://templezhou-1257998808.cos.ap-shanghai.myqcloud.com/img/20200701135233.png)
public class JVMStackLVT {
    public int showLVT(byte b, char c, int i, long l) {
        float f = 0;
        double d = 0;
        boolean bool = false;
        Object ref = new Object();
        int ret = i;
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("a");
    }
}
