class Solution {
    public long minimalKSum(int[] nums, int k) {
        long ans=0L;
        int[] numsTemp;
        Arrays.sort(nums);
        if(nums[0]==1){
            numsTemp=nums;
        }else{
            numsTemp=new int[nums.length+1];
            numsTemp[0]=1;
            ans++;
            k--;
            for(int i=0;i<nums.length;i++){
                numsTemp[i+1]=nums[i];
            }
        }
        Arrays.sort(numsTemp);
        int last=1;
        for(int i=1;i<numsTemp.length;i++){
            
            int cur=numsTemp[i];
            last=cur;
            int prev=numsTemp[i-1];
            int dif=cur-prev-1;
            if(dif>0){
                cur=Math.min(prev+k+1,cur);
                long sum=(long)(cur)*(cur-1)/2-(long)(prev)*(prev+1)/2;
                ans+=sum;
                k-=dif;
            }
            if(k<=0){
                break;
            }
        }
        if(k>0){
            int end=last+k+1;
            long sum=(long)(end)*(end-1)/2-(long)(last)*(last+1)/2;
            //System.out.println(sum);
            //System.out.println(end);
            ans+=sum;
        }
        return ans;
    }
}