package imlp;

public class SkipListNode {
    public int key;
    public String value;
    public SkipListNode up, down, left, right; // 上下左右 四个指针

    public static final int HEAD_KEY = Integer.MIN_VALUE; // 负无穷
    public static final int TAIL_KEY = Integer.MAX_VALUE; // 正无穷

    public SkipListNode(int k, String v) {
        key = k;
        value = v;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean equals(SkipListNode o) {
        return (o.getKey() == key) && (o.getValue().equals(value));
    }

    @Override
    public java.lang.String toString() {
        return "key-value:" + key + "-" + value;
    }
}
