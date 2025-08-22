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
     private Map<Integer,Integer> map;
     private int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       map = new HashMap<>();
       for(int i=0; i<inorder.length; i++) {
        map.put(inorder[i],i);
       }
       postIndex = postorder.length-1;
       return helper(inorder,postorder,0,inorder.length-1);
    }
    private TreeNode helper(int[]inorder, int[]postorder, int left, int right) {
        if(left>right) return null;
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int idx = map.get(rootVal);
        root.right = helper(inorder,postorder,idx+1,right);
        root.left = helper(inorder,postorder,left,idx-1);
        return root;
    }
}