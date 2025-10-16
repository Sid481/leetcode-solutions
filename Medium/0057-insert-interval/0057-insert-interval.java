class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]>minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        for(int[] interval : intervals) {
            minHeap.offer(interval);
        }
        minHeap.offer(newInterval);
        int current[] = minHeap.poll();
        while(!minHeap.isEmpty()) {
            int[] next = minHeap.poll();
            if(current[1]>=next[0]) {
                current[1] = Math.max(current[1],next[1]);
            } else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}
