class Solution {
    public String nearestPalindromic(String n) {
        long[] candidates=new long[5];
        int length=n.length();
        long number=Long.parseLong(n);
        if(number<=10){
            return String.valueOf(number-1);
        }
        if(number==11){
            return "9";
        }
        long leftHalf=Long.parseLong(n.substring(0,(length+1)/2));
        
        boolean isEvenLength=(length%2==0);
        candidates[0]=generatePalindrome(leftHalf,isEvenLength);
        candidates[1]=generatePalindrome(leftHalf-1,isEvenLength);
        candidates[2]=generatePalindrome(leftHalf+1,isEvenLength);
        candidates[3]=(long)Math.pow(10,length-1)-1;
        candidates[4]=(long)Math.pow(10,length)+1;
        long difference=Long.MAX_VALUE;
        long prev=Long.MAX_VALUE;
        for(long candidate:candidates){
           
            if ((candidate != number) && (((Math.abs(number - candidate) ==difference) && candidate < prev) || (Math.abs(number - candidate) < difference)))
{
                difference=Math.abs(number-candidate);
                prev=candidate;
            }
        }
        return String.valueOf(prev);
    }

    long generatePalindrome(long leftHalf,boolean isEvenLength){
        long palindrome=leftHalf;
        if(!isEvenLength){
            leftHalf/=10;
        }
        while(leftHalf>0){
            palindrome=palindrome*10+leftHalf%10;
            leftHalf/=10;
        }
        return palindrome;
    }
}