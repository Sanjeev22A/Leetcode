class Solution {
    public int[] plusOne(int[] digits) {
        int i=0;
        int carry=0;
        for(i=digits.length-1;i>=0;i--){
            if(digits[i]+1!=10){
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
        }
        int[] newDigits=new int[digits.length+1];
        newDigits[0]=1;
        for(i=0;i<digits.length;i++){
            newDigits[i+1]=digits[i];
        }
        return newDigits;
    }
}