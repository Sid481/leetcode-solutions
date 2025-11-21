class Solution {
    int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int minutes = 0;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j]==2)
                queue.offer(new int[]{i,j});
                else if(grid[i][j]==1)
                    fresh++; 
            }
        }
            if(fresh==0) return 0;
            while(!queue.isEmpty()) {
                int size = queue.size();
                boolean rotted = false;
                for(int j=0; j<size; j++) {
                    int[] curr = queue.poll();

                for(int[] dir : direction) {
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr>=0 && nr<row && nc>=0 && nc<col && grid[nr][nc]==1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        rotted = true;
                        queue.offer(new int[]{nr,nc});
                        }
                    }
                }
                if(rotted)minutes++;
                }
            return fresh==0?minutes:-1;
        }
    }