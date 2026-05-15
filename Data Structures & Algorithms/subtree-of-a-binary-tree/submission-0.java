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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null){
            return false;
        }

        if(sameTree(root, subRoot)){
            return true;
        }

        return isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }

    boolean sameTree(TreeNode x, TreeNode m){

        if(x == null && m == null){
            return true;
        }

        if(x == null || m == null){
            return false;
        }

        if(x.val != m.val){
            return false;
        }

        return sameTree(x.left, m.left)
            && sameTree(x.right, m.right);
    }
}
