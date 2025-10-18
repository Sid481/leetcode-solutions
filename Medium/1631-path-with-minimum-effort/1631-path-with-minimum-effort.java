class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int column = heights[0].length;
        int direction[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        int[][] dist = new int[row][column];
        for(int[] ro : dist) {
            Arrays.fill(ro,Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        minHeap.offer(new int[]{0,0,0});

        while(!minHeap.isEmpty()) {
           int[] curr = minHeap.poll();
           int diff = curr[0];
           int r = curr[1];
           int c = curr[2];
           if(r==row-1 && c==column-1) return diff;
           if(dist[r][c]<diff) continue;

           for(int[] dir : direction) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            if(newR<0 || newC<0 || newR>=row || newC>=column) continue;
            int newDiff = Math.max(diff, Math.abs(heights[r][c]-heights[newR][newC]));
            if(newDiff<dist[newR][newC]) {
                dist[newR][newC] = newDiff;
                minHeap.offer(new int[]{newDiff,newR,newC});
            }
           }
        }
        return 0;
    }
}
