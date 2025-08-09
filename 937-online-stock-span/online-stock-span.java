class Point{
    int val;
    int prevIndex;
    Point(int val,int prevIndex){
        this.val=val;
        this.prevIndex=prevIndex;
    }
}
class StockSpanner {
    Stack<Point> st;
    int counter;
    public StockSpanner() {
        st=new Stack<>();
        counter=0;
    }
    
    public int next(int price) {
        while(!st.isEmpty() && st.peek().val<=price){
            st.pop();
        }
        counter++;
        int returnVal=0;
        if(st.isEmpty()){
            returnVal=counter;
            st.push(new Point(price,counter));
            return returnVal;
        }else{
            int prevIndex=st.peek().prevIndex;
            returnVal=counter-prevIndex;
            st.push(new Point(price,counter));
            return returnVal;
        }

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */