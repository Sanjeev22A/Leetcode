class Solution {
    int mod=(int)Math.pow(10,9)+7;
    public int countHomogenous(String s) {
        int count=0;
        int continiousCount=1;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                continiousCount++;
            }else{
                long groupSum = (long)continiousCount * (continiousCount + 1) / 2;
                count = (int)((count + groupSum) % mod);
                continiousCount = 1;
            }
        }
        long groupSum = (long)continiousCount * (continiousCount + 1) / 2;
        count = (int)((count + groupSum) % mod);
        return count;
    }
}