class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(board[i],'.');
        }
        backtrack(result,board,0,new boolean[n], new boolean[2*n], new boolean[2*n]);
        return result;
    }

    private void backtrack(List<List<String>>result,char[][] board,int row,boolean cols[],
    boolean[]d1, boolean[]d2) {
        int n = board.length;
        if(row==n) {
            List<String> solution = new ArrayList<>();
            for(char[] r:board) {
                solution.add(new String(r));
            }
            result.add(solution);
            return;
        }

        for(int col=0; col<n; col++) {
            int dig1 = row-col+n;
            int dig2 = row+col;
            if(cols[col]||d1[dig1]||d2[dig2]) continue;
                board[row][col] = 'Q';
                cols[col]=d1[dig1]=d2[dig2] = true;
                backtrack(result,board,row+1,cols,d1,d2);
                board[row][col] = '.';
                cols[col]=d1[dig1]=d2[dig2] = false;
            }
        }
    }
