class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int count = 0;
        int newStart = 0;
        for(int[] interval : intervals) {
                if(end >= interval[0] && count==0) {
                    int merged[] = new int[]{Math.min(start,interval[0]),Math.max(end,interval[1])};
                    end = merged[1];
                    newStart = Math.min(start,interval[0]);
                    count++;
                    minHeap.offer(merged);
                } else if(end >= interval[0]) {
                    int top [] = minHeap.poll();
                    int merged[] = new int[]{Math.min(interval[0],top[0]),Math.max(end,interval[1])};
                    end = merged[1];
                    minHeap.offer(merged);
                } else {
                    minHeap.add(interval);
                }
    }
    if(count==0) {
        minHeap.offer(newInterval);
    }
    while(!minHeap.isEmpty()) {
        result.add(minHeap.poll());
    }
    
    int[][] finalResult = result.toArray(new int[result.size()][]);
    Arrays.sort(finalResult, (a,b)->Integer.compare(a[0],b[0]));
    return finalResult;
    }
}