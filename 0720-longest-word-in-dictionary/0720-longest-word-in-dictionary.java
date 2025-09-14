class Solution {
    TrieNode root = new TrieNode();
    String longestString = "";
    public String longestWord(String[] words) {
        Arrays.sort(words);
        for(String word : words) {
        insert(word);
        }
        dfs(root, new StringBuilder());
        return longestString;
    }
    public void dfs(TrieNode node, StringBuilder path) {
        if(path.length()>longestString.length()) {
            longestString = path.toString();
        }
        for(int i=0; i<26; i++) {
            if(node.children[i]!=null && node.children[i].isWord) {
            path.append((char)(i+'a'));
            dfs(node.children[i],path);
            path.deleteCharAt(path.length()-1);
            }
        }
    }
    public void insert(String words) {
        TrieNode current = root;
        for(char ch : words.toCharArray()) {
            int index = ch-'a';
            if(current.children[index]==null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }
}
class TrieNode {
    TrieNode[] children;
    boolean isWord;
    public TrieNode() {
      children = new TrieNode[26];
      isWord = false;
    }
}
