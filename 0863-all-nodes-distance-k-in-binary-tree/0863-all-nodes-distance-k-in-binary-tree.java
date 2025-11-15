/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        findDistanceAndCollect(root,target,k,result);
        return result;
    }
    public int findDistanceAndCollect(TreeNode node, TreeNode target, int k, List<Integer>result) {
        if(node==null) return -1;
        if(node==target) {
            collectAtNode(node,k,result);
            return 0;
        }
        int leftDistance = findDistanceAndCollect(node.left,target,k,result);

        if(leftDistance != -1) {
            if(leftDistance+1 == k) result.add(node.val);
            else collectAtNode(node.right,k-leftDistance-2,result);
            return leftDistance+1;
        }
        int rightDistance = findDistanceAndCollect(node.right,target,k,result);
        if(rightDistance != -1) {
            if(rightDistance+1 == k) result.add(node.val);
            else collectAtNode(node.left,k-rightDistance-2,result);
            return rightDistance+1;
        }
        return -1;
    }
    public void collectAtNode(TreeNode node, int k, List<Integer>result) {
            if(node==null || k<0) return;
            if(k==0) {
                result.add(node.val);
                return;
            }
            collectAtNode(node.left,k-1,result);
            collectAtNode(node.right,k-1,result);
    }
}