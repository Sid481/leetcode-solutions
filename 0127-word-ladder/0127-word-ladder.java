class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>words = new HashSet<>(wordList);
        HashSet<String>visited = new HashSet<>();
        if(!words.contains(endWord)) return 0;
        Queue<String>queue = new LinkedList<>();
        int steps = 1;
        queue.offer(beginWord);
        visited.add(beginWord);
        

        while(!queue.isEmpty()) {
            int size = queue.size();
            if(queue.peek().equals(endWord)) return steps;
            for(int i=0; i<size; i++) {
                String word = queue.poll();
                for(int j=0; j<word.length(); j++) {
                    for(char ch='a'; ch<='z'; ch++) {
                        if(ch == word.charAt(j)) continue;
                        String forward = setForward(word,j,ch);
                if(!visited.contains(forward) && words.contains(forward)) {
                    queue.offer(forward);
                    visited.add(forward);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }
    public String setForward(String word, int index, char ch) {
        char[] arr = word.toCharArray();
        arr[index] = ch;
        return new String(arr);
        }
    }