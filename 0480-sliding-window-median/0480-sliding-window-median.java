class Solution {
        PriorityQueue<Integer> leftHeap;
        PriorityQueue<Integer> rightHeap;
        Map<Integer,Integer> map;
        double[] result;
        int leftSize;
        int rightSize;
    public double[] medianSlidingWindow(int[] nums, int k) {
       leftHeap = new PriorityQueue<>(Collections.reverseOrder());
       rightHeap = new PriorityQueue<>();
       result = new double[nums.length-k+1];
       map = new HashMap<>();
       leftSize=rightSize=0;
       for(int j=0; j<k; j++)add(nums[j]);
       result[0]=getMedian(k);
    
       for(int i=k; i<nums.length; i++) {
        add(nums[i]);
        remove(nums[i-k]);
        result[i-k+1] = getMedian(k);
        }
        return result;
    }

    public void add(int num) {
        if(leftHeap.isEmpty() || num<leftHeap.peek()) {
            leftHeap.offer(num);
            leftSize++;
        } else {
            rightHeap.offer(num);
            rightSize++;
        }
        rebalance();
    }
    public void remove(int num) {
        map.put(num, map.getOrDefault(num,0)+1);
        if(num <= leftHeap.peek()) leftSize--;
        else rightSize--;
        prune(leftHeap);
        prune(rightHeap);
        rebalance();
    }
    public void prune(PriorityQueue<Integer>heap) {
     while(!heap.isEmpty()) {
        int num = heap.peek();
        if(map.containsKey(num)) {
            map.put(num,map.get(num)-1);
            if(map.get(num)==0) map.remove(num);
            heap.poll();
        } else break;
     }  
    }
    public void rebalance() {
        if(leftSize>rightSize+1) {
            rightHeap.offer(leftHeap.poll());
            leftSize--;
            rightSize++;
            prune(leftHeap);
        } else if(leftSize<rightSize) {
            leftHeap.offer(rightHeap.poll());
            leftSize++;
            rightSize--;
            prune(rightHeap);
        }
    }
    public double getMedian(int k) {
        if(leftSize==rightSize)
        return ((long)leftHeap.peek()+(long)rightHeap.peek())/2.0;
        return  leftSize>rightSize?leftHeap.peek():rightHeap.peek();
    }
    }