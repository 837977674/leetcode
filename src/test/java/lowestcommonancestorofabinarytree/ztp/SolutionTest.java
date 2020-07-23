package lowestcommonancestorofabinarytree.ztp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void lowestCommonAncestor() {
        Integer[] treeArr = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
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
        assertEquals(tree[1], new Solution().lowestCommonAncestor(tree[1], tree[2], tree[3]));
        assertEquals(tree[5], new Solution().lowestCommonAncestor(tree[1], tree[10], tree[11]));
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.left = b;
        assertEquals(a, new Solution().lowestCommonAncestor(a, a, b));
    }
}