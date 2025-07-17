class Solution {
    public int findLongestChain(int[][] pairs) {
        int count=0;
        Arrays.sort(pairs,(a,b)->(a[1]-b[1]));
        int cur=Integer.MIN_VALUE;
        for(int[] a:pairs){
            if(cur<a[0]){
                cur=a[1];
                count++;
            }
        }
        return count;
    }
}