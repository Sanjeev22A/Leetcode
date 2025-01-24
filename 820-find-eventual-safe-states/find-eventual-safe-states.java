class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] inDegree=new int[graph.length];
        List<List<Integer>> revGraph=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            revGraph.add(new ArrayList<>());
        }
        Queue<Integer> queue=new LinkedList<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                revGraph.get(graph[i][j]).add(i);
                inDegree[i]++;
            }
            if(inDegree[i]==0){
                result.add(i);
                queue.offer(i);
            }


        }

        while(!queue.isEmpty()){
            int cur=queue.poll();
            for(int a:revGraph.get(cur)){
                if(inDegree[a]==0){
                    continue;
                }else{
                    inDegree[a]--;
                    if(inDegree[a]==0){
                        queue.offer(a);
                        result.add(a);
                    }
                }
            }
        }
        Collections.sort(result);
        return result;

        

    }
}