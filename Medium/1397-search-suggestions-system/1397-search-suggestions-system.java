 class TrieNode {
        TrieNode[] children=new TrieNode[26];;
        List<String> suggestions=new ArrayList<>();

    }
class Solution {
    TrieNode root = new TrieNode();

    public void addNode(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()) {
            int index = ch-'a';
            if(current.children[index]==null) {
              current.children[index] = new TrieNode();
            }
            current = current.children[index];
            if(current.suggestions.size()<3) {
                current.suggestions.add(word);
            }
        }
    }
    public List<String> search(String prefix) {
            TrieNode current = root;
            for(char ch : prefix.toCharArray()) {
                int index = ch-'a';
                if(current.children[index]==null) {
                    return new ArrayList<>();
                }
                current = current.children[index];
            }
            return current.suggestions;
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Solution trie = new Solution();
        Arrays.sort(products);
        for(String product : products) {
            trie.addNode(product);
        }
       List<List<String>> result = new ArrayList<>();
       for(int i=0; i<searchWord.length(); i++) {
        String prefix = searchWord.substring(0,i+1);
        result.add(trie.search(prefix));
       }
       return result;
    }
}