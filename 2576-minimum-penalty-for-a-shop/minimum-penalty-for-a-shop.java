class Solution {
    public int bestClosingTime(String customers) {
        int[] countEnd=new int[customers.length()];
        int[] countFront=new int[customers.length()];
        for(int i=0;i<customers.length();i++){
            if(i>0){
                countFront[i]+=countFront[i-1];
            }
            if(customers.charAt(i)=='N'){
                countFront[i]++;
            }
        }
        for(int i=customers.length()-1;i>=0;i--){
            if(i<customers.length()-1){
                countEnd[i]+=countEnd[i+1];
            }
            if(customers.charAt(i)=='Y'){
                countEnd[i]++;
            }
        }
        int minPenalty=Integer.MAX_VALUE;
        int idx=-1;
        for(int i=0;i<customers.length()+1;i++){
            int curFrontPenalty=0;
            if(i>0){
                curFrontPenalty=countFront[i-1];
            }
            int curEndPenalty=0;
            if(i<customers.length()){
                curEndPenalty=countEnd[i];
            }
            if(minPenalty>curFrontPenalty+curEndPenalty){
                minPenalty=curFrontPenalty+curEndPenalty;
                idx=i;
            }
        }
        
        return idx;
    }
}