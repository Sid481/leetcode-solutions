class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer>mapId = new HashMap<>();
        Map<String,String>mapName = new HashMap<>();
        int num = 0;
        for(List<String>account : accounts) {
            String name = account.get(0);
            for(int j=1; j<account.size(); j++) {
                String email = account.get(j);
                if(!mapId.containsKey(email)) {
                    mapId.put(email,num++);
                }
                
                mapName.put(email,name);
            }
        }
    int[] parent = new int[num];
    int[] rank = new int[num];
    for(int i=0; i<num; i++) {
        parent[i] = i;
        rank[i] = 1;
    }
    for(List<String>account:accounts) {
        int firstEmailId = mapId.get(account.get(1));
        for(int j=2; j<account.size(); j++) {
            int nextEmailId = mapId.get(account.get(j));
            union(firstEmailId,nextEmailId,parent,rank);
        }
    }
    Map<Integer,List<String>>groups = new HashMap<>();

    for(String email : mapId.keySet()) {
        int root = find(mapId.get(email),parent);
        groups.computeIfAbsent(root,k->new ArrayList<>()).add(email);
    }
    List<List<String>>result = new ArrayList<>();
    for(List<String> emails: groups.values()) {
        Collections.sort(emails);
        String name = mapName.get(emails.get(0));
        List<String>account = new ArrayList<>();
        account.add(name);
        account.addAll(emails);
        result.add(account);
    }
    return result;

}
    private int find(int x,int[]parent) {
        if(parent[x]!=x) {
            parent[x] = find(parent[x],parent);
        }
        return parent[x];
    }
    private void union(int x, int y,int[] parent, int[] rank) {
        int parentX = find(x,parent);
        int parentY = find(y,parent);
        if(parentX==parentY) return;
        if(rank[parentX]>rank[parentY]) {
            parent[parentY] = parentX;
        }else if(rank[parentY]>rank[parentX]) {
            parent[parentX] = parentY;
        } else {
            parent[parentY] = parentX;
            rank[parentX]++;
        }
    }
}
