class SnapshotArray {
    int snapId = 0;
    Map<Integer, TreeMap<Integer,Integer>> snapMap;
    public SnapshotArray(int length) {
       snapMap = new HashMap<>();
       for(int i=0; i<length; i++) {
            snapMap.put(i,new TreeMap<>());
            snapMap.get(i).put(0,0);
       }
    }
    
    public void set(int index, int val) {
       snapMap.get(index).put(snapId,val);
    }
    
    public int snap() {
       return snapId++;
    }
    
    public int get(int index, int snap_id) {
        if(!snapMap.containsKey(index)) return 0;
       TreeMap<Integer,Integer> map = snapMap.get(index);
       Integer id = map.floorKey(snap_id);
       if(id==null) return 0;
       return map.get(id);

    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */