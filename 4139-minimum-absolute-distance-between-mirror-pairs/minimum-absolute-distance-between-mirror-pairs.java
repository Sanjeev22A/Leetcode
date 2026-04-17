class Solution {
    int reverse(int x){
        int res=0;
        while(x>0){
            int rem=x%10;
            res=res*10+rem;
            x/=10;
        }
        return res;
    }
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer,Integer> lookUp=new HashMap<>();
        int dist=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int rev=reverse(nums[i]);
            if(lookUp.containsKey(num)){
                int idx=lookUp.get(num);
                dist=Math.min(i-idx,dist);
            }
            lookUp.put(rev,i);
        }
        if(dist==Integer.MAX_VALUE){
            return -1;
        }
        return dist;
    }
}