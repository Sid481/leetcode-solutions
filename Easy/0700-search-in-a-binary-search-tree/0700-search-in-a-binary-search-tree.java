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
    TreeNode result = null;
    public TreeNode searchBST(TreeNode root, int val) {     
        if(root==null || root.val==val) return root;
        if(val<root.val) result = searchBST(root.left,val);
        if(val>root.val) result = searchBST(root.right,val);
        return result;
    }
}
