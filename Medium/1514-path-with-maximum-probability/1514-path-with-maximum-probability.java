class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<double[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++) {
           int[]edge = edges[i];
           int u = edge[0];
           int v = edge[1];
           double w = succProb[i];
           graph.get(u).add(new double[]{v,w});
           graph.get(v).add(new double[]{u,w});
        }
        double[] probablity = new double[n];
        Arrays.fill(probablity,0.0);
        probablity[start] = 1.0;
        PriorityQueue<double[]>maxHeap = new PriorityQueue<>((a,b)->Double.compare(b[1],a[1]));
        maxHeap.add(new double[]{start,1.0});
        while(!maxHeap.isEmpty()) {
            double curr[] = maxHeap.poll();
            int node = (int)curr[0];
            double prob = curr[1];
            if(prob<probablity[node]) continue;
            for(double[]nei : graph.get(node)) {
                int v = (int)nei[0];
                double w = nei[1];
                if(probablity[node]*w>probablity[v]) {
                    probablity[v] = probablity[node]*w;
                    maxHeap.add(new double[]{v,probablity[v]});
                }
            }
        }
        return probablity[end];
    }
}
