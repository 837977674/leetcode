package addtwonumbers.ztp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void addTwoNumbers() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        
        ListNode res = new Solution().addTwoNumbers(l1, l2);


        l1 = new ListNode(1);
        l1.next = new ListNode(8);

        l2 = new ListNode(0);

        res = new Solution().addTwoNumbers(l1, l2);
        System.out.println(res.val);
    }
}