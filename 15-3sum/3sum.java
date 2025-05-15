class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        
        for(int i=0;i<=nums.length-3;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1,k=nums.length-1,sum=0;
          
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    while(j+1!=nums.length && nums[j]==nums[j+1]){
                        j++;
                    }
                    j++;
                    while(k!=0 && nums[k]==nums[k-1]){
                        k--;
                    }
                    k--;
                }else if(nums[i]+nums[j]+nums[k]<0){
                    while(j+1!=nums.length && nums[j]==nums[j+1]){
                        j++;
                    }
                    j++;
                }else{
                    while(k!=0 && nums[k]==nums[k-1]){
                        k--;
                    }
                    k--;
                }
            }
        }
        return res;
    }
}