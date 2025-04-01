class Solution {
    Map<Integer,Long> memo;
    long recurse(int idx,int[][] questions,int size){

        if(idx>=size){
            return (long)0;
        }
        else if(memo.containsKey(idx)){
            return memo.get(idx);
        }
        else{
            long take=questions[idx][0]+recurse(idx+1+questions[idx][1],questions,size);
            long leave=recurse(idx+1,questions,size);
            long val=Math.max(take,leave);
            memo.put(idx,val);
            return val;
        }
    }
    public long mostPoints(int[][] questions) {
        memo=new HashMap<>();
        return recurse(0,questions,questions.length);

    }
}