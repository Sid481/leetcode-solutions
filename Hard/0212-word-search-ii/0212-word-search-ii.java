class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    public List<String> findWords(char[][] board, String[] words) {
       TrieNode root = buildTree(words);
       List<String> result = new ArrayList<>();

       for(int i=0; i<board.length; i++) {
        for(int j=0; j<board[0].length; j++) {
            backtrack(board,i,j,root,result);
        }
       }
        return result;
    }

    private void backtrack(char[][]board,int i, int j, TrieNode node, List<String> result) {
            char ch = board[i][j];
            if(ch=='#' || node.children[ch-'a']==null) return;

            node = node.children[ch-'a'];
            if(node.word!=null) {
                result.add(node.word);
                node.word=null;
            }
            board[i][j] = '#';
            int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
            for(int[] d : dirs) {
                int ni = i + d[0], nj = j + d[1];
                if(ni >= 0 && nj >= 0  && ni<board.length && nj <board[0].length) {
                    backtrack(board,ni,nj,node,result);
                }
            }
            board[i][j] = ch;

    }

    private TrieNode buildTree(String words[]) {
        TrieNode root = new TrieNode();
        for(String w : words) {
            TrieNode node = root;
            for(char ch : w.toCharArray()) {
                if(node.children[ch-'a']==null)
                    node.children[ch-'a'] = new TrieNode();
                    node = node.children[ch-'a'];
                }
                node.word = w;
            }
            return root;
    }
}
