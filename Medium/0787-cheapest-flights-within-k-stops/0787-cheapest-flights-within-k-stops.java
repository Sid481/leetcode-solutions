class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new LinkedList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[]flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            graph.get(u).add(new int[]{v,w});
        }
        int stopsUsed[] = new int[n];
        Arrays.fill(stopsUsed, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,src,0});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int node = current[1];
            int stop = current[2];
            if(node==dst) return cost;
            if(stop>k) continue;
            if(stop >= stopsUsed[node]) continue;
            stopsUsed[node] = stop;
            for(int[] edge : graph.get(node)) {
                int price = edge[1];
                int next = edge[0];
                pq.offer(new int[]{price+cost,next,stop+1});
            }
        }
        return -1;
    }
}
