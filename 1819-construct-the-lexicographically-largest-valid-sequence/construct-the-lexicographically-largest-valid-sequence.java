class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] resultSequence=new int[2*n-1];
        boolean[] isNumberUsed=new boolean[n+1];
        findSequence(0,resultSequence,isNumberUsed,n);
        return resultSequence;
    }
    boolean findSequence(int currentIndex,int[] resultSequence,boolean[] isNumberUsed,int targetNumber){
        if(currentIndex==resultSequence.length){return true;}
        if(resultSequence[currentIndex]!=0){
            if(findSequence(currentIndex+1,resultSequence,isNumberUsed,targetNumber)){return true;}
        }
        else{
            for(int i=targetNumber;i>=1;i--){
                if(!isNumberUsed[i]){
                    resultSequence[currentIndex]=i;
                    isNumberUsed[i]=true;
                    if(i==1){
                        if(findSequence(currentIndex+1,resultSequence,isNumberUsed,targetNumber)){return true;}
                    }else{
                        if(currentIndex+i<resultSequence.length && resultSequence[currentIndex+i]==0){
                            resultSequence[currentIndex+i]=i;
                            if(findSequence(currentIndex+1,resultSequence,isNumberUsed,targetNumber)){return true;}
                            resultSequence[currentIndex+i]=0;
                        }
                        
                    }
                    isNumberUsed[i]=false;
                    resultSequence[currentIndex]=0;
                }
            }
            return false;
        }
        return false;
    }
}