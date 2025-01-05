class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] tracker=new int[s.length()];
        for(int[] a:shifts){
            if(a[2]==1){
                tracker[a[0]]++;
                if(a[1]+1<s.length()){
                    tracker[a[1]+1]--;
                }
            }
            else{
                tracker[a[0]]--;
                if(a[1]+1<s.length()){
                    tracker[a[1]+1]++;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int i=0;
        int numberOfShifts=0;
        for(char c:s.toCharArray()){
            numberOfShifts=(numberOfShifts+tracker[i])%26;
            if(numberOfShifts<26){
                numberOfShifts+=26;
            }
            char b=(char)(((c-'a')+numberOfShifts)%26+'a');
            sb.append(b);
            i++;
        }
        return sb.toString();

        
    }
}