class Solution {
    int max = Integer.MIN_VALUE;
    public int findMaximumXOR(int[] nums) {
        if(nums.length==1) return 0;
        for(int i=1; i<nums.length; i++) {
            for(int j=i-1; j>=0; j--) {
                int result = nums[i]^nums[j];
                max = Math.max(result, max);
            }
        }
        return max;
    }
}