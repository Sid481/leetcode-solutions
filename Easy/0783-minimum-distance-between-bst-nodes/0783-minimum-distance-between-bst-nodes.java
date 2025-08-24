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
    public int minDiffInBST(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        Integer prev = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current!=null || !stack.isEmpty()) {
            while(current!=null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode node = stack.pop();
            if(prev!=null) {   
                minDiff = Math.min(minDiff,Math.abs(node.val-prev));
            }
            prev = node.val;
            current = node.right;
        }
        return minDiff;
    }
}
