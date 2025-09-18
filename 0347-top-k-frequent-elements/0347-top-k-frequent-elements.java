class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    PriorityQueue<Map.Entry<Integer,Integer>> maxHeap;
    int result[];
    public int[] topKFrequent(int[] nums, int k) {
        result = new int[k];
        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        maxHeap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        for(int i=0; i<k; i++) {
            Map.Entry<Integer,Integer> entry = maxHeap.poll();
            result[i] = entry.getKey();
        }
        return result;
    }
}