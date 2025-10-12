class Token{
    int timeToLive;
    int startTime;
    int endTime;
    String tokenId;
    Token(int timeToLive,int startTime,int endTime,String tokenId){
        this.timeToLive=timeToLive;
        this.startTime=startTime;
        this.endTime=endTime;
        this.tokenId=tokenId;
    }
    boolean checkEqual(Token t){
        if(timeToLive==t.timeToLive && startTime==t.startTime && endTime==t.endTime && tokenId.equals(t.tokenId)){
            return true;
        }
        return false;
    }
}
class AuthenticationManager {
    PriorityQueue<Token> pq;
    Map<String,Token> map;
    int timeToLive;
    public AuthenticationManager(int timeToLive) {
        pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(a.startTime,b.startTime);
        });
        map=new HashMap<>();
        this.timeToLive=timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        Token t=new Token(timeToLive,currentTime,currentTime+timeToLive,tokenId);
        pq.offer(t);
        map.put(tokenId,t);
    }
    boolean notExpired(Token t,int currentTime){
        return t.endTime>currentTime;
    }
    public void renew(String tokenId, int currentTime) {
        if(map.containsKey(tokenId) && notExpired(map.get(tokenId),currentTime) ){
            
            Token t=map.get(tokenId);
            t=new Token(t.timeToLive,t.startTime,t.endTime,t.tokenId);
            t.startTime=currentTime;
            t.endTime=currentTime+timeToLive;
            pq.offer(t);
            map.put(tokenId,t);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        List<Token> holder=new ArrayList<>();
        int startTime=currentTime-timeToLive+1;
        int count=0;
        while(!pq.isEmpty() && pq.peek().startTime<=currentTime){
            Token t=pq.poll();
            
            if(notExpired(t,currentTime)){
                Token temp=map.get(t.tokenId);
                if(temp==null){
                    continue;
                }
                if(temp.checkEqual(t)){
                    count++;
                    holder.add(temp);
                }
            }else{
                Token temp=map.get(t.tokenId);
                if(temp.checkEqual(t)){
                    map.remove(t.tokenId);
                }
            }
        }
        for(Token t:holder){
            pq.offer(t);
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */