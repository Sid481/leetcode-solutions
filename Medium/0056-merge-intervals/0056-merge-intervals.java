class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]>heap = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
       for(int[] interval : intervals) {
            if(!heap.isEmpty()) {
               int[] top = heap.peek();
               if(top[1]>=interval[0]) {
                heap.poll();
               int merged[] = new int[]{top[0],Math.max(top[1],interval[1])};
               heap.add(merged);
               } else {
                heap.add(interval);
                result.add(heap.poll());
               }
            } else {
            heap.add(interval);
            }
       }
       while(!heap.isEmpty()) {
        result.add(heap.poll());
       } 
        return result.toArray(new int[result.size()][]);
    }
}
