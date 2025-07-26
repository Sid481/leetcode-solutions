class Solution {
    private static final Map<Character,String> digitMap = Map.of(
        '2',"abc", '3',"def",'4',"ghi",'5',"jkl",'6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz"
    );
    public List<String> letterCombinations(String digits) {
       List<String> result = new ArrayList<>();
       if(digits.length()==0 || digits==null) return result; 
       backtrack(0,digits,new StringBuilder(),result);
       return result; 
    }
    private void backtrack(int index,String digit, StringBuilder path, List result) {
        if(index==digit.length()) {
            result.add(path.toString());
            return;
        }

        String possibleLetters = digitMap.get(digit.charAt(index));
        for(char ch : possibleLetters.toCharArray()) {
            path.append(ch);
            backtrack(index+1,digit,path,result);
            path.deleteCharAt(path.length()-1);
        }
    }
}