class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int parent[] = new int[n+1];
        int rank[] = new int[n+1];
        int[] result = new int[2];

        for(int i=1; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int i=0; i<n; i++) {
          int x = edges[i][0];
          int y = edges[i][1];
          int parentX = find(x, parent);
          int parentY = find(y,parent);
          if(parentX==parentY) return new int[]{x,y};
          

          if(rank[parentX]>rank[parentY]) {
            parent[parentY] = parentX;
          } else if(rank[parentX]<rank[parentY]) {
            parent[parentX] = parentY;
          } else {
            parent[parentY] = parentX;
            rank[parentX]++;
          }
        }
        return result;
    }
    public int find(int x, int[] parent) {
            if(parent[x]!=x) {
                parent[x] = find(parent[x],parent);
            }
            return parent[x];
        }
}