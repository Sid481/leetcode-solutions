class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean used[] = new boolean[n];
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums,n,used,curr,ans);
        return ans;
    }
    private static void backtrack(int[] nums, int n,boolean[] used, List<Integer>curr,List<List<Integer>> ans) {
        if(curr.size()==n) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<n; i++) {
        if(!used[i]) {
            used[i] = true;
            curr.add(nums[i]);
            backtrack(nums,n,used,curr,ans);
            curr.remove(curr.size()-1);
            used[i] = false;
            }
        }
    }

}