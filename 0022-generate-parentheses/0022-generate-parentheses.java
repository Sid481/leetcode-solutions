class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        //if(n==0) return result;
        backtrack(0,0,result,new StringBuilder(),n);
        return result;
    }
    private void backtrack(int open, int close, List<String> result, StringBuilder current, int n) {
            if(current.length()==n*2) {
                result.add(current.toString());
                return;
            }
            if(open<n) {
                current.append('(');
                backtrack(open+1,close,result,current,n);
                current.deleteCharAt(current.length()-1);
            }
            if(close<open) {
                current.append(')');
                backtrack(open,close+1,result,current,n);
                current.deleteCharAt(current.length()-1);
            }
    }
}