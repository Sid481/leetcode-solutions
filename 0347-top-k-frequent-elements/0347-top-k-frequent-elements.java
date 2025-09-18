class Solution {
    PriorityQueue<Map.Entry<Integer,Integer>> maxHeap;
    int result[];
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        result = new int[k];
        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        maxHeap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        maxHeap.addAll(map.entrySet());
        for(int i=0; i<k && !maxHeap.isEmpty(); i++) {
            result[i] = maxHeap.poll().getKey();
        }
        return result;
    }
}