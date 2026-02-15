class Solution {
    Set<String> visited = new HashSet<>();
    StringBuilder result = new StringBuilder();
    public String crackSafe(int n, int k) {
      String start = "0".repeat(n-1);
      dfs(start,k);
      result.append(start);
      return result.toString();
    }
    public void dfs(String node, int k) {
        for(int i=0; i<k; i++) {
            String edge = node+i;
            if(!visited.contains(edge)) {
                visited.add(edge);
                dfs(edge.substring(1),k);
                result.append(i);
            }
        }
    }
}