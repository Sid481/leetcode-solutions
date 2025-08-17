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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0)return null;
    return buildTreeHelper(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }
    private TreeNode buildTreeHelper(int[]postorder,int poStart,int poEnd,int[]inorder,int inStart,int inEnd) {
        if(poStart>poEnd || inStart>inEnd) return null;
        int mid = 0;
        TreeNode root = new TreeNode(postorder[poEnd]);
        for(int i=inStart; i<=inEnd; i++) {
            if(inorder[i]==root.val) {
                mid = i;
                break;
            }
        }
        int leftLevel = mid-inStart;
        root.left = buildTreeHelper(postorder,poStart,poStart+leftLevel-1,inorder,inStart,mid-1);
        root.right = buildTreeHelper(postorder,poStart+leftLevel,poEnd-1,inorder,mid+1,inEnd);
        return root;
    }
}