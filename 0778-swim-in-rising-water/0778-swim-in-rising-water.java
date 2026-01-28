class Solution {
    public int swimInWater(int[][] grid) {
        int[][] direction = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->a[0]-b[0]);
        minHeap.add(new int[] {grid[0][0],0,0});
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        while (!minHeap.isEmpty()) {
            int current[] = minHeap.poll();
            int elevation = current[0];
            int r = current[1];
            int c = current[2];
            if (r == n - 1 && c == n - 1)
                return elevation;
            if (visited[r][c])
                continue;
            visited[r][c] = true;

            for (int[] dir : direction) {
                int newR = dir[0] + r;
                int newC = dir[1] + c;
                if (newR<0 || newC<0 || newR>=n || newC>=n || visited[newR][newC]) continue;
                    int newElevation = Math.max(elevation, grid[newR][newC]);
                    minHeap.offer(new int[] { newElevation, newR, newC });
            }
        }
        return -1;
    }
}