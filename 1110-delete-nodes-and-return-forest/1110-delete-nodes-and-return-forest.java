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
    List<TreeNode> result = new ArrayList<>();
    Set<Integer> toDeleted = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    for(int i : to_delete) {
        toDeleted.add(i);
    }
    deleteNodes(root,true);
    return result; 
    }
    private TreeNode deleteNodes(TreeNode node,boolean isRoot) {
       if(node==null) {
        return null;
       } 

       boolean toDelete = toDeleted.contains(node.val);
       
       if(isRoot && !toDelete) {
        result.add(node);
       }
       node.left = deleteNodes(node.left,toDelete);
       node.right = deleteNodes(node.right,toDelete);
       return toDelete?null:node;
    }
}