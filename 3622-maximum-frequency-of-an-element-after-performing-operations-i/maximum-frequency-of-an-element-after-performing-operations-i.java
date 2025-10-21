class Solution {
    int Max=(int)Math.pow(10,5)+2;
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int[] freqMap=new int[Max];
        int[] sweepMap=new int[Max];
        int[] numOps=new int[Max];
        int ans=0;
        for(int a:nums){
            freqMap[a]++;
            int lower=Math.max(0,a-k);
            int upper=Math.min(Max-1,a+k+1);
            numOps[lower]+=1;
            
            sweepMap[lower]++;
            sweepMap[upper]--;
            numOps[upper]-=1;
        }
        for(int i=1;i<Max;i++){
            sweepMap[i]+=sweepMap[i-1];
            numOps[i]+=numOps[i-1];
        }
        for(int i=0;i<Max;i++){
            //System.out.println(i+":"+sweepMap[i]+":"+numOps[i]);
            
            if(numOps[i]-freqMap[i]>numOperations){
                ans=Math.max(sweepMap[i]-(numOps[i]-freqMap[i]-numOperations),ans);
            }else{
                ans=Math.max(sweepMap[i],ans);
            }   
        }
        return ans;
    }
}