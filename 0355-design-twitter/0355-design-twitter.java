class Twitter {
    Map<Integer,List<Tweet>> userTweets = new HashMap<>();
    Map<Integer,Set<Integer>> followMap = new HashMap<>();
    static int time = 0;
    int Id;
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
       userTweets.putIfAbsent(userId, new ArrayList<>());
       userTweets.get(userId).add(new Tweet(tweetId,time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a,b)->b.time-a.time);
        if(userTweets.containsKey(userId)) {
            maxHeap.addAll(userTweets.get(userId));
        }
        if(followMap.containsKey(userId)) {
            for(int followee : followMap.get(userId)) {
                List<Tweet> list = userTweets.get(followee);
                if(list!=null) {
                    maxHeap.addAll(list);
                }
            }
        }

        List<Integer>resultList = new ArrayList<Integer>();
        int count = 0;
        while(!maxHeap.isEmpty() && count<10) {
            resultList.add(maxHeap.poll().Id);
            count++;
        }
        return resultList;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId,new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
      if(followMap.containsKey(followerId)) {
      followMap.get(followerId).remove(followeeId);
        }
    }

    public class Tweet {
        int time;
        int Id;
        public Tweet(int Id, int time) {
            this.time = time;
            this.Id = Id;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */