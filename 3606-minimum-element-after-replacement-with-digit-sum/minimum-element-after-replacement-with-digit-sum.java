class Solution {
    int sumOfDigits(int num){
        int a=0;
        while(num>0){
            a+=num%10;
            num/=10;
        }
        return a;
    }
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int a:nums){
            min=Math.min(sumOfDigits(a),min);
        }
        return min;
    }
}