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
    private int min = Integer.MAX_VALUE;
    private Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        getMin(root);
        return min;
    }
    private void getMin(TreeNode node) {
        if(node==null) return;
        getMin(node.left);
        if(prev!=null) {
            min = Math.min(min, Math.abs(prev-node.val));
        }
        prev = node.val;
        getMin(node.right);
    }
}