class Solution {
    int[][]direction = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    List<List<Integer>> result;
    int row;
    int col;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        boolean[][] Pvisited = new boolean[row][col];
        boolean[][] Avisited = new boolean[row][col];
        result = new ArrayList<>();
        for(int i=0; i<row; i++) {
            dfs(i,0,heights,Pvisited);
        }
        for(int j=0; j<col; j++) {
            dfs(0,j,heights,Pvisited);
        }
        for(int i=0; i<row; i++) {
            dfs(i,col-1,heights,Avisited);
        }
        for(int j=0; j<col; j++) {
            dfs(row-1,j,heights,Avisited);
        }
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(Pvisited[i][j] && Avisited[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    public void dfs(int i, int j, int[][] heights,boolean[][]visited) {
            visited[i][j] = true;

            for(int[] dir : direction) {
                int nRow = i+dir[0];
                int nCol = j+dir[1]; 
                if(nRow<0 || nCol<0 || nRow>=row || nCol>=col) continue;
                if(visited[nRow][nCol]) continue;
                if(heights[nRow][nCol]<heights[i][j]) continue;

                dfs(nRow,nCol,heights,visited);
            }
    }
}