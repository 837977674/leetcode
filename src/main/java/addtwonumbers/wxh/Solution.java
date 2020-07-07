package addtwonumbers.wxh;

import mergetwosortedlists.ztp.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode();

        ListNode pointer3=l3;
        //ListNode pointer4=l3;
        int a,b,c,d=0;
        while (l1!=null || l2!=null)
        {
            if (l1==null) a=0;
            else a=l1.val;

            if (l2==null) b=0;
            else b=l2.val;


            pointer3.next=new ListNode();
            pointer3=pointer3.next;
            pointer3.val=((a+b)%10+d)%10;

            if (a+b+d>9)
            {
                d=1;
            }
            else
            {
                d=0;
            }

            if (l1!=null) l1=l1.next;
            if (l2!=null) l2=l2.next;

        }
        if(d==1)
        {
            pointer3.next=new ListNode();
            pointer3=pointer3.next;
            pointer3.val=d;
        }

        l3=l3.next;
        return l3;
    }
}
