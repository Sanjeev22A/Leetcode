class RecentCounter {
    Queue<Integer> calls;
    int count;
    public RecentCounter() {
        calls=new LinkedList<>();
        count=0;
    }
    
    public int ping(int t) {
        int start=t-3000;
        while(!calls.isEmpty() && calls.peek()<start){
            calls.poll();
        }
        calls.offer(t);
        return calls.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */