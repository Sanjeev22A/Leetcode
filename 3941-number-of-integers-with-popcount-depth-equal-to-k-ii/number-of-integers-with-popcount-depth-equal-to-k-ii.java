class Solution {
    Map<Long,Integer> dp;
    int popDepth(long num){

        if(num==0){
            return 0;
        }
        if(dp.containsKey(num)){
            return dp.get(num);
        }
        if(num==1){
            dp.put(1L,0);
            return 0;
        }
        dp.put(num,1+popDepth(Long.bitCount(num)));
        return dp.get(num);
    }
    public int[] popcountDepth(long[] nums, long[][] queries) {
        dp=new HashMap<>();
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=popDepth(nums[i]);
            
        }
        FenwickTree ft=new FenwickTree(arr);
        List<Integer> ans=new ArrayList<>();
        for(long[] a:queries){
            if(a[0]==1){
                ans.add(ft.find((int)a[1],(int)a[2],(int)a[3]));
            }
            else{
                int v1=ft.nums[(int)a[1]];
                int v2=popDepth(a[2]);
                ft.updateWrapper((int)a[1],v1,v2);
            }
        }
        int[] res=new int[ans.size()];
        for(int i=0;i<res.length;i++){
            res[i]=ans.get(i);
        }
        return res;
        
    }
}

class FenwickTree{
    int[] nums;
    int[][] prefixArr;
    FenwickTree(int[] nums){
        this.nums=nums;
        prefixArr=new int[8][nums.length+1];
        build();
    }
    void build(){
        for(int i=0;i<nums.length;i++){
            update(i+1,nums[i],1);
        }
    }
    int twoComp(int index){
        return -index;
    }
    int parent(int index){
        return index-(index&twoComp(index));
    }
    int next(int index){
        return index+(index&twoComp(index));
    }
    void updateWrapper(int index,int oldK,int newK){
        update(index+1,oldK,-1);
        update(index+1,newK,1);
        nums[index]=newK;
    }
    void update(int index,int k,int val){
        if(index>=prefixArr[0].length){
            return;
        }
        prefixArr[k][index]+=val;
        update(next(index),k,val);
    }
    
    int getEnd(int index,int k){
        if(index<=0){
            return 0;
        }
        return prefixArr[k][index]+getEnd(parent(index),k);
    }
    int find(int l,int r,int k){
        return getEnd(r+1,k)-getEnd(l,k);
    }
}