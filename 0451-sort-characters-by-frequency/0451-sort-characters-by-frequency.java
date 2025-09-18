class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap;
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        maxHeap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()) {
           char ch =  maxHeap.peek().getKey();
           int count = maxHeap.poll().getValue();
           for(int i=0; i<count; i++) {
            sb.append(ch);
           }
        }
       return sb.toString();
    }
}