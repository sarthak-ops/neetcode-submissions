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
    HashMap<Integer, Integer> map = new HashMap<>();
    int pre = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length-1);
    }
    public TreeNode build(int[] preorder, int l, int r){
        if(l > r){return null;}
        TreeNode cur = new TreeNode(preorder[pre]);
        int m = map.get(preorder[pre]);
        pre++;
        cur.left = build(preorder, l, m-1);
        cur.right = build(preorder, m+1, r);
        return cur;
    }
}
