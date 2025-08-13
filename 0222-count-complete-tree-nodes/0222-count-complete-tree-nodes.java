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
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        //if(root.left==null && root.right==null) return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left!=null) {
                count++;
                queue.offer(node.left);
            }
            if(node.right!=null) {
                count++;
                queue.offer(node.right);
            }
        }
        return count;
    }
}