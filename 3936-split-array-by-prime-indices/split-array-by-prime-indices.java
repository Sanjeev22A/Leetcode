class Solution {
    public long splitArray(int[] nums) {
        boolean[] primes=new boolean[nums.length+1];
        if(nums.length<=2){
            long val=0L;
            for(int a:nums){
                val+=(long)a;
                
            }
            return Math.abs(val);
        }
        Arrays.fill(primes,true);
        primes[0]=false;
        primes[1]=false;
        
        primes[2]=true;
        for(int i=2;i<=Math.pow(nums.length,0.5);i++){
            if(primes[i]){
                for(int j=i*i;j<=nums.length;j+=i){
                    primes[j]=false;
                }
            }
        }
        long nonPrimeSum=0L;
        long primeSum=0L;
        for(int i=0;i<nums.length;i++){
            if(primes[i]){
                primeSum+=(long)nums[i];
            }else{
                nonPrimeSum+=(long)nums[i];
            }
        }
        return Math.abs(primeSum-nonPrimeSum);
    }
}