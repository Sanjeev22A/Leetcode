class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         List<List<Integer>> graph=new ArrayList<>();
        int[] indegree=new int[numCourses];
        boolean[] visited=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] a:prerequisites){
            graph.get(a[1]).add(a[0]);
            indegree[a[0]]++;
        }
        int id=0;
        int[] order=new int[numCourses];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
                
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            visited[node]=true;
            order[id++]=node;
            for(int a:graph.get(node)){
                indegree[a]--;
                if(indegree[a]==0){
                    q.offer(a);
                    
                }
            }
        }
        for(boolean a:visited){
            if(!a){
                return new int[0];
            }
        }
        return order;
    }
}