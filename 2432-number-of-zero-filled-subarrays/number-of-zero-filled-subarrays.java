class Solution {
   
    public long zeroFilledSubarray(int[] nums) {
        
        int prev=-1,count=0;
        long ans=0;
        for(int a:nums){
            if(prev==a){
                count++;
                if(a==0){
                    
                    ans+=count;
                }
            }else{
                count=1;

                prev=a;
                if(a==0){
                 
                    ans++;
                }
            }
        }
        
        
        return ans;
    }
}