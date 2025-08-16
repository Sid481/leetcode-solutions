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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0) return null;
      return buildTreeHelper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    private TreeNode buildTreeHelper(int[]preorder,int preStart,int preEnd,int[]inorder,int inStart, int inEnd) {
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int mid = 0;
        for(int i=inStart; i<=inEnd; i++) {
            if(inorder[i]==root.val) {
                mid = i;
                break;
            }
        }
        int leftTreeSize = mid-inStart;
        root.left = buildTreeHelper(preorder,preStart+1,preStart+leftTreeSize,
        inorder,inStart,mid-1);
        root.right = buildTreeHelper(preorder,preStart+leftTreeSize+1,preEnd,
        inorder,mid+1,inEnd);
        return root;
    }
}