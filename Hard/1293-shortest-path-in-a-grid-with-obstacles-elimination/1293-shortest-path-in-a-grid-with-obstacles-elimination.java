class Solution {
    int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
       int steps = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][][]visited = new boolean[row][col][k+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,k});
        visited[0][0][k] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                int[]curr = queue.poll();
                int r=curr[0];
                int c=curr[1];
                int remK=curr[2];
                if(r==row-1 && c==col-1) return steps;

                for(int[]dir : direction) {
                int nr = curr[0]+dir[0];
                int nc = curr[1]+dir[1];
                if(nr>=0 && nc>=0 && nr<row && nc<col) {
                    int newK = remK-grid[nr][nc];
                    if(newK >= 0 && !visited[nr][nc][newK]) {
                        visited[nr][nc][newK]= true;
                        queue.offer(new int[]{nr,nc,newK});
                            }
                    
                        }
                    } 
                } 
            steps++;
        }
        return -1; 
    }
}
