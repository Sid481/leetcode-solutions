class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outdegree = new int[graph.length];
        List<List<Integer>> reverseGraph = new ArrayList<>();

        for(int i=0; i<graph.length; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<graph.length; i++) {
            for(int node : graph[i]) {
                reverseGraph.get(node).add(i);
            }
            outdegree[i] = graph[i].length;
            if(outdegree[i]==0) queue.offer(i);
        }

        for(int i=0; i<graph.length; i++) {
            outdegree[i] = graph[i].length;
        }

        List<Integer>list = new ArrayList<>();
        while(!queue.isEmpty()) {
            int num = queue.poll();
            list.add(num);
            for(int v: reverseGraph.get(num)) {
                outdegree[v]--;
                if(outdegree[v]==0) queue.offer(v);
            }
        } 
        Collections.sort(list);
        return list;
    }
}