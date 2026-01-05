class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Collections.singletonList(0);

        List<Set<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new HashSet<>());
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(graph.get(i).size()==1) leaves.add(i);
        }
        int remainingNodes = n;
        while(remainingNodes>2) {
           remainingNodes -= leaves.size();
           List<Integer> newLeaves = new ArrayList<>();
           for(int leaf : leaves) {
            int ne = graph.get(leaf).iterator().next();
            graph.get(ne).remove(leaf);
            if(graph.get(ne).size()==1)newLeaves.add(ne);
           }
           leaves = newLeaves; 
        }
        return leaves;
    }
}