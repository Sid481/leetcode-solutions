class Solution {
    int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int column = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][column];
        for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
            if(grid[i][j]=='1' && !visited[i][j]) {
            count++;
            queue.offer(new int[]{i,j});
            visited[i][j] = true;
            }
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            for(int[] dir : direction) {
                int newRow = arr[0] + dir[0];
                int newCol = arr[1] + dir[1];
                if(newRow>=0 && newCol>=0 && newRow<row && newCol<column && !visited[newRow][newCol] && grid[newRow][newCol]=='1') {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow,newCol});
                        }  
                    }
                }
            }
        }
        return count;   
    }
}