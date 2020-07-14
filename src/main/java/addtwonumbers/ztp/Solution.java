package addtwonumbers.ztp;


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode pointer = res;
        
        int nextValue = 0;
        
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null){
                sum += l2.val;
            } 
            sum += nextValue;
            
            if (sum >= 10) {
                nextValue = 1;
                sum = sum % 10;
            } else {
                nextValue = 0;
            }
            pointer.val = sum;
            if ((l1 != null)) {
                l1 = l1.next;
            }
            if ( l2 != null ) {
                l2 = l2.next;
            }
            if (l1 != null || l2 != null) {
                pointer.next = new ListNode(0);
                pointer = pointer.next;
            }
        }
        if (nextValue == 1) {
            pointer.next = new ListNode(1);
        }
        return res;
    }
}