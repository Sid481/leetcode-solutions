class StockPrice {
    Map<Integer,Integer> map;
    TreeMap<Integer,Integer> priceMap;
    int latestTimeStamp;
    public StockPrice() {
        map = new HashMap<>();
        priceMap = new TreeMap<>();
        latestTimeStamp = 0;
    }
    
    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)) {
            int oldPrice = map.get(timestamp);
            priceMap.put(oldPrice,priceMap.get(oldPrice)-1);
            if(priceMap.get(oldPrice)==0) priceMap.remove(oldPrice);
        }
        map.put(timestamp,price);
        priceMap.put(price,priceMap.getOrDefault(price,0)+1);
        latestTimeStamp = Math.max(latestTimeStamp,timestamp);
    }
    
    public int current() {
        return map.get(latestTimeStamp);
    }
    
    public int maximum() {
        return priceMap.lastKey();
    }
    
    public int minimum() {
        return priceMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */