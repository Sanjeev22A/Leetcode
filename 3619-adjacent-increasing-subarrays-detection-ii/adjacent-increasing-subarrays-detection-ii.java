class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int longestIncreasing=1;
        int currentIncreasing=1;
        
        for(int i=1;i<nums.size();i++){
            
            if(nums.get(i)>nums.get(i-1)){
                currentIncreasing++;
            }else{
                currentIncreasing=1;
            }
            longestIncreasing=Math.max(currentIncreasing,longestIncreasing);
        }
        boolean change=false;
        int prev=0,cur=0;
        int max=0;
        
        for(int i=0;i<nums.size();i++){
            //System.out.println(prev+":"+cur);
            if(i==0){
                prev++;
            }else{
                if(nums.get(i)>nums.get(i-1)){
                    if(!change){
                        prev++;
                    }else{
                        cur++;
                    }
                }else{
                    if(!change){
                        change=true;
                        cur++;
                    }else{
                        max=Math.max(max,Math.min(prev,cur));
                        prev=cur;
                        cur=1;
                    }
                }
            }
            
        }
        max=Math.max(max,Math.min(prev,cur));
        return Math.max(max,longestIncreasing/2);
    }   
}