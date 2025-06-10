class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        int convertTo1=0,convertToneg1=0;
        boolean flag1=false,flag2=false;
        int n=nums.length;
        int[] dummy=new int[n];
        for(int i=0;i<n;i++){
            dummy[i]=nums[i];
        }
        for(int i=0;i<n-1;i++){
            if(dummy[i]==-1){
                dummy[i]=1;
                dummy[i+1]*=-1;
                convertTo1++;
            }
        }
        if(dummy[n-1]==1){
            flag1=true;
        }
        for(int i=0;i<n;i++){
            dummy[i]=nums[i];
        }
        for(int i=0;i<n-1;i++){
            if(dummy[i]==1){
                dummy[i]=-1;
                dummy[i+1]*=-1;
                convertToneg1++;
            }
        }
        if(dummy[n-1]==-1){
            flag2=true;
        }
        int a=Math.min(convertTo1,convertToneg1);
        if(a>k){
            return false;
        }
        if(convertTo1<=k && convertToneg1<=k){
            return flag1||flag2;
        }
        if(convertTo1<=k){
            return flag1;
        }
        if(convertToneg1<=k){
            return flag2;
        }
        
        return false;
        
    }
}