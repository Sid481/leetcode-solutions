class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        
        maxHeap.offer(new int[]{grid[0][0],0,0});       
        while(!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            int elevation = current[0];
            int r = current[1];
            int c = current[2];
            if(r==n-1 && c==n-1) return elevation;
            if(visited[r][c]) continue;
            visited[r][c] = true;

            for(int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                if(newR>=0 && newC>=0 && newR<n && newC<n && !visited[newR][newC]) {
                int newElevation = Math.max(elevation, grid[newR][newC]);
                maxHeap.offer(new int[]{newElevation,newR,newC});
                }
            }
        }
        return -1;
    }
}
