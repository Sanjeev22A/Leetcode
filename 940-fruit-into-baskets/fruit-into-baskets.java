class Solution {
    public int totalFruit(int[] fruits) {
        int start=0,end=0;
        int distinctCount=0;
        int distinct1=-1,distinct2=-1;
        int distinct1Count=0,distinct2Count=0;
        int maxLength=0;
        while(end<fruits.length){
            int cur=fruits[end];
            if(distinct1==-1){
                distinct1=cur;
                distinctCount++;
                distinct1Count++;
                maxLength=Math.max(end-start+1,maxLength);
                end++;
            }else if(distinct1!=cur && distinct2==-1){
                distinct2=cur;
                distinctCount++;
                distinct2Count++;
                maxLength=Math.max(end-start+1,maxLength);
                end++;
            }else if(cur==distinct1){
                distinct1Count++;
                maxLength=Math.max(end-start+1,maxLength);
                end++;
            }else if(cur==distinct2){
                distinct2Count++;
                maxLength=Math.max(end-start+1,maxLength);
                end++;
            }else{
                while(start<=end && (distinct1Count>0 && distinct2Count>0)){
                    int a=fruits[start];
                    if(a==distinct1){
                        distinct1Count--;
                        start++;
                    }else if(a==distinct2){
                        distinct2Count--;
                        start++;
                    }
                }
                if(distinct1Count==0){
                    distinct1Count=0;
                    distinct1=-1;
                }
                if(distinct2Count==0){
                    distinct2Count=0;
                    distinct2=-1;
                }
            }
            //System.out.println(distinct1+":"+distinct2+":"+start+":"+end+":"+distinct1Count+":"+distinct2Count);
        }
        
        return maxLength;
       

    }
}