class Solution {
    public int countElements(int[] nums) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int a:nums){
            min=Math.min(a,min);
            max=Math.max(a,max);
        }
        int c=0;
        for(int a:nums){
            if(a>min & a<max){
                c++;
            }
        }
        return c;
    }
}