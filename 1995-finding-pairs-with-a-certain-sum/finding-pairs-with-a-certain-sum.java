class FindSumPairs {
    Map<Integer,Integer> map2;
    int[] nums1,nums2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        
        this.map2=new HashMap<>();
        for(int a:nums2){
            map2.put(a,map2.getOrDefault(a,0)+1);
        }
        this.nums1=nums1;
        this.nums2=nums2;
    }
    
    public void add(int index, int val) {
        int curVal=this.nums2[index];
        nums2[index]+=val;
        map2.put(curVal,map2.get(curVal)-1);
        if(map2.get(curVal)==0){
            map2.remove(curVal);
        }
        map2.put(nums2[index],map2.getOrDefault(nums2[index],0)+1);
    }
    
    public int count(int tot) {
        int ans=0;
        for(int a:nums1){
            int cur=tot-a;
            ans+=map2.getOrDefault(cur,0);
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */