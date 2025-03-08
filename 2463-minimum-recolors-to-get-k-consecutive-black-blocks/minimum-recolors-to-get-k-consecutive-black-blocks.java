class Solution {
    public int minimumRecolors(String blocks, int k) {
        int blackCount=0;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='B'){blackCount++;}
        }
        int minNeeded=k-blackCount;
        for(int i=k;i<blocks.length();i++){
                if(blocks.charAt(i)=='B' && blocks.charAt(i-k)=='W'){blackCount++;}
                else if(blocks.charAt(i)=='W' && blocks.charAt(i-k)=='B'){blackCount--;}
                minNeeded=Math.min(k-blackCount,minNeeded);
        }
        return minNeeded;
    }
}