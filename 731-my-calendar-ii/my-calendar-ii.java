class MyCalendarTwo {
    class Pair{
        int start,end;
        Pair(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    List<Pair> bookings;
    List<Pair> overlapped;
    public MyCalendarTwo() {
        bookings=new ArrayList<>();
        overlapped=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        Pair dummy=new Pair(start,end);
        if(isOverLapped(dummy)){
            return false;
        }
        else{
            addToOverlap(dummy);
            bookings.add(dummy);
            return true;
        }
    }
    boolean helper(Pair p, Pair q) {
    return p.start < q.end && p.end > q.start;
    }

    boolean isOverLapped(Pair p){
        for(int i=0;i<overlapped.size();i++){
            if(helper(p,overlapped.get(i))){
                return true;
            }
        }
        return false;
    }

    void addToOverlap(Pair p){
        for(int i=0;i<bookings.size();i++){
            if(helper(p,bookings.get(i))){
                Pair q=bookings.get(i);
                Pair dummy=new Pair(Math.max(p.start,q.start),Math.min(p.end,q.end));
                overlapped.add(dummy);
            }
        }
    }

}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */