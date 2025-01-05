class Solution {
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int visitedCount=0;
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visitedArray=new boolean[rooms.size()];
        queue.offer(0);
        while(!queue.isEmpty()){
            int val=queue.poll();
            if(visitedArray[val]){
                continue;
            }
            else{
                visitedArray[val]=true;
                visitedCount++;
                for(int cur:rooms.get(val)){
                    if(!visitedArray[cur]){
                        queue.offer(cur);
                    }
                }
            }
        }
        return visitedCount==rooms.size();
    }
}