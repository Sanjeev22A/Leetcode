class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> res=new HashSet<>();
        int i;
        for(i=nums.length-1;i>=0;i--){
            if(res.contains(nums[i])){break;}
            res.add(nums[i]);
        }
        int c=i+1;
        System.out.println(c);
        
        return (int)Math.ceil((double)c/3);
    }
}