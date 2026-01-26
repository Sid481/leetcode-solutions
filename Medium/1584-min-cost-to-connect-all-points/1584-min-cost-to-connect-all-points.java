class Solution {
    int[] parent;
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        parent = new int[n];
        int cost = 0;
        int edgeCount = 0;
        List<int[]>edges = new ArrayList<>();

        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n;j++) {
                int edgeCost = Math.abs(points[i][0]-points[j][0])
                + Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{edgeCost,i,j});
                }
            }
            for(int[]edge:edges) {
                minHeap.add(edge);
            }
            while(!minHeap.isEmpty() && edgeCount<n-1) {
                int[]currEdge = minHeap.poll();
                if(find(currEdge[1]) != find(currEdge[2])) {
                    union(currEdge[1],currEdge[2]);
                    cost += currEdge[0];
                    edgeCount++;
                } else {
                    continue;
                }
            }
            return cost;
        }
        public int find(int v) {
            if(parent[v]!=v) {
                parent[v] = find(parent[v]);
            }
            return parent[v];
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX!=rootY) parent[rootY] = rootX; 
        }
    }
