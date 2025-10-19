class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for(char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        int maxCount = 0;
        char maxChar = 'a';
        for(int i = 0; i < 26; i++) {
            if(count[i] > maxCount) {
                maxCount = count[i];
                maxChar = (char) (i + 'a');
            }
        }
        if(maxCount > (s.length()+1)/2) {
            return "";
        }
        char[]result = new char[s.length()];
        int index = 0;

        while(count[maxChar - 'a'] > 0) {
            result[index] = maxChar;
            index += 2;
            count[maxChar - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            while(count[i] > 0) {
                if(index >= result.length) {
                    index = 1;
                }
                result[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }
        return new String(result);
    }
}