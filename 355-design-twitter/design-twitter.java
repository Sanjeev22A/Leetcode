class Twitter {
    private static int timestamp = 0;

    private class Tweet {
        int tweetId, time;
        Tweet next;
        Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.time = timestamp++;
        }
    }

    Map<Integer, Set<Integer>> followingMap;
    Map<Integer, Tweet> tweetMap;
    
    public Twitter() {
        followingMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId);
        newTweet.next = tweetMap.get(userId);
        tweetMap.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        if (tweetMap.containsKey(userId)) {
            pq.offer(tweetMap.get(userId));
        }

        Set<Integer> followees = followingMap.getOrDefault(userId, new HashSet<>());
        for (int followeeId : followees) {
            if (tweetMap.containsKey(followeeId)) {
                pq.offer(tweetMap.get(followeeId));
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty() && result.size() < 10) {
            Tweet t = pq.poll();
            result.add(t.tweetId);
            if (t.next != null) pq.offer(t.next);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followingMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followingMap.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
