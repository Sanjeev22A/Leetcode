class Solution {
    public int largestInteger(int[] nums, int k) {
        if(k==1){
            int[] count=new int[51];
            for(int a:nums){
                count[a]++;
            }
            int max=-1;
            for(int i=0;i<count.length;i++){
                if(count[i]==1){
                    max=Math.max(i,max);
                }
            }
            return max;
            
        }
        if(k==nums.length){
            int max=0;
            for(int a:nums){
                max=Math.max(a,max);
            }
            return max;
        }
        int first=nums[0];
        int last=nums[nums.length-1];
        int firstCount=0,lastCount=0;
        for(int a:nums){
            if(a==first){
                firstCount++;
            }
            if(a==last){
                lastCount++;
            }
        }
        if(firstCount>1 && lastCount>1){
            return -1;
        }else if(firstCount>1){
            return last;
        }else if(lastCount>1){
            return first;
        }else{
            return Math.max(first,last);
        }
    }
}