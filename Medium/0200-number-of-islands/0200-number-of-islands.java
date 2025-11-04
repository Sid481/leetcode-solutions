class Solution {
    int count = 0;
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int numIslands(char[][] grid) { 
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1' && !visited[i][j]) {
                    count++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }

     void dfs(int i, int j, char[][] grid, boolean[][] visited) {
            if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0' || visited[i][j]) {  
            return;
            }
            visited[i][j]=true;
            for(int[]direction : dir) {
                dfs(i+direction[0], j+direction[1], grid, visited);
            }
        }
}
