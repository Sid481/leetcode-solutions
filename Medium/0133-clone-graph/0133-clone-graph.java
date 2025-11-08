/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node>nodeMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        dfs(node);
        return nodeMap.get(node);
    }
    public void dfs(Node node) {
        if(node==null || nodeMap.containsKey(node)) return;
        Node clone = new Node(node.val,new ArrayList<Node>());
        nodeMap.put(node,clone);
        for(Node neighbor : node.neighbors) {
            if(!nodeMap.containsKey(neighbor))
            dfs(neighbor);
            clone.neighbors.add(nodeMap.get(neighbor));
        }
    }
}