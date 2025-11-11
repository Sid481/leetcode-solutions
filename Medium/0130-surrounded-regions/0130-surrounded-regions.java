class Solution {
    int direction[][] = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<row; i++) {
            if(board[i][0]=='O')dfs(i,0,board,visited);
            if(board[i][col-1]=='O')dfs(i,col-1,board,visited);
        }
        for(int j=0; j<col; j++) {
            if(board[0][j]=='O')dfs(0,j,board,visited);
            if(board[row-1][j]=='O')dfs(row-1,j,board,visited);
        }
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(board[i][j]=='O' && !visited[i][j])
                    board[i][j] = 'X';
                }
            }
        }
    public void dfs(int i, int j, char[][]grid, boolean[][] visited) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
        return;
        if(grid[i][j]!='O' || visited[i][j])
        return;
        visited[i][j] = true;
        for(int[] dir : direction) {
            dfs(i+dir[0],j+dir[1],grid,visited);
        }
     }
}
