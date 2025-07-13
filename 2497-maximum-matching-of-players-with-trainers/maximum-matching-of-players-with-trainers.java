class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Thread t1=new Thread(()->Arrays.sort(players));
        Thread t2=new Thread(()->Arrays.sort(trainers));
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(Exception e){
            
        }
        
        
        int i=0,j=0,count=0;
        while(i<players.length && j<trainers.length){
            if(players[i]<=trainers[j]){
                count++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return count;
    }
}