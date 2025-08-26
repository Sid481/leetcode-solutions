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
    int counter = 0;
    Integer smallest = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
       getSmallestElement(root,k);
       return smallest;
    }
    private void getSmallestElement(TreeNode node, int k) {
        if(node==null) return;
        getSmallestElement(node.left,k);
        counter++;
        if(counter==k) smallest =  node.val;
        getSmallestElement(node.right,k);

    }
}
