class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target) return 0;
        Map<Integer,List<Integer>> stopToBus = new HashMap<>();

        for(int bus=0; bus<routes.length; bus++) {
            for(int stop : routes[bus]) {
                if(!stopToBus.containsKey(stop)) {
                    stopToBus.put(stop,new ArrayList<Integer>());
                }
                stopToBus.get(stop).add(bus);
            }
        }
        Queue<Integer>queue = new LinkedList<>();
        Set<Integer>visitedStop = new HashSet<>();
        boolean[] visitedBus = new boolean[routes.length];
        queue.offer(source);
        visitedStop.add(source);
        int busTaken = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            busTaken++;
            while(size-->0) {
            int currStop = queue.poll();
            List<Integer> buses = stopToBus.getOrDefault(currStop, new ArrayList<>());

            for(int bus : buses) {
                if(visitedBus[bus]) continue;
                visitedBus[bus] = true;
                for(int nextStop : routes[bus]) {
                    if(nextStop==target)return busTaken;
                    if(!visitedStop.contains(nextStop)) {
                        visitedStop.add(nextStop);
                        queue.offer(nextStop);
                        }
                    }
                }
            }
        }
    return -1;  
    }
}
