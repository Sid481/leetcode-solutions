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
    int minDiff = Integer.MAX_VALUE;
    Integer prev = null;
    public int minDiffInBST(TreeNode root) {
        minDiffHelper(root);
        return minDiff;
    }
    private void minDiffHelper(TreeNode node) {
            if(node==null) return;
            minDiffHelper(node.left);
            if(prev!=null) {
                minDiff = Math.min(minDiff,Math.abs(node.val-prev));
            }
            prev = node.val;
            minDiffHelper(node.right);
    }
}