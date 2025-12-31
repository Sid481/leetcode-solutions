class Solution {
    public int candy(int[] ratings) {
        int[]child = new int[ratings.length];

        for(int i=0; i<child.length; i++)
            child[i]=1;
        for(int left = 1; left<child.length; left++) {
            if(ratings[left]>ratings[left-1])
            child[left] = child[left-1]+1;
        }
        for(int right=child.length-2; right>=0; right--) {
            if(ratings[right]>ratings[right+1]) 
            child[right] = child[right+1]+1;
        }
        int numberOfCandies = 0;
        for(int i=0; i<child.length; i++) {
            numberOfCandies += child[i];
        }
        return numberOfCandies;
    }
}