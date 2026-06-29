class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int start=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>start+1){
                arr[i]=start+1;
            }
            start=arr[i];
        }
        return start;
        
    }
}