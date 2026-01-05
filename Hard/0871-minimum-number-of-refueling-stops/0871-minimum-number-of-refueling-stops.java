class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>((a,b)->b-a);
        int fuel = startFuel;
        int i=0;
        int stop = 0;
        while(fuel<target) {

            while(i<stations.length && stations[i][0]<=fuel) {
            maxHeap.offer(stations[i++][1]);
            }

            if(maxHeap.isEmpty()) return -1;
            fuel += maxHeap.poll();
            stop++;
        }
        return stop;
    }
}
