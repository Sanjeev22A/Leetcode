class Solution {
    public int totalHammingDistance(int[] nums) {
        int sum=0;
        for(int i=0;i<32;i++){
            int bit1=0;
            for(int num:nums){
                bit1+=(num>>i)&1;
            }
            System.out.println(bit1);
            sum+=bit1*(nums.length-bit1);
        }
        return sum;
    }
}