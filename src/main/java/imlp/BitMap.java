package imlp;

import java.lang.reflect.Field;
import java.util.BitSet;

public class BitMap {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        int [] array = new int [] {1,2,3,22,0,3};
        BitSet bitSet  = new BitSet(64);
        //将数组内容组bitmap
        for(int i=0;i<array.length;i++)
        {
            bitSet.set(array[i], true);
        }
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(3));

        Field setWords = BitSet.class.getDeclaredField("words");
        setWords.setAccessible(true);

        long[] words = (long[]) setWords.get(bitSet);
        for (long i : words) {
            System.out.println(Long.toBinaryString(i));
        }

        bitSet.set(8, true);
        words = (long[]) setWords.get(bitSet);
        for (long i : words) {
            System.out.println(Long.toBinaryString(i));
        }
    }
}
