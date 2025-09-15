class Solution {
    public class TrieNode {
        private TrieNode[] children = new TrieNode[2];
    }
   
        TrieNode root = new TrieNode();

        public void insert(int num) {
            TrieNode node = root;
            for(int i=31; i>=0; i--) {
                int bit = (num >> i) & 1;
                if(node.children[bit]==null) {
                   node.children[bit] =  new TrieNode();
                }
                node = node.children[bit];
            }
        }
        public int getMax(int num) {
            TrieNode node = root;
            int xor = 0;
            for(int i=31; i>=0; i--) {
                int bit = (num>>i)&1;
                int opposite = bit^1;
                if(node.children[opposite]!=null) {
                    xor |= (1<<i);
                    node = node.children[opposite];
                } else {
                node = node.children[bit];
                }
            }
            return xor;
        }
         public int findMaximumXOR(int[] nums) {
            int max = 0;
            for(int num : nums) {
                insert(num);
            }
            for(int num : nums) {
                max = Math.max(max, getMax(num));
            }
            return max;
    }
}