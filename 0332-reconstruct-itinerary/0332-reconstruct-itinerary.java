class Solution {
    private Map<String,PriorityQueue<String>> graph = new HashMap<>();
    private List<String> result = new ArrayList<String>();

    public List<String> findItinerary(List<List<String>> tickets) {
       for(List<String> ticket : tickets) {
        String from = ticket.get(0);
        String to = ticket.get(1);
        graph.computeIfAbsent(from,k->new PriorityQueue<>()).offer(to);
       }
    dfs("JFK");
    Collections.reverse(result);
    return result;
    }

    public void dfs(String airport) {
        PriorityQueue<String> destinations = graph.get(airport);
        while(destinations!=null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next);
        }
        result.add(airport);
    }
}