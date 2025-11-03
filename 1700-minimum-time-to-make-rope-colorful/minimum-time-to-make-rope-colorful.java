class Key{
    char c;
    int time;
    Key(char c,int time){
        this.c=c;
        this.time=time;
    }
}
class Solution {
    public int minCost(String colors, int[] neededTime) {
        Stack<Key> st=new Stack<>();
        int total=0;
        for(int i=0;i<neededTime.length;i++){
            char c=colors.charAt(i);
            int time=neededTime[i];
            Key k=new Key(c,time);
            if(st.isEmpty()){
                st.push(k);
            }else if(st.peek().c==c){
                if(st.peek().time<k.time){
                    total+=st.peek().time;
                    st.pop();
                    st.push(k);
                }else{
                    total+=k.time;
                }
            }else{
                st.push(new Key(c,time));
            }
        }
        return total;
    }
}