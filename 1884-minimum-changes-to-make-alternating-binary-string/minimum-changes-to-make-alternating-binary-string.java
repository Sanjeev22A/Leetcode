class Solution {
    String[] generateVariants(int length){
        String s1="",s2="";
        char zero='0',one='1';
        for(int i=0;i<length;i++){
            if(i%2==0){
                s1+=zero;
            }else{
                s1+=one;
            }
        }
        for(int i=0;i<length;i++){
            if(i%2==0){
                s2+=one;
            }else{
                s2+=zero;
            }
        }
        String[] temp=new String[]{s1,s2};
        return temp;
    }
    public int minOperations(String s) {
        int length=s.length();
        int minDiff=Integer.MAX_VALUE;
        String[] temp=generateVariants(length);
        for(String a:temp){
            int count=0;
            for(int i=0;i<length;i++){
                if(a.charAt(i)!=s.charAt(i)){
                    count++;
                }
            }
            minDiff=Math.min(count,minDiff);
        }
        return minDiff;
    }
}