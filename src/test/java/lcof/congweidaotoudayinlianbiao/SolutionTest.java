package lcof.congweidaotoudayinlianbiao;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void reversePrint() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(3);
        list.next.next = new ListNode(2);
        int[] arr = new Solution().reversePrint(list);
        assertArrayEquals(arr, new int[]{2, 3, 1});
    }
}