class Solution {
    List<List<Integer>> resultList;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        resultList = new ArrayList<>();
        dfs(0,graph,new ArrayList<>());
        return resultList;
        }
        public void dfs(int node, int[][]graph, List<Integer>list) {
            list.add(node);
            if(node==graph.length-1) {
                resultList.add(new ArrayList<>(list));
            } else {
            for(int neighbor : graph[node]) {
            dfs(neighbor,graph,list);
            }
        }
        list.remove(list.size()-1);
    }
}