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
    int good = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return good;
    }
    public void dfs(TreeNode root, int maxf){
        if(root == null){return;}
        if(root.val >= maxf){
            good++;
        }
        maxf = Math.max(maxf, root.val);
        dfs(root.left, maxf);
        dfs(root.right, maxf);
    }
}
