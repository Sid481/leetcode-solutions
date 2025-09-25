class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int row=0; row<n; row++) {
            minHeap.add(new int[]{matrix[row][0],row,0});
        }
        int result = -1;
        while(k-->0) {
            int[] arr = minHeap.poll();
            result = arr[0];
            int row = arr[1];
            int col = arr[2];
            if(col+1<n) {
                minHeap.add(new int[]{matrix[row][col+1],row,col+1});
            }
        }
        return result;
    }
}
