class Solution {
    long numSubArrays(int a){
        long b=(long)a*(long)(a+1);
        return b/2;
    }
    public long zeroFilledSubarray(int[] nums) {
        //List<Integer> arr=new ArrayList<>();
        int prev=-1,count=0;
        long ans=0;
        for(int a:nums){
            if(prev==a){
                count++;
                if(a==0){
                    //System.out.println(count);
                    ans+=count;
                }
            }else{
                count=1;

                prev=a;
                if(a==0){
                    //System.out.println(1);
                    ans++;
                }
            }
        }
        
        
        return ans;
    }
}