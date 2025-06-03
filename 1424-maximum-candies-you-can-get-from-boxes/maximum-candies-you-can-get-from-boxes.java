class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n=candies.length;
        Queue<Integer> q=new LinkedList<>();
        boolean[] hasObtained=new boolean[n];
        boolean[] hasKey=new boolean[n];
        boolean[] visited=new boolean[n];
        for(int a:initialBoxes){
            q.offer(a);
            hasObtained[a]=true;
            if(status[a]==1){
                hasKey[a]=true;
            }
            
        }
        int res=0;
        while(!q.isEmpty()){
            int box=q.poll();
            if(!visited[box]){
                if(status[box]==1){
                    res+=candies[box];
                    
                    visited[box]=true;
                    for(int cont:containedBoxes[box]){
                        if(visited[cont]){
                            continue;
                        }
                        hasObtained[cont]=true;
                        q.offer(cont);
                    }
                    for(int key:keys[box]){
                        hasKey[key]=true;
                    }
                }else if(hasKey[box]==true){
                    res+=candies[box];
                    visited[box]=true;
                    for(int cont:containedBoxes[box]){
                        if(visited[cont]){
                            continue;
                        }
                        hasObtained[cont]=true;
                        q.offer(cont);
                    }
                    for(int key:keys[box]){
                        hasKey[key]=true;
                    }
                }else{
                    q.offer(box);
                }
            }
            
            boolean flag=checkIfStopping(visited,hasObtained,hasKey,status);
            if(!flag){
                return res;
            }
        }
        return 0;
       

    }

     boolean checkIfStopping(boolean[] visited,boolean[] hasObtained,boolean[] hasKey,int[] status){
            int n=visited.length;
            for(int i=0;i<n;i++){
                if(!visited[i] && hasObtained[i] && (hasKey[i] || status[i]==1)){
                    return true;
                }
            }
            return false;
    }

}