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
    boolean flag = true;
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
         isValid(root);
         return flag;
    }
    private void isValid(TreeNode node) {
        if(node==null) return;
            isValid(node.left);
            if(prev!=null) {
                if(prev>=node.val) flag = false;
            }
            prev = node.val;
            isValid(node.right);
    }
}
