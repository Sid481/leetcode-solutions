class Solution {
    int direction[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int result[][] = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(mat[i][j]==1)
                queue.offer(new int[]{i,j});
            }
        }
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                result[i][j] = 0;
            }
        }
       while(!queue.isEmpty()) {
        int size = queue.size();
        for(int i=0; i<size; i++) {
            int[] curr = queue.poll();
            int minutes=0;
            for(int[] dir : direction) {
                int nr = curr[0]+dir[0];
                int nc = curr[1]+dir[1];
                if(nr<0 || nc<0 || nr>=row || nc>=col)continue;
                if(mat[nr][nc]==0) {
                    minutes++;
                    result[curr[0]][curr[1]] = minutes;
                    return result;
                } else {
                    queue.offer(new int[]{nr,nc});
                    }
                }   
            }
        }
        return result;
    }
}