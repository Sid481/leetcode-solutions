class WordDictionary {
    private class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    private TrieNode root;

    public WordDictionary() {
         root = new TrieNode();   
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()) {
            int index = ch-'a';
            if(current.children[index]==null) {
               current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word,root,0);
    }

    public boolean searchInNode(String word, TrieNode node, int pos) {
        if(pos==word.length()) {
            return node.isWord;
        }
        char ch = word.charAt(pos);
        if(ch=='.') {
            for(TrieNode child : node.children) {
                if(child != null && searchInNode(word,child,pos+1)) {
                    return true;
                }
            }
            return false;
        } else {
            int index = ch-'a';
            return node.children[index]!=null && searchInNode(word,node.children[index],pos+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
