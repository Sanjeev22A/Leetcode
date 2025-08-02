class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length==1){
            return 1;
        }
        int maxLen=0;
        int curLen=0;
        for(int i=0;i<arr.length-1;i++){

            if(arr[i]>arr[i+1]){
                if(i==0){
                    curLen=2;
                    maxLen=Math.max(curLen,maxLen);
                }else if(arr[i-1]<arr[i]){
                    curLen++;
                    maxLen=Math.max(curLen,maxLen);

                }else{
                    
                    curLen=2;
                    maxLen=Math.max(curLen,maxLen);
                }
            }else if(arr[i]<arr[i+1]){
                if(i==0){
                    curLen=2;
                    maxLen=Math.max(curLen,maxLen);
                }else if(arr[i-1]>arr[i]){
                    curLen++;
                    maxLen=Math.max(curLen,maxLen);

                }else{

                    curLen=2;
                    maxLen=Math.max(curLen,maxLen);
                }
            }else{
                curLen=1;
                maxLen=Math.max(curLen,maxLen);
            }
        }
        return maxLen;
    }
}