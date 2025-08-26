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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode prev = null;
        List<Integer> list = new ArrayList<>();
        while(current!=null || !stack.isEmpty()) {
            while(current!=null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode node = stack.peek();
            if(node.right==null || node.right==prev) {
                list.add(node.val);
                stack.pop();
                prev = node;
                
            } else {
                current = node.right;
            }
        }
        return list;
    }
}