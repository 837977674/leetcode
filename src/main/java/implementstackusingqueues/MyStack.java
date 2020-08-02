package implementstackusingqueues;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyStack {
    Queue<Integer> l1;
    Queue<Integer> l2;
    
    /** Initialize your data structure here. */
    public MyStack() {
        l1 = new LinkedList<>();
        l2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        l1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (l1.size() > 1) {
            l2.add(l1.poll());
        }
        int res = l1.poll();
        l1 = l2;
        l2 = new LinkedList<>();
        return res;
    }

    /** Get the top element. */
    public int top() {
        while (l1.size() > 1) {
            l2.add(l1.poll());
        }
        int res = l1.poll();
        l1 = l2;
        l1.add(res);
        l2 = new LinkedList<>();
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return l1.size() == 0;
    }
}
