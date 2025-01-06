class SmallestInfiniteSet {
    boolean[] tracker;
    int minIndex;
    public SmallestInfiniteSet() {
        tracker=new boolean[1002];
        Arrays.fill(tracker,true);
        minIndex=1;
    }
    
    public int popSmallest() {
        int val=minIndex;
        tracker[minIndex]=false;
        while(!tracker[minIndex++]){
            if(tracker[minIndex]==true){break;}
        }
        
        return val;

    }
    
    public void addBack(int num) {
        minIndex=Math.min(minIndex,num);
        if(minIndex<=1000){
            tracker[num]=true;
        }
    }
}