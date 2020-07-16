package imlp;

import java.util.LinkedList;

public class MyHashMap {
    private final int ARRAY_SIZE = 999;
    LinkedList<MapEntry>[] arr = new LinkedList[ARRAY_SIZE]; // 键值对集合！ Map底层结构是:数组 + 链表
    int size = 0; // HashMap的容量

    // 构造方法
    public MyHashMap() {
    }

    /*
     * 向HashMap中存入键值对
     */
    public void put(Object key, Object value) {
        MapEntry node = new MapEntry(key, value);
        
        int hash = node.key.hashCode() % ARRAY_SIZE;
        hash = Math.abs(hash);
        
        if (arr[hash] == null) { // 此索引位置为空
            LinkedList<MapEntry> list = new LinkedList<>();	//创建一个双向链表
            arr[hash] = list;
            list.add(node);
            size++;
        } else { // 该位置有元素
            LinkedList<MapEntry> list = arr[hash]; // 取出该索引处的链表
            // 判断有没有键值重复
            boolean flag = false;	// 判断此链表中，是否存在重复的键值
            for (MapEntry mapEntry : list) {
                if (mapEntry.key.equals(key)) { // 键值有重复
                    mapEntry.value = value; // value值覆盖
                    flag = true;
                }
            }
            if(!flag){	//不存在重复的key，需添加此元素
                list.add(node);
                size++;
            }
        }
    }

    /*
     * 获取键值对中某个键值对对象
     */
    public Object get(Object key) {
        int hash = key.hashCode() % arr.length;
        hash = hash < 0 ? -hash : hash;
        if (arr[hash] != null) {
            LinkedList<MapEntry> list = arr[hash];
            for (MapEntry mapEntry : list) {
                if (mapEntry.key.equals(key)) {
                    return mapEntry.value;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("6", "b");
        map.put("6", "a");
        map.put("5", "c");
        map.put("4", "d");
        System.out.println(map.size);	//3
        System.out.println(map.get("6"));	//a
    }
}