class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int column = heights[0].length;
        int direction[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        PriorityQueue<int[]>minHeap = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        int[][] distance = new int[row][column];
        for(int[]ro:distance) {
        Arrays.fill(ro, Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        minHeap.add(new int[]{0,0,0});
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int diff = curr[0];
            int r = curr[1];
            int c = curr[2];
            if(r==row-1 && c==column-1)return diff;
            if(diff > distance[r][c]) continue;
            for(int dir[] : direction) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                if(newR<0 || newC<0 || newR>=row || newC>=column) continue;
                int newDiff = Math.max(diff,Math.abs(heights[r][c]-heights[newR][newC]));
                if(newDiff<distance[newR][newC]) {
                distance[newR][newC] = newDiff;
                minHeap.offer(new int[]{newDiff,newR,newC});
                }
            }
         }
         return distance[row-1][column-1];
    }
}