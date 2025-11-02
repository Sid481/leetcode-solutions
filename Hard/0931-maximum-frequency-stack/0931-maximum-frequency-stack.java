class FreqStack {
    Map<Integer,Integer> frequencyMap;
    Map<Integer,Stack<Integer>> groupMap;
    private int freq = Integer.MIN_VALUE;
    public FreqStack() {
      frequencyMap  = new HashMap<>();
      groupMap = new HashMap<>();
    }
    
    public void push(int val) {
        frequencyMap.put(val,frequencyMap.getOrDefault(val,0)+1);
        int frequency = frequencyMap.get(val);
        freq = Math.max(freq,frequency);

        if(!groupMap.containsKey(frequency))
            groupMap.put(frequency,new Stack<>());
            groupMap.get(frequency).push(val);
        }
    
    public int pop() {
        Stack<Integer> stack = groupMap.get(freq);
        int val = stack.pop();
        frequencyMap.put(val,frequencyMap.get(val)-1);
        if(stack.isEmpty()) freq--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */