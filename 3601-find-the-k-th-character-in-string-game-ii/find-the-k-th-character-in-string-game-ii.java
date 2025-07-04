class Solution {
    List<Integer> op;
    void getChar(long k,int[] operations){
        if(k<=1){
            return;
        }
        long pow=1;
        int t=0;
        while(k>pow){
            t++;
            pow*=2;
            
        }
        k=k-pow/2;
        op.add(operations[t-1]);
        getChar(k,operations);
    }
    public char kthCharacter(long k, int[] operations) {
        op=new ArrayList<>();
        getChar(k,operations);
        char cur='a';
        int val=0;
        for(int o:op){
            System.out.println(o);
            if(o==1){
                val++;
            }
            
        }
        cur=(char)(cur+(val%26));
        return cur;
    }
}