class Solution {
    int countNums(int currentPrefix,int n){
        int count=0;
        long first=currentPrefix,last=first+1;
        while(first<=n){
            count+=(Math.min(last,n+1)-first);
            first*=10;
            last*=10;
        }
        return count;
    }
    public int findKthNumber(int n, int k) {
        k--;
        int currentPrefix=1;
        while(k>0){
            int count=countNums(currentPrefix,n);
            if(k>=count){
                k-=count;
                currentPrefix++;
            }
            else{
                currentPrefix*=10;
                k--;
            }
        }
        return currentPrefix;
    }
}