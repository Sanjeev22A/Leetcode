class CustomStack {
    List<Integer> stack;
    int top;
    private final int maxSize;
    public CustomStack(int maxSize) {
        stack=new ArrayList<>();
        top=-1;
        this.maxSize=maxSize;
    }
    
    public void push(int x) {
        if(top==maxSize-1){
            return;
        }
        else{
            stack.add(x);
            top++;
        }
    }
    
    public int pop() {
        if(top==-1){
            return -1;
        }
        else{
            int val=stack.get(top);
            stack.remove(top);
            top--;
            return val;
        }
    }
    
    public void increment(int k, int val) {
        int limit=Math.min(top+1,k);
        for(int i=0;i<limit;i++){
            int cur=stack.get(i)+val;
            stack.set(i,cur);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */