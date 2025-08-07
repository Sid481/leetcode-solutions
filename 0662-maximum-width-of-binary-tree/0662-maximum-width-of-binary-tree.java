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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int maxWidth=0;
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root,0));
        while(!queue.isEmpty()) {
            int size = queue.size();  
            int minindex = queue.peek().getValue();
            int firstIndex = 0, lastIndex = 0;
            for(int i=0; i<size; i++) {
                Pair<TreeNode,Integer>pair = queue.poll();
                TreeNode node = pair.getKey();
                int currentIndex = pair.getValue();
                if(i==0) firstIndex = currentIndex;
                if(i==size-1) lastIndex = currentIndex;

                if(node.left!=null) queue.offer(new Pair<>(node.left,2*currentIndex+1));
                if(node.right!=null) queue.offer(new Pair<>(node.right,2*currentIndex+2));
            }
            maxWidth = Math.max(maxWidth,lastIndex-firstIndex+1);
        }
        return maxWidth;
    }
}