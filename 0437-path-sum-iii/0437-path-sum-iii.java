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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        backtrack(root,targetSum, new ArrayList<Integer>());
        return count;
    }
    private void backtrack(TreeNode node, int targetSum, List<Integer>paths) {
        if(node==null) {
            return;
        }
        paths.add(node.val);
        long sum = 0;
        for(int i=paths.size()-1; i>=0; i--) {
            sum += paths.get(i);
            if(sum==targetSum) count++;
        }
        backtrack(node.left,targetSum,paths);
        backtrack(node.right,targetSum,paths);
        paths.remove(paths.size()-1);
    }
}