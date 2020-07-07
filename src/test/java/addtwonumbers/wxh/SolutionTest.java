package addtwonumbers.wxh;

import mergetwosortedlists.ztp.ListNode;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void addTwoNumbers() {
        //ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        //ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7))));
        ListNode list1 = new ListNode(5);
        ListNode list2 = new ListNode(5);
        ListNode res = new addtwonumbers.wxh.Solution().addTwoNumbers(list1, list2);
        System.out.println(res);
        ArrayList a = new ArrayList();
        while (res!=null) {
            a.add(res.val);
            res = res.next;
        }
        System.out.println(a);
        int len=a.size();
        int k=0;
        for (int j=len-1;j>=0;j--)
        {
            k = k*10+(int) a.get(j);
        }

        System.out.println(k);


    }
}
