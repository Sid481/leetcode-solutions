class Solution {
    int direction[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int result[][] = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(mat[i][j]==0) {
                queue.offer(new int[]{i,j});
                visited[i][j] = true;
                }
            }
        }
       int distance = 0;
       while(!queue.isEmpty()) {
        int size = queue.size();
        for(int i=0; i<size; i++) {
            int[] curr = queue.poll();
            result[curr[0]][curr[1]] = distance;
            for(int[] dir : direction) {
                int nr = curr[0]+dir[0];
                int nc = curr[1]+dir[1];

                if(nr>=0 && nc>=0 && nr<row && nc<col && !visited[nr][nc] && mat[nr][nc]==1) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                    } 
                }  
            }
            distance++; 
       }
        return result;
    }
}