class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();

        int ans=0;
        int i=0;
        for(int j=0;j<nums.length;j++){
            int c=nums[j];
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.get(c)>k){
                int left=nums[i];
                map.put(left,map.getOrDefault(left,0)-1);
                i++;
            }
            int curLength=j-i+1;
            ans=Math.max(ans,curLength);
        }
        return ans;
    }
}