class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.size(); i++) {
        int val = nums.get(i).get(0);
        minHeap.offer(new int[] {val,i,0});
        max = Math.max(max,val);
        }
        int rangeStart = 0; int rangeEnd = Integer.MAX_VALUE;
        while(minHeap.size()==nums.size()) {
            int[] curr = minHeap.poll();
            int min = curr[0];
            if(max-min<rangeEnd-rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            int listIndex = curr[1]; 
            int eleIndex = curr[2];
            if(eleIndex+1 < nums.get(listIndex).size()) {
            int newVal = nums.get(listIndex).get(eleIndex+1);
            minHeap.offer(new int[]{newVal,listIndex,eleIndex+1});
            max = Math.max(max,newVal);
            }
        }
        return new int[]{rangeStart,rangeEnd};
    }
}