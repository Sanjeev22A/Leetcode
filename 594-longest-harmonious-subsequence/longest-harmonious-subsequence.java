class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> leftMap=new HashMap<>();
        Map<Integer,Integer> rightMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(leftMap.containsKey(nums[i])){
                continue;
            }
            leftMap.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            rightMap.put(nums[i],i);
        }
        int maxLength=0;
        for(int a:nums){
            int left=leftMap.get(a);
            int right=rightMap.getOrDefault(a+1,left-1);
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}