class Solution {
    Map<Integer,List<Integer>> nums;
    Random rand;
    public Solution(int[] nums) {
        this.nums=new HashMap<>();
        rand=new Random();
        for(int i=0;i<nums.length;i++){
            if(!this.nums.containsKey(nums[i])){
                this.nums.put(nums[i],new ArrayList<>());
            }
            this.nums.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> res=nums.get(target);
        int index=rand.nextInt(res.size());

        return res.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */