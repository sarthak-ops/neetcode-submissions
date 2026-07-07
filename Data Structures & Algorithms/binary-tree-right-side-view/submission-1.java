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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        if(root == null){
            return new ArrayList<>();
        }
        bfs.offer(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while(!bfs.isEmpty()){
            int n = bfs.size();
            for(int i = 0; i < n; i++){
                TreeNode node = bfs.poll();

                if(i == n - 1){
                    ans.add(node.val);
                }

                if(node.left != null){
                    bfs.offer(node.left);
                }
                if(node.right != null){
                    bfs.offer(node.right);
                }
            }
        }
        return ans;
    }
}
