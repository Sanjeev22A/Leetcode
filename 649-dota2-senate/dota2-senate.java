class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rad,dir;
        rad=new LinkedList<>();
        dir=new LinkedList<>();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){rad.offer(i);}
            else{dir.offer(i);}
        }
        int n=senate.length();
        while(!rad.isEmpty()&&!dir.isEmpty()){
            if(rad.peek()<dir.peek()){
                rad.offer(n++);
            }
            else{dir.offer(n++);}
            rad.poll();
            dir.poll();
            
        }
        if(!rad.isEmpty()){
            return "Radiant";
        }
        else{
            return "Dire";
        }
   }
}