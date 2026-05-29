class Solution {
    int sum(int a){
        int s=0;
        while(a>0){
            s+=a%10;
            a=a/10;
        }
        return s;
    }
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int a:nums){
            min=Math.min(sum(a),min);
        }
        return min;
    }
}