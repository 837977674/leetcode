package mergetwosortedlists.ztp;

public class Solution {
   
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res;
        // 边界处理
        if (l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }
        
        if (l1.val < l2.val) {
            res = l1;
            res.next = mergeTwoLists(l1.next, l2);
        } else {
            res = l2;
            res.next = mergeTwoLists(l1, l2.next);
        }
        return res;
    }
}
