class Solution {
    long numSubArrays(int a){
        long b=(long)a*(long)(a+1);
        return b/2;
    }
    public long zeroFilledSubarray(int[] nums) {
        List<Integer> arr=new ArrayList<>();
        int prev=-1,count=0;
        for(int a:nums){
            if(prev==a){
                count++;
            }else{
                if(prev==0){
                    arr.add(count);
                }
                count=1;
                prev=a;
            }
        }
        if(prev==0){
            arr.add(count);
        }
        long ans=0;
        for(int a:arr){
            ans+=numSubArrays(a);
            
        }
        return ans;
    }
}