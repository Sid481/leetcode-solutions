class MedianFinder {
    PriorityQueue<Integer>leftHeap;
    PriorityQueue<Integer>rightHeap;
    public MedianFinder() {
        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftHeap.isEmpty() || num < leftHeap.peek()) leftHeap.offer(num);
        else rightHeap.offer(num);
        
        if(leftHeap.size()>rightHeap.size()+1)
            rightHeap.offer(leftHeap.poll());
        else if(rightHeap.size()>leftHeap.size())
            leftHeap.offer(rightHeap.poll());
    }
    
    public double findMedian() {
        if(leftHeap.size()==rightHeap.size())
           return (leftHeap.peek()+rightHeap.peek())/2.0;
           return leftHeap.size()>rightHeap.size()?leftHeap.peek():rightHeap.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */