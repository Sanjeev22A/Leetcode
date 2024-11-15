class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length;
        int front,end;
        front=0;
        while(front+1<n && arr[front]<=arr[front+1]){
            front++;
        }
        if(front==n-1)return 0;
        end=arr.length-1;
        while(end>0 && arr[end-1]<=arr[end]){
            end--;
        }
        int result=Math.min(n-front-1,end);
        int i = 0, j = end;
        while (i <= front && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}