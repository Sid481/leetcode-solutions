class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        if(dead.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int steps = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String current = queue.poll();
                if(current.equals(target)) return steps;
            
                for(int j=0; j<4; j++) {
                    String up = rotateUp(current,j);
                    String down = rotateDown(current,j);
                    if(!dead.contains(up)&&!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    if(!dead.contains(down)&&!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                } 
            }
            steps++;    
        }
           return -1; 
    }
        public String rotateUp(String current, int i) {
            char[] arr = current.toCharArray();
            arr[i]= arr[i]=='9'?'0':(char)(arr[i]+1);
            return new String(arr);
        }
        public String rotateDown(String current, int i) {
            char[] arr = current.toCharArray();
            arr[i] = arr[i]=='0'?'9':(char)(arr[i]-1);
            return new String(arr);
        }
}
