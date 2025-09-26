class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(a->a[1]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        int currPass = 0;
        for(int[] trip : trips) {
            int numPass = trip[0];
            int start = trip[1];
            int end = trip[2];
            while(!minHeap.isEmpty() && minHeap.peek()[0]<=start) {
                currPass -= minHeap.poll()[1];
            }
            currPass += numPass;
            if(currPass>capacity) {
                return false;
            }
            minHeap.offer(new int[]{end,numPass});
        }
        return true;
    }
}