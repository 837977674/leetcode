package reverselinkedlist.ztp;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode(-1);
        
        while(head != null) {
            ListNode t = res.next;
            ListNode t2 = head.next;
            
            head.next = res.next;
            res.next = head;
            
            head = t2;
        }
        
        return res.next;
    }
}
