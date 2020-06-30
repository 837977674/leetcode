package mergetwosortedlists.ztp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void mergeTwoLists() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7))));
        ListNode res = new Solution().mergeTwoLists(list1, list2);
        System.out.println(res.val);
    }
}