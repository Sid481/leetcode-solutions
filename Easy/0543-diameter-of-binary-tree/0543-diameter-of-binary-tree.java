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
    int length = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return length;
    }
    private int getHeight(TreeNode node) {
        if(node==null) return 0;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        
        length = Math.max(length,leftHeight+rightHeight);

        return Math.max(leftHeight,rightHeight)+1;
        
    }
}
