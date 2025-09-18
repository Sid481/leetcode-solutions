class Solution {
    public String frequencySort(String s) {
        int maxValue = Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
          maxValue = Math.max(maxValue,entry.getValue());
        }
       List<Character>[] bucket = new List[maxValue+1];

       for(Map.Entry<Character,Integer> entry : map.entrySet()) {
        int freq = entry.getValue();
        char ch = entry.getKey();
        if(bucket[freq]==null) {
            bucket[freq] = new ArrayList<>();

        }
        bucket[freq].add(ch);
       }
       StringBuilder sb = new StringBuilder();
       for(int i=maxValue; i>=0; i--) {
        if(bucket[i]!=null) {
            for(char ch :  bucket[i]) { 
                sb.append(String.valueOf(ch).repeat(i));
                }
            }
       }
       return sb.toString();
    }
}