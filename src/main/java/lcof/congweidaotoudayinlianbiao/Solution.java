package lcof.congweidaotoudayinlianbiao;


class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode pointer = head;
        ListNode h = new ListNode(0);
        ListNode t = null;
        ListNode l2 = h;
        int size = 0;
        while (pointer != null) {
            ListNode temp = new ListNode(pointer.val);
            h.next = temp;
            temp.next = t;
            t = temp;
            pointer = pointer.next;
            size++;
        }
        h = h.next;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = h.val;
            h = h.next;
        }
        return arr;
    }
}