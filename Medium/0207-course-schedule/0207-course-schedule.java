class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[]pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if (indegree[i]==0) queue.offer(i);
        }
        int index = 0;
        while(!queue.isEmpty()) {
            int num = queue.poll();
            index++;
            for(int v : graph.get(num)) {
                indegree[v]--;
                if(indegree[v]==0) queue.offer(v);
            }
        }
       return index==numCourses?true:false;
    }
}
