class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer>map = new HashMap<>();

        for(char ch : s.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a,b)->
        b.getValue()-a.getValue());
        
        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        Map.Entry<Character,Integer> prev = null;

        while(!maxHeap.isEmpty()) {
            Map.Entry<Character,Integer> current = maxHeap.poll();
            sb.append(current.getKey());
            current.setValue(current.getValue()-1);
            if(prev!=null && prev.getValue()>0) {
                maxHeap.offer(prev);
            }
            prev = current;
        }
        return (sb.length()!=s.length())?"":sb.toString();
    }
}
