class LUPrefix {
    FenwickTree ft;
    public LUPrefix(int n) {
        ft=new FenwickTree(n);
    }
    
    public void upload(int video) {
        ft.update(video);
    }
    
    public int longest() {
        return ft.search();
    }
}

class FenwickTree{
    int n;
    int[] prefixSum;
    
    FenwickTree(int n){
        this.n=n;
        prefixSum=new int[n+1];
    }

    int twoComp(int a){
        return -a;
    }
    int next(int a){
        return a+(a&twoComp(a));
    }
    int prev(int a){
        return a-(a&twoComp(a));

    }
    
    void update(int limit){
        if(limit>n){
            return;
        }
        prefixSum[limit]++;
        update(next(limit));
    }
    

    
    int sum(int limit){
        if(limit<=0){
            return 0;
        }
        return prefixSum[limit]+sum(prev(limit));
    }

    int search(){
        int start=1;
        int end=n;
        int limit=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            int sum=sum(mid);
            
            if(sum==mid){
                limit=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
       
        return limit;
    }

}
/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */