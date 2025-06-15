class Solution {
    public int maxOperations(String s) {
        int count=0;
        int continiousOne=0;
        int prevOneIndex=0;
        for(int i=0;i<s.length();i++){
            if(i>0 && s.charAt(i-1)=='0' && s.charAt(i)=='1'){
                if(continiousOne>0){
                    count+=continiousOne;
                    
                }
                
                prevOneIndex=i-continiousOne;
                continiousOne++;
                
            }
            else if(s.charAt(i)=='1'){
                continiousOne++;
            }
        }
        if(s.charAt(s.length()-1)=='0'){
            count+=continiousOne;
        }
        return count;
    }
}