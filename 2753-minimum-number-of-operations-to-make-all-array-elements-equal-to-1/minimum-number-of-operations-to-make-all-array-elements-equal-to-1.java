class Solution {
    int gcd(int a,int b){
        int r=a%b;
        while(r>0){
            a=b;
            b=r;
            r=a%b;
        }
        return b;
    }
    public int minOperations(int[] nums) {
        int minLength=Integer.MAX_VALUE;
        int numOnes=0;
        for(int a:nums){
            if(a==1){
                numOnes++;
            }
        }
        for(int i=0;i<nums.length-1;i++){
            int gcd=nums[i];
            if(gcd==1){
                minLength=Math.min(minLength,nums.length-numOnes);
            }
            for(int j=i+1;j<nums.length;j++){
                gcd=gcd(gcd,nums[j]);
                if(gcd==1){
                    int length=j-i;
                    minLength=Math.min(length+nums.length-1-numOnes,minLength);
                }
            }
        }
        if(minLength==Integer.MAX_VALUE){
            return -1;
        }
        return minLength;
    }
}