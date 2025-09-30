class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,Comparator.comparingInt(a->a[0]));
        int shots = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        for(int point[] : points) {
            int start = point[0];
            int end = point[1];
            if(minHeap.isEmpty() || minHeap.peek()[1]<start) {
               minHeap.clear();
               shots++;
            } else {
                int top[] = minHeap.poll();
                end = Math.min(end, top[1]);
            }
            minHeap.offer(new int[]{start,end});
        }
        return shots;
    }
}
