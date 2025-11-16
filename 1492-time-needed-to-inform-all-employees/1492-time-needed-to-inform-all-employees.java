
class Solution {
    int maxTime = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    List<List<Integer>> subOrdinates = new ArrayList<>();
       for(int i=0; i<n; i++) {
            subOrdinates.add(new ArrayList<>());
       }
       for(int i=0; i<n; i++) {
        if(manager[i]!= -1)
        subOrdinates.get(manager[i]).add(i);
       }
    dfs(headID,0,subOrdinates,informTime);
    return maxTime;
    }
    public void dfs(int currentId, int currentTime, List<List<Integer>>subOrdinates,int[] informTime) {
            maxTime = Math.max(currentTime,maxTime);
            
            for(int sub : subOrdinates.get(currentId)) {
                dfs(sub,currentTime+informTime[currentId],subOrdinates,informTime);
            }
    }
}

