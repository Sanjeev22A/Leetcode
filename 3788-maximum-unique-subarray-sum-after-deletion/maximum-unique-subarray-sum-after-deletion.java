class Solution {
    public int maxSum(int[] nums) {
        Map<Integer,Integer> count=new HashMap<>();
        int sum=0;
        int maxNegative=Integer.MIN_VALUE;
        boolean positiveSeen=false;
        for(int a:nums){
            if(a>=0 && !count.containsKey(a)){
                sum+=a;
                positiveSeen=true;
            }
            if(a<0){
                maxNegative=Math.max(maxNegative,a);
            }
            count.put(a,count.getOrDefault(a,0)+1);
        }

        return positiveSeen?sum:maxNegative;
    }
}