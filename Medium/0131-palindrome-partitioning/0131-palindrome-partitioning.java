class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s,0,new ArrayList(),result);
        return result;

    }
    public void backtrack(String s, int start, List<String> subString,List<List<String>>result) {
        //base case;
        if(start==s.length()) {
            result.add(new ArrayList<>(subString));
            return;
        }
        for(int end=start; end<s.length(); end++) {
            String sub = s.substring(start,end+1);
            if(palindrome(sub)) {
                subString.add(sub);
                backtrack(s,end+1,subString,result);
                subString.remove(subString.size()-1);
            }
        }
    }
    public boolean palindrome(String str) {
        int left = 0;
        int right = str.length()-1;
        while(left<right) {
            if(str.charAt(left)!=str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
