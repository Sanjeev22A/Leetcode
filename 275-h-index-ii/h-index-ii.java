class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int start=0,end=n-1;
        int pos=n;
        while(start<=end){
            int mid=start+(end-start)/2;
            System.out.println(mid+":"+(n-mid+1)+":"+citations[mid]);
            if(citations[mid]>=(n-mid)){
                pos=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return n-pos;
    }
}