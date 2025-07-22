class Solution {
    String s1,s2,s3;
    Map<String,Boolean> dp;
    boolean interleave(int i,int j,int k){
        String key=i+":"+j+":"+k;
        if(k==s3.length() && i==s1.length() && j==s2.length()){
            return true;
        }else if(k==s3.length()){
            return false;
        }
        if(i>=s1.length() && j>=s2.length()){
            return false;
        }
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        boolean flag=false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
            flag=flag|interleave(i+1,j,k+1);
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
            flag=flag|interleave(i,j+1,k+1);
        }
       
        dp.put(key,flag);
        return flag;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        dp=new HashMap<>();
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        return interleave(0,0,0);
    }
}