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
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxValue;
    }
    private int maxPath(TreeNode node) {
        if(node==null) return 0;
        int left = Math.max(0,maxPath(node.left));
        int right = Math.max(0,maxPath(node.right));
        left = Math.max(0,left);
        int sum = node.val + left + right;
        maxValue = Math.max(maxValue,sum);
        return node.val + Math.max(left,right);
    }
}