class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        int[] indegree=new int[numCourses];
        boolean[] visited=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] a:prerequisites){
            graph.get(a[0]).add(a[1]);
            indegree[a[1]]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            visited[node]=true;
            for(int a:graph.get(node)){
                indegree[a]--;
                if(indegree[a]==0){
                    q.offer(a);
                }
            }
        }

        for(boolean a:visited){
            if(!a){
                return a;
            }
        }
        return true;
    }
}