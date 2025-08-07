class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long prefixSum=0;
        long minPrefix=Integer.MAX_VALUE;
        long maxPrefix=Integer.MIN_VALUE;
        for(int a:differences){
            prefixSum+=(long)a;
            minPrefix=Math.min(prefixSum,minPrefix);
            maxPrefix=Math.max(prefixSum,maxPrefix);
        }
        long limit1=Math.max(lower,lower-minPrefix);
        long limit2=Math.min(upper,upper-maxPrefix);
        //System.out.println(limit1+":"+limit2);
        return (int)Math.max(0,limit2-limit1+1);
        //System.out.println(lower+":"+minPrefix+":"+maxPrefix+":"+upper);
        //return 0;
        
    }
}