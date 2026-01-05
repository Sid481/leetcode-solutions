class Solution {
    public int candy(int[] ratings) {
        int[]child = new int[ratings.length];
        Arrays.fill(child,1);

        for(int left = 1; left<child.length; left++) {
            if(ratings[left]>ratings[left-1])
            child[left] = child[left-1]+1;
        }
        for(int right=child.length-2; right>=0; right--) {
            if(ratings[right]>ratings[right+1]) 
            child[right] = Math.max(child[right],child[right+1]+1);
        }
        int numberOfCandies = 0;
        for(int candy : child) {
            numberOfCandies += candy;
        }
        return numberOfCandies;
    }
}
