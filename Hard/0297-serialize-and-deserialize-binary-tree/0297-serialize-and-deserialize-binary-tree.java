/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode>queue = new LinkedList<>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root==null) return "null";

        queue.offer(root);

        while(!queue.isEmpty()) { 
        TreeNode node = queue.poll();
        if(node==null) { 
            sb.append("null,");
        } else {
        sb.append(node.val).append(",");
        queue.offer(node.left);
        queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;

        String[] str = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i=1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!str[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(node.left);
            }
            i++;
            if(!str[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
