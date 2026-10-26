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
    boolean diff = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return diff;
    }
    public int dfs(TreeNode root){
        if(root == null){return 0;}
        int l = dfs(root.left);
        int r = dfs(root.right);
        if(Math.abs(l-r) > 1){diff = false;}
        return 1 + Math.max(l, r);
    }
}
