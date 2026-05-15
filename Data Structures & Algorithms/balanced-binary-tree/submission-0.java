/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean x = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return x;
    }
    private int dfs(TreeNode m){
        if(m == null){
            return 0;
        }
        int left = dfs(m.left);
        int right = dfs(m.right);
        if(Math.abs(left - right) > 1){
            x = false;
        }
        return 1 + Math.max(left, right);
    }
}
