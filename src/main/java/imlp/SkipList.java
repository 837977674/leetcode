package imlp;

import java.util.Random;

// https://www.jianshu.com/p/60d2561b821c
public class SkipList {
    private SkipListNode head,tail;
    private int nodes; // 节点总数
    private int listLevel; // 层数
    private Random random; // 用于投掷硬币
    private static final double PROBABILITY=0.5; //向上提升一个的概率
    public SkipList() {
        random=new Random();
        clear();
    }
    /**
     *清空跳跃表
     * */
    public void clear(){
        head=new SkipListNode(SkipListNode.HEAD_KEY, null);
        tail=new SkipListNode(SkipListNode.TAIL_KEY, null);
        horizontalLink(head, tail);
        listLevel=0;
        nodes=0;
    }
    public boolean isEmpty(){
        return nodes==0;
    }

    public int size() {
        return nodes;
    }
    /**
     * 在最下面一层，找到要插入的位置前面的那个key
     * */
    private SkipListNode findNode(int key){
        SkipListNode p=head;
        while(true){
            while (p.right.key!=SkipListNode.TAIL_KEY&&p.right.key<=key) {
                p=p.right;
            }
            if (p.down!=null) {
                p=p.down;
            }else {
                break;
            }

        }
        return p;
    }
    /**
     * 查找是否存储key，存在则返回该节点，否则返回null
     * */
    public SkipListNode search(int key){
        SkipListNode p=findNode(key);
        if (key==p.getKey()) {
            return p;
        }else {
            return null;
        }
    }
    /**
     * 向跳跃表中添加key-value
     *
     * */
    public void put(int k,String v){
        SkipListNode previousNode=findNode(k);
        //如果key值相同，替换原来的vaule即可结束
        if (k==previousNode.getKey()) {
            previousNode.value=v;
            return;
        }
        SkipListNode currentNode=new SkipListNode(k, v);
        backLink(previousNode, currentNode);
        int currentLevel=0;//当前所在的层级是0
        //抛硬币
        while (random.nextDouble()<PROBABILITY) {
            //如果超出了高度，需要重新建一个顶层
            if (currentLevel>=listLevel) {
                listLevel++;
                SkipListNode head1=new SkipListNode(SkipListNode.HEAD_KEY, null);
                SkipListNode tail1=new SkipListNode(SkipListNode.TAIL_KEY, null);
                horizontalLink(head1, tail1);
                verticalLink(head1, head);
                verticalLink(tail1, tail);
                head=head1;
                tail=tail1;
            }
            //将p移动到上一层
            while (previousNode.up==null) {
                previousNode=previousNode.left;
            }
            previousNode=previousNode.up;

            SkipListNode e=new SkipListNode(k, null);//只保存key就ok
            backLink(previousNode, e);//将e插入到p的后面
            verticalLink(e, currentNode);//将e和q上下连接
            currentNode=e;
            currentLevel++;
        }
        nodes++; // 节点总数递增
    }
    //node1后面插入node2
    private void backLink(SkipListNode node1,SkipListNode node2){
        node2.left=node1;
        node2.right=node1.right;
        node1.right.left=node2;
        node1.right=node2;
    }
    /**
     * 水平双向连接
     * */
    private void horizontalLink(SkipListNode node1,SkipListNode node2){
        node1.right=node2;
        node2.left=node1;
    }
    /**
     * 垂直双向连接
     * */
    private void verticalLink(SkipListNode node1, SkipListNode node2){
        node1.down=node2;
        node2.up=node1;
    }

    public static void main(String[] args) {
        SkipList list=new SkipList();
        list.put(2, "2");
        list.put(1, "1");
        list.put(3, "3");
        list.put(1, "1");//测试同一个key值
        list.put(4, "4");
        list.put(6, "6");
        list.put(5, "5");
        System.out.print(list);
        System.out.println(list.size());
    }

    /**
     * 打印出原始数据
     * */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            return "跳跃表为空！";
        }
        StringBuilder builder=new StringBuilder();
        SkipListNode p=head;
        while (p.down!=null) {
            p=p.down;
        }

        while (p.left!=null) {
            p=p.left;
        }
        if (p.right!=null) {
            p=p.right;
        }
        while (p.right!=null) {
            builder.append(p);
            builder.append("\n");
            p=p.right;
        }

        return builder.toString();
    }
}
