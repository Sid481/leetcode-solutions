class Solution {
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList();
        Arrays.sort(candidates);
        backtrack(candidates,0,new ArrayList(),target,result);
        return result;
    }
private void backtrack(int[] candidates, int index, List<Integer> current, int target,List<List<Integer>> result) {
        if(target==0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            current.add(candidates[i]);
            backtrack(candidates,i+1,current,target-candidates[i],result);
            current.remove(current.size()-1);
        }
    }
}