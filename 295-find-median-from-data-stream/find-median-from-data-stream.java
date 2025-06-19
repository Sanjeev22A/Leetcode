class MedianFinder {
    PriorityQueue<Integer> heap1;
    PriorityQueue<Integer> heap2;
    public MedianFinder() {
        heap1=new PriorityQueue<>((a,b)->(a-b));//This is the adding queue
        heap2=new PriorityQueue<>((a,b)->(b-a)); //This is the movement queue
    }
    
    public void addNum(int num) {
        int n1=heap1.size();
        int n2=heap2.size();
        if(n2==n1){
            heap1.add(num);
            
            if(heap2.size()>0 && heap1.peek()<heap2.peek()){
                int temp=heap1.poll();
                int temp2=heap2.poll();
                heap1.add(temp2);
                heap2.add(temp);
            }
        }else{
            heap1.add(num);
            heap2.add(heap1.poll());
        
        }
        //System.out.println(heap1.toString());
        //System.out.println(heap2.toString());
    }
    
    public double findMedian() {
        int n1=heap1.size();
        int n2=heap2.size();
        if(n1==n2){
            double a=(double)heap1.peek();
            double b=(double)heap2.peek();
            return (a+b)/2;
        }
        return (double)heap1.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */