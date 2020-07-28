package binarytreelevelordertraversal;

import lowestcommonancestorofabinarytree.ztp.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static List<List<Integer>> ans;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        ans = new LinkedList<>();
        bfs(root, 1);
        return ans;
    }

    private void bfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (ans.size() < level) {
            ans.add(new LinkedList<>());
        }
        ans.get(level-1).add(node.val);
        bfs(node.left, level+1);
        bfs(node.right, level+1);
    }
}
