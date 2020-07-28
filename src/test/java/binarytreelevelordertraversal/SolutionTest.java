package binarytreelevelordertraversal;

import lowestcommonancestorofabinarytree.ztp.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void levelOrder() {
        Integer[] treeArr = new Integer[]{3,9,20,null,null,15,7};
        TreeNode[] tree = new TreeNode[treeArr.length+1];
        for (int i = 0; i < treeArr.length; i++) {
            if (treeArr[i] != null) {
                tree[i+1] = new TreeNode(treeArr[i]);
            }
        }
        for (int i = 2; i < tree.length; i++) {
            if (i % 2 == 0) {
                tree[i/2].left = tree[i];
            } else {
                tree[i/2].right = tree[i];
            }
        }
        new Solution().levelOrder(tree[1]);
    }
}