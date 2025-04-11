class Solution {
    int sum(String s,int start,int end){
        int si=0;
        for(int i=start;i<end;i++){
            si+=Integer.valueOf(s.charAt(i));
        }
        return si;
    }
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++){
            String s=new String(String.valueOf(i));
            int left=sum(s,0,s.length()/2);
            int right=sum(s,s.length()/2,s.length());
            count=(left==right)?count+1:count;
        }
        return count;
    }
}