package lowestcommonancestorofabinarytree.ztp;

import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    TreeNode p, q;
    TreeNode targetNode;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        searchTree(root);
        return targetNode;
    }

    private boolean searchTree(TreeNode current) {
        boolean leftFlag = false, rightFlag = false;
        if (current.left == null && current.right == null) {
            if (current == p || current == q) {
                return true;
            }
        }
        if (current.left != null) {
            leftFlag = searchTree(current.left);
        }
        if (current.right != null) {
            rightFlag = searchTree(current.right);
        }
        leftFlag = leftFlag || current == p || current == q;
        rightFlag = rightFlag || current == p || current == q;
        if (rightFlag && leftFlag) {
            targetNode = current;
        }
        return rightFlag || leftFlag;
    }

}
