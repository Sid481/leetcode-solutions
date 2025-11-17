class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int maxSize = 0;
        int index = 2;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1) {
                int size = dfs(i,j,grid,index);
                map.put(index,size);
                index++;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==0) {
                    Set<Integer> visitedIsland = new HashSet<>();
                    int potentialSize = 1;
                    for(int[] dir : new int[][]{{1,0},{0,1},{-1,0},{0,-1}}) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if(ni>=0 && ni<n && nj>=0 && nj<n && grid[ni][nj]>1) {
                            int neighbourId = grid[ni][nj];
                            if(!visitedIsland.contains(neighbourId)) {
                                potentialSize += map.get(neighbourId);
                                visitedIsland.add(neighbourId);
                            }
                        }
                    }
                    maxSize =  Math.max(maxSize,potentialSize);
                }
            }
        }
         
         return maxSize==0?n*n:maxSize;
    }
    public int dfs(int i, int j, int[][]grid, int index) {
        if(i<0 || j<0 || i>=grid.length || j>=grid.length || grid[i][j] != 1) return 0;
        grid[i][j] = index;
        int size = 1;
        size += dfs(i+1, j, grid, index);
        size += dfs(i, j+1, grid, index);
        size += dfs(i-1, j, grid, index);
        size += dfs(i, j-1, grid, index);
        return size;
    }
}