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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>result = new ArrayList<>();
        if(root==null) return result;
        treePath(root,result,new ArrayList<String>());
        return result;
    }
    private void treePath(TreeNode root, List<String>result, List<String>subList) {
        subList.add(String.valueOf(root.val));
        if(root.left==null && root.right==null) {
            result.add(String.join("->",subList));
        } else {
        if(root.left!=null)
        treePath(root.left,result,subList);
        if(root.right!=null)
        treePath(root.right,result,subList);
     }
     subList.remove(subList.size()-1);
    }
}