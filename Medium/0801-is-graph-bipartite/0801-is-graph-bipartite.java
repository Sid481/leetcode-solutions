class Solution {
    int[] color; 
    public boolean isBipartite(int[][] graph) {  
       color = new int[graph.length];
       
        for(int i=0; i<graph.length; i++) {
            if(color[i]==0)
            if(!dfs(i,1,color,graph)) return false;
        }
        return true;
    }
    public boolean dfs(int node, int col, int[] color, int[][]graph) {
        color[node] = col;
        for(int neighbor : graph[node]) {
            if(color[neighbor]==0) {
                if(!dfs(neighbor,-col,color,graph)) return false;
            } else if(color[neighbor]==col){
                return false;
            }
        }
        return true;
    }
}