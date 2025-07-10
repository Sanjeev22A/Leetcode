class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int totalSum=0;
        for(int left=0;left<arr.length;left++){
            int cursum=0;
            for(int right=left;right<arr.length;right++){
                cursum+=arr[right];
                int curLen=(right-left+1);
                if(curLen%2==1){
                    totalSum+=cursum;
                }
            }
        }
        return totalSum;
    }
}