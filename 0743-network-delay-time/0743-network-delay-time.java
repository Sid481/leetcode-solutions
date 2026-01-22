class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
    
        List<List<int[]>>graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[]time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new int[]{v,w});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]>minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        minHeap.add(new int[]{k,0});
        while(!minHeap.isEmpty()) {
            int curr[] = minHeap.poll();
            int u = curr[0];
            int d = curr[1];
            if(d>dist[u]) continue;
            for(int[]nei : graph.get(u)) {
            int v = nei[0];
            int w = nei[1];

            if(dist[u]+w < dist[v]) {
                dist[v] = dist[u]+w;
                minHeap.add(new int[]{v,dist[v]});
                }
            }
        }
        int ans = 0;
        for(int i=1; i<=n; i++) {
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans = Math.max(ans,dist[i]);
            }
         return ans;
    }
            
}