class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int parent[] = new int[n];
        int rank[] = new int[n];
        int[] result = new int[2];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int i=0; i<n; i++) {
          int x = edges[i][0]-1;
          int y = edges[i][1]-1;
          int parentX = find(x, parent);
          int parentY = find(y,parent);
          if(parentX==parentY) return new int[]{x+1,y+1};
          

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