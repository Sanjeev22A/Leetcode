class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> queue=new ArrayList<>();
        for(int i=1;i<=n;i++){
            queue.add(i);
        }
        int startIndex=0;
        int ans=0;
        while(!queue.isEmpty()){
            startIndex=(startIndex+k-1)%queue.size();
            if(startIndex<0){
                startIndex+=queue.size();
                startIndex%=queue.size();
            }
            int cur=queue.get(startIndex);
            queue.remove(startIndex);
            ans=cur;
            
           // startIndex=(startIndex+k)%queue.size();
        }
        return ans;
    }
}