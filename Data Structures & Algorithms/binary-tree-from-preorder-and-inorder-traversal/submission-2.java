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
    Map<Integer, Integer> inmap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inmap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inmap.put(inorder[i], i);
        }
        return tree(preorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode tree(int[] preorder, int prestart, int prend, int instart, int inend){
        if(prestart > prend || instart > inend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int mid = inmap.get(root.val);
        int leftSubTreeSize = mid - instart;
        root.left = tree(preorder, prestart+1, prestart+leftSubTreeSize, instart, mid-1);
        root.right = tree(preorder, prestart+leftSubTreeSize+1, prend, mid+1, inend);
        return root;
    }
}
