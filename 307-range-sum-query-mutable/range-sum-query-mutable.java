class FenwickTree{
    int[] prefixArr;
    int[] nums;
    FenwickTree(int[] nums){
        this.nums=nums;
        this.prefixArr=new int[nums.length+1];
        buildTree();
    }
    void buildTree(){
        for(int i=0;i<nums.length;i++){
            updateWrapper(i+1,nums[i]);
        }
    }
    int twoComp(int num){
        return -num;
    }
    int next(int index){
        int val=index&twoComp(index);
        return index+val;
    }
    int parent(int index){
        int comp=twoComp(index);
        int val=comp&index;
        return index-val;
    }
    int endAt(int r){
        if(r<=0){
            return 0;
        }
        return prefixArr[r]+endAt(parent(r));
    }
    int rangeSum(int l,int r){
        return endAt(r+1)-endAt(l);
    }
    
    void update(int index,int val){
        
        updateWrapper(index+1,val-this.nums[index]);
        this.nums[index]=val;
    }
    void updateWrapper(int index,int diff){
        if(index>=this.prefixArr.length){
            return;
        }
        prefixArr[index]+=diff;
        
        updateWrapper(next(index),diff);
    }
}
class NumArray {
    FenwickTree ft;
    public NumArray(int[] nums) {
        ft=new FenwickTree(nums);
        
    }
    
    public void update(int index, int val) {
        ft.update(index,val);
    }
    
    public int sumRange(int left, int right) {
        
        return ft.rangeSum(left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */