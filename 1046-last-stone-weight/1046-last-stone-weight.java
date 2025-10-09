class Solution {
    public int lastStoneWeight(int[] stones) {
        //if(stones.length==1) return stones[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        for(int stone : stones) {
            maxHeap.offer(stone);
        }
        while(maxHeap.size()>1) {
            Integer first = maxHeap.poll();
            Integer second = maxHeap.poll();
            if(Math.abs(first-second)>0)
            maxHeap.offer(Math.abs(first-second));
        }
        return maxHeap.size()>0?maxHeap.peek():0;
    }
}