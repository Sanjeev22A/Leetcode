class Solution {
    public boolean check(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                boolean flag=true;
                int j=i+1;
                int k=0;
                while(k<nums.length-1){
                    if(nums[j%nums.length]<=nums[(j+1)%nums.length]){
                        j++;
                        k++;
                        continue;
                    }
                    else{
                        return false;
                    }
                    
                }

            }
        }
        return true;
        
    }
}