class DataStream {
    int prev=0,count=0;
    int k,value;
    public DataStream(int value, int k) {
        this.k=k;
        this.value=value;
    }
    
    public boolean consec(int num) {
        if(num==prev){
            count++;
            
        }else{
            prev=num;
            count=1;
        }
        if(prev==value && count>=k){
            return true;
        }
        return false;

    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */