class TimeMap {
    Map<String,TreeMap<Integer,String>> timeMap;

    public TimeMap() {
    timeMap = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new TreeMap<>());
        timeMap.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) return "";
        TreeMap<Integer,String> innerMap = timeMap.get(key);
        Integer floorKey = innerMap.floorKey(timestamp);
        if(floorKey==null) return "";
        return innerMap.get(floorKey);
        
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */