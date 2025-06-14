class MyCircularQueue {
    int[] queue;
    int front,end,size,numPresent;
    public MyCircularQueue(int k) {
        queue=new int[k];
        front=0;
        end=-1;
        size=k;
        numPresent=0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        end=end+1;
        queue[end%size]=value;
        numPresent++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front=front+1;
        front%=size;
        numPresent--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        
        return queue[front%size];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return queue[end%size];
    }
    
    public boolean isEmpty() {
        return numPresent==0;
    }
    
    public boolean isFull() {
        return numPresent==size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */