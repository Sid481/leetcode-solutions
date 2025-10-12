class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][]taskWithIndex= new int[n][3]; 
         for(int i=0; i<n; i++) {
            taskWithIndex[i] = new int[]{tasks[i][0],tasks[i][1],i};
        }
        Arrays.sort(taskWithIndex,(a,b)->a[0]==b[0]? Integer.compare(a[2],b[2])
        : Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> heap = new PriorityQueue<>(
        (a,b)->a[1]==b[1]? Integer.compare(a[2],b[2]) :
        Integer.compare(a[1],b[1]));
        int result[] = new int[n];
        int index = 0;
        int currentTime = 0;
    
        int i = 0;
        while(index<n) {
            while(i<n && taskWithIndex[i][0]<=currentTime) {
                heap.offer(taskWithIndex[i]);
                i++;
            }
            if(heap.isEmpty()) {
                currentTime = taskWithIndex[i][0];
                continue;
            }
            int[] task = heap.poll();
            result[index++] = task[2];
            currentTime += task[1];
        }
        return result;
    }
}