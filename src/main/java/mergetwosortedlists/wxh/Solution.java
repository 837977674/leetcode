package mergetwosortedlists.wxh;

import mergetwosortedlists.ztp.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null & l2 == null) return null;
        else if (l1==null & l2 != null) return l2;
        else if (l1!=null & l2 == null) return l1;

        ListNode l3=new ListNode();
        ListNode pointer=l3;
        while (l1!=null || l2!=null)
        {
            if(l1==null) pointer.next=l2;
            else if (l2==null) pointer.next=l1;
            else if(l1.val<=l2.val)
            {
                pointer.val=l1.val;
                pointer.next=new ListNode();
                pointer=pointer.next;
                l1=l1.next;

            }
            else
            {
                pointer.val=l2.val;
                pointer.next=new ListNode();
                pointer=pointer.next;
                l2=l2.next;
            }

        }

    return l3;


    }
}
