class Solution {
    int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public int[][] floodFill(int[][] matrix, int r, int c, int num) {
        int row = r;
        int col = c;
        int existingNum = matrix[row][col];
        int[][] result = new int[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        dfs(matrix,existingNum,row,col,visited,num);
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }

    public void dfs(int[][]matrix, int existingNum, int row, int col, boolean[][] visited, int newNum) {
    if(row<0 || col<0 || row>=matrix.length || col>=matrix[0].length || matrix[row][col]!=existingNum || visited[row][col]) return;
        matrix[row][col] = newNum;
        visited[row][col]=true;

        for(int[]d : dir) {
            dfs(matrix,existingNum,row+d[0],col+d[1],visited,newNum);
        }
    }
}
