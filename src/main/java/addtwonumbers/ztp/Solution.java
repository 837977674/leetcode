package addtwonumbers.ztp;


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode pointer = res;
        
        int nextValue = 0;
        int a, b;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 == null) {
                a = 0;
            } else {
                a = l1.val;
            }
            if (l2 == null){
                b = 0;
            } else {
                b = l2.val;
            }
            sum = (a + b + nextValue);
            pointer.next = new ListNode(sum%10);
            pointer = pointer.next;

            if (sum > 9) {
                nextValue = 1;
            } else {
                nextValue = 0;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if ( l2 != null ) {
                l2 = l2.next;
            }
        }
        if (nextValue == 1) {
            pointer.next = new ListNode(1);
        }
        res = res.next;
        return res;
    }
}