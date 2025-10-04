class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        int n = events.length;
        int count = 0;
        int day = 0;
        int i = 0;
        while(i<n || !minHeap.isEmpty()) {
            if(minHeap.isEmpty()) {
                day = (events[i][0]);
            }
            while(i<n && events[i][0]==day) {
                minHeap.offer(events[i][1]);
                i++;
            }
            while(!minHeap.isEmpty() && minHeap.peek()<day) {
                minHeap.poll();
            }
            if(!minHeap.isEmpty()) {
                minHeap.poll();
                count++;
                day++;
            }
        }
    return count;
    } 
}
