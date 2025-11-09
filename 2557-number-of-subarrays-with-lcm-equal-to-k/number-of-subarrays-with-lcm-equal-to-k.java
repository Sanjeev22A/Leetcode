class Solution {
    int MAX=(int)Math.pow(10,9)+7;
    long hcf(long a,long b){
        if(a==b){
            return a;
        }
        long r=a%b;
        while(r>0){
            a=b;
            b=r;
            r=a%b;
        }
        return b;
    }
    long LCM(long a,long b){

        return a*b/hcf(a,b);
    }
    public int subarrayLCM(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            long lcm=(long)nums[i];
            if(lcm==k){
                count++;
            }
            for(int j=i+1;j<nums.length;j++){
                lcm=LCM(lcm,(long)nums[j]);
                lcm=lcm%MAX;
                //System.out.println(lcm+":"+i+":"+j);
                if(lcm==(long)k){
                    count++;
                }
            }
        }
        return count;
    }
}