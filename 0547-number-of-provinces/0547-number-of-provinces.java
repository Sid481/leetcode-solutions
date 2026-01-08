class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int numberOfProvince = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
            queue.offer(i);
        while(!queue.isEmpty()) {
            int city = queue.poll();
            visited[city] = true;
            for(int j=0; j<n; j++) {
                if(isConnected[city][j]==1 && !visited[j])
                    queue.offer(j);
                }
             }
             numberOfProvince++;
            }
        }
        return numberOfProvince;
    }
}