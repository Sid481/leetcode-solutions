class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i]==0) {
                queue.offer(i);
            }
        }
        int index = 0;
        int[]result = new int[numCourses];
        while(!queue.isEmpty()) {
            int node = queue.poll();
            result[index++] = node;
            for(int v : graph.get(node)) {
                indegree[v]--;
                if(indegree[v]==0)queue.offer(v);
            }
        }
        if(index!=numCourses) return new int[0];
        return result;
    }
}
