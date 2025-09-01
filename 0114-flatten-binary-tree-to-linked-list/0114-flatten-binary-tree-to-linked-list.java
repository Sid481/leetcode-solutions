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
    List<TreeNode> list = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.left);
        flatten(root.right);
        if(root.left!=null) {
            TreeNode rightMost = root.right;
            root.right = root.left;
            root.left = null;

            TreeNode tail = root.right;
            while(tail.right!=null) {
                tail = tail.right;
            }
            tail.right = rightMost;
        }    
    }
}