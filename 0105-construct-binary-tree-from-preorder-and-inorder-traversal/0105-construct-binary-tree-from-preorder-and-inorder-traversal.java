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
    Map<Integer,Integer> inorderMap = new HashMap<>();
    int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        for(int i=0; i<inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }
        return helper(inorder,preorder,0,inorder.length-1);
    }
    private TreeNode helper(int[]inorder,int[]preorder,int left, int right) {
        if(left>right) return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int index = inorderMap.get(rootVal);
        root.left = helper(inorder,preorder,left,index-1);
        root.right = helper(inorder,preorder,index+1,right);
        return root;
    }
}