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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        bfs.offer(root);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        while(!bfs.isEmpty()){
            int n = bfs.size();
            List<Integer> curr = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode node = bfs.poll();
                curr.add(node.val);
                if(node.left != null){
                    bfs.offer(node.left);
                }
                if(node.right != null){
                    bfs.offer(node.right);
                }
            }
            ans.add(curr);
        }
        return ans;
    }
}
