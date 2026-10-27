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
    boolean r = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return r;
    }
    public void dfs(TreeNode root, int tmin, int tmax){
        if(root==null){return;}
        if(root.val<=tmin||root.val>=tmax){r = false;}
        dfs(root.left, tmin, root.val);
        dfs(root.right, root.val, tmax);
    }
}
